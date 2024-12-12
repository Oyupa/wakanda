package GestionTrafico;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class Estacionamiento {

    private final int capacidad = 20; // Número total de espacios
    private final Queue<Integer> espaciosDisponibles = new LinkedList<>();

    public Estacionamiento() {
        for (int i = 1; i <= capacidad; i++) {
            espaciosDisponibles.add(i); // Inicializa los espacios
        }
    }

    public synchronized String estacionarCoche(int idCoche) {
        if (espaciosDisponibles.isEmpty()) {
            return "No hay espacios de estacionamiento disponibles.";
        } else {
            int espacio = espaciosDisponibles.poll(); // Toma el primer espacio disponible
            return "Coche " + idCoche + " estacionado en el espacio " + espacio + ".";
        }
    }

    public synchronized void liberarEspacio(int espacio) {
        espaciosDisponibles.add(espacio); // Libera el espacio de estacionamiento
    }
}