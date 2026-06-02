import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        Baraja baraja = new Baraja();

        baraja.cargarCartas();
        int opcion=0;
        do {
            System.out.println("Bienvenido, ingrese una opcion");
            try {
                System.out.println("1) Barajar Mazo\n" +
                       "2) Obtener siguiente carta\n" +
                       "3) Consultar cartas disponibles\n" +
                       "4) Repartir cartas\n" +
                       "5) Mostrar cartas repartidas\n" +
                       "6) Mostrar cartas en la baraja\n" +
                       "7) Salir\n" +
                       "A continuacion ingrese una de las opciones disponibles: ");
                opcion = leer.nextInt();
                
                if (opcion == 1) {
                    baraja.Barajar();
                } else if (opcion == 2) {
                    // Hacer esta funcion
                    baraja.siguienteCarta();
                } else if (opcion == 3) {
                    System.out.println("La cantidad de cartas disponibles en la baraja es de: " + baraja.cantidadCartasDisponibles());
                } else if (opcion == 4) {
                    System.out.println("Ingrese la cantidad de cartas a repartir");
                    // Ingresar la cantidad de cartas que se van a repartir y validar que hayan suficientes en el mazo junto a que sean numeros validos
                    baraja.repartir(opcion);
                } else if (opcion == 5){
                    baraja.cartasRepartidas();
                } else if (opcion == 6){
                    baraja.cartasDisponibles();
                } else if (opcion == 7){
                    System.out.println("Hasta luego");
                    break;
                } else{
                    System.out.println("Error, el numero ingresado no pertenece a ninguna opcion disponible actualmente. Vuelva a ingresar un numero");
                }
            } catch (Exception e) {
                System.out.println("Error, valor no valido ingresado. Ingrese por consola el numero de la operacion que desea realizar");
                leer.nextLine();
            }
        } while (true);
    }
}
