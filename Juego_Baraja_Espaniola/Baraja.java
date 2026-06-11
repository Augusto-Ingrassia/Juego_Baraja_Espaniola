import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    
    private ArrayList<Carta> disponibles;
    private ArrayList<Carta> repartidas;

    public Baraja() {
        this.disponibles = new ArrayList<>();
        this.repartidas = new ArrayList<>();
    }

    public void cargarCartas(){
        String [] palo = {"Basto", "Copa", "Oro", "Espada"};
        
        for (String p : palo) {
            for (int i = 1; i <= 10; i++) {
                if (i == 8 || i == 9 || i == 10) {
                    disponibles.add(new Carta(p, i + 2));
                }else{
                    disponibles.add(new Carta(p, i));
                }
            }
        }
    }

    public void Barajar(){
        Collections.shuffle(disponibles);
    }

    public Carta siguienteCarta(){
        Carta sacada = disponibles.remove(0);
        repartidas.add(sacada);
        return sacada;
    }

    public int cantidadCartasDisponibles(){
        return disponibles.size();
    }

    public int cantidadCartasRepartidas(){
        return repartidas.size();
    }

    public void cartasRepartidas(){
        if (repartidas.size() == 0) {
            System.out.println("Aun no se han repartido cartas");
        } else {
            System.out.println("En total se han repartido " + repartidas.size() + " cartas las cuales son: ");
            for (Carta c : repartidas) {
                System.out.println(c.toString());
            }
        }
    }

    public void cartasDisponibles(){
        if (disponibles.size() == 0) {
            System.out.println("No quedan cartas en la baraja");
        } else {
            System.out.println("En total quedan " + cantidadCartasDisponibles() + " cartas en la baraja las cuales son: ");
            for (Carta c : disponibles) {
                System.out.println(c.toString());
            }
        }
    }

    public void nuevaPartida(){
        disponibles.clear();
        repartidas.clear();
        cargarCartas();
    }
}
