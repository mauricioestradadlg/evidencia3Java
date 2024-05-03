import java.util.*;
import java.util.concurrent.*;

public class evidencia3 {
    public static void main(String[] args) {

        boolean ciclo = true;
        Scanner scanner = new Scanner(System.in);


        while(ciclo){

            System.out.println("EVIDENCIA 3 JAVA: ");
        System.out.print("Presiona 1 para continuar \nPresiona 2 para salir \nElige una opcion: ");
        int option = scanner.nextInt();

        switch(option){

            case 1:
            algoritmo();

            System.out.println("\n");
            System.out.print("Quieres hacer otra prueba? \nPresiona 1 para continuar \nPresiona 2 para salir \nElige una opcion: ");
            int opcion = scanner.nextInt();

            if(opcion== 1){
                System.out.println("\n \n");
            }
            else if(opcion == 2){
                ciclo = false;
            }

                break;
            case 2:
                ciclo = false;
                break;
            default:
                System.out.println("\n");
                System.out.println("Elige una opcion valida!!!");
                System.out.println("\n");
                break;        
        }

        }

        

        


    }

    public static void algoritmo(){

       
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Ingrese el tiempo total de ejecución en segundos: ");
        int tiempoTotal = scanner.nextInt();
    
        // Crear un ExecutorService que manejará la ejecución de las tareas de ordenamiento
        ExecutorService executor = Executors.newFixedThreadPool(6);

        // Mapa para almacenar el número de colecciones ordenadas por cada algoritmo
        Map<String, Integer> ordenados = new ConcurrentHashMap<>();

        // Mapa para almacenar el tiempo promedio por colección para cada algoritmo
        Map<String, Double> tiempos = new ConcurrentHashMap<>();
    
        // Lista de objetos Future que contendrán los resultados de las tareas de ordenamiento
        List<Future<?>> futures = new ArrayList<>();
    
        // Lista de tamaños de arreglos que se utilizarán en las pruebas de ordenamiento
        List<Integer> tamaños = Arrays.asList(100, 50000, 100000, 100000);
        
        // Iterar sobre cada algoritmo de ordenamiento y tamaño de arreglo
        for (String algoritmo : Arrays.asList("Merge Sort", "Bubble Sort", "Shell Sort", "Selection Sort", "Insertion Sort", "Quick Sort")) {
            for (int tam : tamaños) {
                // Crear una tarea y enviarla al ExecutorService para su ejecución
                Future<?> future = executor.submit(() -> {
                    // Tiempo de inicio de la ejecución de la tarea
                    long startTime = System.currentTimeMillis();
    
                    // Contador para el número de colecciones ordenadas por este algoritmo
                    int ordenadosPorAlgoritmo = 0;
    
                    // Realizar la ordenación mientras no haya transcurrido el tiempo total especificado
                    while (System.currentTimeMillis() - startTime < tiempoTotal * 1000) {
                        int[] arreglo;
                        if (algoritmo.equals("Quick Sort")) {
                            arreglo = generarArregloV2(tam);
                        } else {
                            arreglo = generarArreglo(tam);
                        }
                        // Llamar al método de ordenamiento correspondiente
                        ordenar(arreglo, algoritmo);
                        ordenadosPorAlgoritmo++;
                    }
                    // Registrar el número total de colecciones ordenadas por este algoritmo
                    ordenados.put(algoritmo + " - Tamaño " + tam, ordenadosPorAlgoritmo);
                    // Calcular el tiempo promedio por colección para este algoritmo
                    double tiempoPromedio = (double) (System.currentTimeMillis() - startTime) / ordenadosPorAlgoritmo;
                    // Almacenar el tiempo promedio en el mapa de tiempos
                    tiempos.put(algoritmo + " - Tamaño " + tam, tiempoPromedio);
                });
                // Agregar el objeto Future a la lista de futuros para su seguimiento
                futures.add(future);
            }
        }
    
        // Esperar a que todas las tareas de ordenamiento se completen
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    
        // Detener el ExecutorService después de que se completen todas las tareas
        executor.shutdown();
    
        // Ordenar los algoritmos por eficiencia (tiempo promedio por colección)
        List<Map.Entry<String, Double>> list = new ArrayList<>(tiempos.entrySet());
        list.sort(Map.Entry.comparingByValue());
    
        // Imprimir los resultados de las pruebas de ordenamiento
        System.out.println("Resultados:");
        for (Map.Entry<String, Double> entry : list) {
            String algoritmo = entry.getKey();
            int cantidadOrdenada = ordenados.get(algoritmo);
            double tiempoPromedio = entry.getValue();
    
            // Formatear el tiempo promedio según sea necesario
            if(tiempoPromedio < 1000){
                // Redondear el tiempo promedio a 5 decimales y mostrar en milisegundos
                String tiempoFormateado = String.format("%.5f", tiempoPromedio);
                System.out.println(algoritmo + ": Colecciones ordenadas = " + cantidadOrdenada + ", Tiempo promedio por colección = " + tiempoFormateado + " ms");
            }
            else if(tiempoPromedio >= 1000){
                // Convertir el tiempo promedio a segundos y redondear a 5 decimales
                tiempoPromedio = tiempoPromedio/1000;
                String tiempoFormateado = String.format("%.5f", tiempoPromedio);
                System.out.println(algoritmo + ": Colecciones ordenadas = " + cantidadOrdenada + ", Tiempo promedio por colección = " + tiempoFormateado + " segundos");
            }
        }
    }
    

    public static void ordenar(int[] arreglo, String algoritmo) {
        switch (algoritmo) {
            case "Merge Sort":
                mergeSort(arreglo);
                break;
            case "Bubble Sort":
                bubbleSort(arreglo);
                break;
            case "Shell Sort":
                shellSort(arreglo);
                break;
            case "Selection Sort":
                selectionSort(arreglo);
                break;
            case "Insertion Sort":
                insertionSort(arreglo);
                break;
            case "Quick Sort":
                quickSort(arreglo, 0, arreglo.length - 1);
                break;
            default:
                break;
        }
    }

    public static int[] generarArreglo(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000); // Números aleatorios del 0 al 999
        }
        return arr;
    }

    public static int[] generarArregloV2(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(6) + 1; // Números aleatorios del 1 al 5
        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Intercambiar elementos
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= intervalo && arr[j - intervalo] > temp; j -= intervalo) {
                    arr[j] = arr[j - intervalo];
                }
                arr[j] = temp;
            }
        }
    }

    private static void mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) return; //base case

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //left array
        int j = 0; //right array

        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        if (end <= start) return; //base case

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }
}
