import java.util.*;
import java.util.concurrent.*;

public class evidencia3 {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("EVIDENCIA 3 JAVA:");
            System.out.print("Presiona 1 para continuar \nPresiona 2 para salir \nElige una opcion: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    algoritmo();
                    break;
                case 2:
                    scheduler.shutdown(); // Detener el scheduler
                    return;
                default:
                    System.out.println("\nElige una opcion valida!!!\n");
                    break;
            }
        }
    }

    public static void algoritmo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el tiempo total de ejecución en segundos: ");
        int tiempoTotal = scanner.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(6);
        Map<String, Integer> ordenados = new ConcurrentHashMap<>();
        Map<String, Double> tiempos = new ConcurrentHashMap<>();

        List<Future<?>> futures = new ArrayList<>();
        List<Integer> tamaños = Arrays.asList(100, 50000, 100000);

        for (String algoritmo : Arrays.asList("Merge Sort", "Bubble Sort", "Shell Sort", "Selection Sort", "Insertion Sort", "Quick Sort")) {
            for (int tam : tamaños) {
                Future<?> future = executor.submit(() -> {
                    long startTime = System.currentTimeMillis();
                    int ordenadosPorAlgoritmo = 0;

                    while ((System.currentTimeMillis() - startTime) < (tiempoTotal * 1000)) {
                        int[] arreglo;
                        if (algoritmo.equals("Quick Sort")) {
                            arreglo = generarArregloV2(tam);
                        } else {
                            arreglo = generarArreglo(tam);
                        }
                        ordenar(arreglo, algoritmo);
                        ordenadosPorAlgoritmo++;
                    }
                    ordenados.put(algoritmo + " - Tamaño " + tam, ordenadosPorAlgoritmo);
                    double tiempoPromedio = (double) (System.currentTimeMillis() - startTime) / ordenadosPorAlgoritmo;
                    tiempos.put(algoritmo + " - Tamaño " + tam, tiempoPromedio);
                });
                futures.add(future);
            }
        }

        scheduler.schedule(() -> {
            // Cancelar todas las tareas pendientes después del tiempo total especificado
            futures.forEach(future -> future.cancel(true));
        }, tiempoTotal, TimeUnit.SECONDS);

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (CancellationException e) {
                System.err.println("Tarea cancelada: " + e.getMessage());
            }
        }

        executor.shutdown();

        List<Map.Entry<String, Double>> list = new ArrayList<>(tiempos.entrySet());
        list.sort(Map.Entry.comparingByValue());

        System.out.println("Resultados:");
        for (Map.Entry<String, Double> entry : list) {
            String algoritmo = entry.getKey();
            int cantidadOrdenada = ordenados.get(algoritmo);
            double tiempoPromedio = entry.getValue();

            if(tiempoPromedio < 1000){
                String tiempoFormateado = String.format("%.5f", tiempoPromedio);
                System.out.println(algoritmo + ": Colecciones ordenadas = " + cantidadOrdenada + ", Tiempo promedio por colección = " + tiempoFormateado + " ms");
            }
            else if(tiempoPromedio >= 1000){
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
