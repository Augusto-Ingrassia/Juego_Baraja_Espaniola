import java.util.ArrayList;

public class Jugador {
    
    private String nombre;
    private boolean enJuego;
    private ArrayList<Carta> cartasSacadas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.enJuego = true;
        this.cartasSacadas = new ArrayList<>();
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Boolean getEnJuego() {return enJuego;}

    public void setEnJuego(Boolean enJuego) {this.enJuego = enJuego;}

    public ArrayList<Carta> getCartasSacadas() {return cartasSacadas;}

    public void setCartasSacadas(ArrayList<Carta> cartasSacadas) {this.cartasSacadas = cartasSacadas;}
    
    public void recibirCarta(Carta c){
        cartasSacadas.add(c);
    }

    public void mostrarCartasSacadas(){
        System.out.println("Estado del jugador");
        if (enJuego == true) {
            System.out.println("En juego");
        } else {
            System.out.println("Eliminado");
        }
        System.out.println("Cartas sacadas por el jugador " + nombre + ":");
        for (Carta c : cartasSacadas) {
            System.out.println("- " + c.toString());
        }
    }

    public void nuevaPartida(){
        this.enJuego = true;
        this.cartasSacadas.clear();
    }
}
