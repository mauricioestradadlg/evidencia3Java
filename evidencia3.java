
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class evidencia3 {
    public static void main(String[] args) {

        long startTime, endTime, duration;
        
        int [] arreglo1;
        int [] arreglo2;
        int [] arreglo3;
        int [] arreglo4;
        int [] arregloAl;
      

        //ALGORITMO

        // Tomar el tiempo de inicio
        startTime = System.currentTimeMillis();

            
            // MERGE SORT

            arreglo1 = generarArreglo(100);
            arregloAl = arreglo1.clone();
            mergeSort(arregloAl);
            System.out.println("\nMerge Sort:");
            imprimirArreglo(arregloAl);

            arreglo2 = generarArreglo(50000);
            arregloAl = arreglo2.clone();
            mergeSort(arregloAl);
            System.out.println("\nMerge Sort:");
            imprimirArreglo(arregloAl);


            arreglo3 = generarArreglo(100000);
            arregloAl = arreglo3.clone();
            mergeSort(arregloAl);
            System.out.println("\nMerge Sort:");
            imprimirArreglo(arregloAl);
            
            arreglo4 = generarArregloV2(100000);
            arregloAl = arreglo4.clone();
            mergeSort(arregloAl);
            System.out.println("\nMerge Sort:");
            imprimirArreglo(arregloAl);

    


 
            // BUBBLE SORT
            arreglo1 = generarArreglo(100);
            arregloAl = arreglo1.clone();
            bubbleSort(arregloAl);
            System.out.println("\nBubble Sort:");
            imprimirArreglo(arregloAl);

            arreglo2 = generarArreglo(50000);
            arregloAl = arreglo2.clone();
            bubbleSort(arregloAl);
            System.out.println("\nBubble Sort:");
            imprimirArreglo(arregloAl);
 

            arreglo3 = generarArreglo(100000);
            arregloAl = arreglo3.clone();
            bubbleSort(arregloAl);
            System.out.println("\nBubble Sort:");
            imprimirArreglo(arregloAl);
            
            arreglo4 = generarArregloV2(100000);
            arregloAl = arreglo4.clone();
            bubbleSort(arregloAl);
            System.out.println("\nBubble Sort:");
            imprimirArreglo(arregloAl);
            





            // SHELL SORT
            arreglo1 = generarArreglo(100);
            arregloAl = arreglo1.clone();
            shellSort(arregloAl);
            System.out.println("\nShell Sort:");
            imprimirArreglo(arregloAl);
 
            arreglo2 = generarArreglo(50000);
            arregloAl = arreglo2.clone();
            shellSort(arregloAl);
            System.out.println("\nShell Sort:");
            imprimirArreglo(arregloAl);
 

            arreglo3 = generarArreglo(100000);
            arregloAl = arreglo3.clone();
            shellSort(arregloAl);
            System.out.println("\nShell Sort:");
            imprimirArreglo(arregloAl);
            
            arreglo4 = generarArregloV2(100000);
            arregloAl = arreglo4.clone();
            shellSort(arregloAl);
            System.out.println("\nShell Sort:");
            imprimirArreglo(arregloAl);

        

        // SELECTION SORT
        arreglo1 = generarArreglo(100);
        arregloAl = arreglo1.clone();
        selectionSort(arregloAl);
        System.out.println("\nSelection Sort:");
        imprimirArreglo(arregloAl);

        arreglo2 = generarArreglo(50000);
        arregloAl = arreglo2.clone();
        selectionSort(arregloAl);
        System.out.println("\nSelection Sort:");
        imprimirArreglo(arregloAl);;


        arreglo3 = generarArreglo(100000);
        arregloAl = arreglo3.clone();
        selectionSort(arregloAl);
        System.out.println("\nSelection Sort:");
        imprimirArreglo(arregloAl);
        
        arreglo4 = generarArregloV2(100000);
        arregloAl = arreglo4.clone();
        selectionSort(arregloAl);
        System.out.println("\nSelection Sort:");
        imprimirArreglo(arregloAl);




         // INSERTION SORT
         arreglo1 = generarArreglo(100);
         arregloAl = arreglo1.clone();
         insertionSort(arregloAl);
         System.out.println("\nInsertion Sort:");
         imprimirArreglo(arregloAl);
 
         arreglo2 = generarArreglo(50000);
         arregloAl = arreglo2.clone();
         insertionSort(arregloAl);
         System.out.println("\nInsertion Sort:");
         imprimirArreglo(arregloAl);
 
 
         arreglo3 = generarArreglo(100000);
         arregloAl = arreglo3.clone();
         insertionSort(arregloAl);
         System.out.println("\nInsertion Sort:");
         imprimirArreglo(arregloAl);
         
         arreglo4 = generarArregloV2(100000);
         arregloAl = arreglo4.clone();
         insertionSort(arregloAl);
         System.out.println("\nInsertion Sort:");
         imprimirArreglo(arregloAl);
       


         
         // QUICK SORT
         arreglo1 = generarArreglo(100);
         arregloAl = arreglo1.clone();
         quickSort(arregloAl, 0, arregloAl.length - 1);
         System.out.println("\nInsertion Sort:");
         imprimirArreglo(arregloAl);
 
         arreglo2 = generarArreglo(50000);
         arregloAl = arreglo2.clone();
         quickSort(arregloAl, 0, arregloAl.length - 1);
         System.out.println("\nInsertion Sort:");
         imprimirArreglo(arregloAl);
 
 
         arreglo3 = generarArreglo(100000);
         arregloAl = arreglo3.clone();
         quickSort(arregloAl, 0, arregloAl.length - 1);
         System.out.println("\nInsertion Sort:");
         imprimirArreglo(arregloAl);
         
         arreglo4 = generarArregloV2(100000);
         arregloAl = arreglo4.clone();
         quickSort(arregloAl, 0, arregloAl.length - 1);
         System.out.println("\nInsertion Sort:");
         imprimirArreglo(arregloAl);

            // Tomar el tiempo de finalización
            endTime = System.currentTimeMillis();
    
            // Calcular la duración de la ejecución
            duration = endTime - startTime;
            
            if(duration >= 1000){

                duration = duration/1000;
                System.out.println("Tiempo de ejecución: " + duration + " segundos");
            }
            else{
                System.out.println("Tiempo de ejecución: " + duration + " milisegundos");

            }
            
        }

    
        
        /* 

        //INICIO

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el tiempo de ejecución en segundos: ");
        int duration = scanner.nextInt();
        
        long start = System.currentTimeMillis();
        long end = start + duration * 1000; // Convertir segundos a milisegundos

        //Algoritmo

        while (System.currentTimeMillis() < end) {
            System.out.println("Hola mundo");
            // Pausa de 1 segundo para no imprimir demasiado rápido
            try {
                Thread.sleep(1000); // Pausa de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //FIN
        
        System.out.println("Tiempo de ejecución terminado.");
        scanner.close();

*/
        
    

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
            arr[i] = random.nextInt(6); // Números aleatorios del 0 al 5
        }
        return arr;
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.println(Arrays.toString(arr));
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
		
		for(; i < length; i++) {
			if(i < middle) {
				leftArray[i] = array[i];
			}
			else {
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
		while(l < leftSize && r < rightSize) {
			if(leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			}
			else {
				array[i] = rightArray[r];
				i++;
				r++;
			}
		}
		while(l < leftSize) {
			array[i] = leftArray[l];
			i++;
			l++;
		}
		while(r < rightSize) {
			array[i] = rightArray[r];
			i++;
			r++;
		}
	}

    private static void quickSort(int[] array, int start, int end) {
		
		if(end <= start) return; //base case
		
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);		
	}


	private static int partition(int[] array, int start, int end) {
		
		int pivot = array[end];
		int i = start - 1;
		
		for(int j = start; j <= end; j++) {
			if(array[j] < pivot) {
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




