package GestionTrafico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Coche extends Thread {
    private int id;               // Identificador único del coche
    private boolean activo = true; // Estado del coche (activo o no)

    @Autowired
    private Estacionamiento estacionamiento;

    public Coche(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (activo) {
                System.out.println("Coche " + id + " está circulando.");
                Thread.sleep(1000); // Simula que el coche circula cada segundo
            }
            System.out.println("Coche " + id + " ha detenido su circulación.");
        } catch (InterruptedException e) {
            System.out.println("Coche " + id + " fue interrumpido.");
        }
    }

    public void detener() {
        activo = false; // Termina el hilo del coche
    }

    public long getId() {
        return id;
    }

    private void estacionar() {
        String resultado = estacionamiento.estacionarCoche(id);
        System.out.println(resultado);
    }
}

