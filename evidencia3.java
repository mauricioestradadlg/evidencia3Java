
import java.util.Scanner;


public class evidencia3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        //INICIO
        
        System.out.print("Ingrese el tiempo de ejecución en segundos: ");
        int duration = scanner.nextInt();
        
        long start = System.currentTimeMillis();
        long end = start + duration * 1000; // Convertir segundos a milisegundos



        //ALGORITMO
        
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
    }

}


