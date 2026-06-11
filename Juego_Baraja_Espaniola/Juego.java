import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Juego {
    
    private Baraja baraja;
    private ArrayList<Jugador> jugadores;

    public Juego(ArrayList<Jugador> jugadores) {
        this.baraja = new Baraja();
        this.jugadores = jugadores;
        this.baraja.cargarCartas();
    }


    public ArrayList<Jugador> getJugadores() {return jugadores;}

    public void setJugadores(ArrayList<Jugador> jugadores) {this.jugadores = jugadores;}

    public static void reglasJuego(){
        System.out.println("REGLAS DEL JUEGO: SACAR REYES\n" +
                    "1. Objetivo del Juego\n" +
                    "El objetivo de Sacar Reyes es la supervivencia. El ganador será el último jugador que logre mantenerse en la partida sin que le salga ninguna carta con el número 12 (Rey).\n" +
                        "\n" +
                        "2. Preparación\n" +
                        "\n" +
                        "Se utiliza una baraja tradicional de 40 cartas españolas.\n" +
                        "\n" +
                        "Pueden participar entre 2 y 5 jugadores.\n" +
                        "\n" +
                        "Antes de comenzar, la baraja debe ser mezclada.\n" +
                        "\n" +
                        "3. Dinámica de Turnos y Rondas\n" +
                        "\n" +
                        "El juego se desarrolla mediante rondas sucesivas.\n" +
                        "\n" +
                        "Durante una ronda, cada jugador que siga vivo en la partida recibirá exactamente una carta de la parte superior del mazo.\n" +
                        "\n" +
                        "Al finalizar cada ronda (cuando todos los jugadores activos hayan sacado su carta), se habilitará un menú intermedio donde se podrá consultar el estado de la partida (cantidad de cartas disponibles, historial de cartas repartidas a cada jugador, etc.).\n" +
                        "\n" +
                        "4. Condición de Eliminación\n" +
                        "\n" +
                        "Al momento de recibir una carta, se verificará inmediatamente su valor.\n" +
                        "\n" +
                        "Si un jugador saca un Rey (número 12 de cualquier palo), queda automáticamente eliminado de la partida.\n" +
                        "\n" +
                        "Los jugadores eliminados ya no participan de las rondas posteriores ni reciben más cartas.\n" +
                        "\n" +
                        "Si la carta sacada es cualquier otro número (del 1 al 11), el jugador está a salvo y avanza a la siguiente ronda.\n" +
                        "\n" +
                        "5. Fin de la Partida y Ganador\n" +
                        "\n" +
                        "El juego continúa ronda tras ronda, eliminando a los jugadores que tengan la mala suerte de sacar un Rey.\n" +
                        "\n" +
                        "La partida finaliza de forma inmediata en el exacto momento en que queda un único jugador sin haber sacado un Rey.\n" +
                        "\n" +
                        "Ese último jugador en pie es declarado automáticamente como el ganador absoluto.");
    }

    public void empezarJuego(){

        Scanner leer = new Scanner(System.in);
        boolean ganador = false;
        int rondas = 1;
        boolean nuevoJuego = true;
        do {
            System.out.println("Mezclando baraja");
            baraja.Barajar();
            System.out.println();
            Collections.shuffle(jugadores);
            System.out.println("Los preparativos ya estan listos, iniciando juego");
            System.out.println(); 

            do {
                System.out.println("Ronda " + rondas);
                System.out.println();

                for (Jugador j : jugadores) {
                    if (j.getEnJuego()) {
                        System.out.println("Es el turno del jugador " + j.getNombre());
                        System.out.println("Precione ENTER para sacar una carta");
                        leer.nextLine();
                        System.out.println();

                        Carta sacada = baraja.siguienteCarta();
                        j.recibirCarta(sacada);
                        System.out.println(j.getNombre() + " saco: " + sacada.toString());
                        System.out.println();

                        if (sacada.getNumero() == 12) {
                            System.out.println("¡SALIO UN REY!");
                            System.out.println("El jugador " + j.getNombre() + " queda eliminado");
                            j.setEnJuego(false);
                            System.out.println();
                            
                        }
                    }
                }

                int jugadoresEnJuego = 0;
                for (Jugador j : jugadores) {
                    if (j.getEnJuego()) {
                        jugadoresEnJuego++;
                    }
                }
                if (jugadoresEnJuego == 1) {
                    ganador = true;
                    System.out.println("Ya no quedan mas jugadores, el ganador es " + jugadores.get(0).getNombre());
                    System.out.println();
                }else{
                    rondas ++;
                    menuRonda();
                }
            } while (!ganador);

            do {
                try {
                    System.out.println("Desea empezar una nueva partida con los mismos jugadores\n" +
                    "1) Empezar nueva partida\n" +
                    "2) Salir");
                    int opcion = Integer.parseInt(leer.nextLine());

                    if (opcion == 1) {
                        nuevoJuego = true;
                        for (Jugador j : jugadores) {
                            j.nuevaPartida();
                        }

                        baraja.nuevaPartida();
                        System.out.println("Reiniciando juego");
                        System.out.println();
                        break;

                    } else if (opcion == 2) {
                        nuevoJuego = false;
                        System.out.println("Gracias por jugar");
                        System.out.println();
                        break;
                    } else{
                        System.out.println("Error, ingrese una de las dos opciones disponibles");
                        System.out.println();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error, ingrese un numero por favor");
                    System.out.println();
                }
            } while (true);
        } while (nuevoJuego);
    }

    public void menuRonda(){
        Scanner leer = new Scanner(System.in);
        do {
            try {
                System.out.println("Bienvenido al menu intermedio de la ronda, ingrese una de las opciones disponibles");
                System.out.println("1) Cantidad de cartas disponibles en el mazo\n" +
                       "2) Cantidad de cartas repartidas\n" +
                       "3) Mostrar todas las cartas repartidas\n" +
                       "4) Mostrar todas las cartas disponibles en el mazo\n" +
                       "5) Mostrar cartas de los jugadores\n" +
                       "6) Siguiente Ronda (Salir del menu)\n" +
                       "A continuacion ingrese una de las opciones disponibles: ");
                int opcion = Integer.parseInt(leer.nextLine());
                System.out.println();

                if (opcion == 1) {
                   System.out.println("La cantidad de cartas disponibles en el mazo es de: " + baraja.cantidadCartasDisponibles());
                   System.out.println();
                }else if (opcion == 2) {
                    System.out.println("La cantidad de cartas respartidas a los jugadores es de: " + baraja.cantidadCartasRepartidas());
                    System.out.println();
                }else if (opcion == 3) {
                    baraja.cartasRepartidas();
                    System.out.println();
                }else if (opcion == 4) {
                    baraja.cartasDisponibles();
                    System.out.println("Barajando Mazo");
                    baraja.Barajar();
                    System.out.println();
                }else if (opcion == 5) {
                    for (Jugador j : jugadores) {
                        j.mostrarCartasSacadas();
                    }
                    System.out.println();                   
                }else if (opcion == 6) {
                    System.out.println("Continuando con la siguiente ronda");
                    System.out.println();
                    break;
                }else{
                    System.out.println("Error, ingrese una opcion valida");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Error, ingrese un numero por favor");
                System.out.println();
            }
        } while (true);
    }
}
