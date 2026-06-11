import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int validarNumero(){
        Scanner leer = new Scanner(System.in);
        int jugadores = 0;
        do {
            try {
                jugadores = Integer.parseInt(leer.nextLine());
                if (jugadores < 2 || jugadores > 5) {
                    System.out.println("Error, la cantidad de jugadores no puede ser menor a 2 o mayor a 5. Vuelva a ingresar la cantidad");
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, ingrese numeros no cualquier otro valor");
                System.out.println();
            }
        } while (jugadores < 2 || jugadores > 5);
        return jugadores;
    }
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);


        do {
            System.out.println("--- SACAR REYES ---");
            System.out.println("Bienvenido, ingrese una opcion");
            try {
                System.out.println("1) Reglas Juego\n" +
                       "2) Empezar Juego\n" +
                       "3) Salir\n" +
                       "A continuacion ingrese una de las opciones disponibles: ");
                int opcion = Integer.parseInt(leer.nextLine());
                
                if (opcion == 1) {
                    Juego.reglasJuego();
                }else if (opcion == 2) {
                    System.out.println("Primero ingrese la cantidad de jugadores (entre 2 y 5)");
                    int jugadores = validarNumero();

                    ArrayList<Jugador> listaJugadores = new ArrayList<>();
                    for (int i = 1; i <= jugadores; i++) {
                        System.out.println("Ingrese el nombre del jugador " + i);
                        String nombre = leer.nextLine();

                        Jugador jugador = new Jugador(nombre);
                        listaJugadores.add(jugador);
                    }
                    
                    Juego nuevoJuego = new Juego(listaJugadores);
                    nuevoJuego.empezarJuego();
                } else if (opcion == 3){
                    System.out.println("Hasta luego");
                    break;
                } else{
                    System.out.println("Error, el numero ingresado no pertenece a ninguna opcion disponible actualmente. Vuelva a ingresar un numero");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Error, valor no valido ingresado. Ingrese por consola el numero de la operacion que desea realizar");
                System.out.println();
            }
        } while (true);
    }
}
