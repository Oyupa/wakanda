package GestionTrafico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ServicioTrafico {

    private final List<Coche> coches = Collections.synchronizedList(new ArrayList<>());
    private final int MAX_TRAFICO = 100;  // Máximo número de coches permitido

    @Autowired
    private Semaforo semaforo;

    @Autowired
    private Estacionamiento estacionamiento;

    @Autowired
    private ApplicationContext context;

    // Añadir un coche al tráfico
    public String agregarCoche() {
        if (coches.size() < MAX_TRAFICO) {
            Coche coche = context.getBean(Coche.class, coches.size() + 1);
            coches.add(coche);
            coche.start(); // Inicia el hilo del coche
            return "Coche " + coche.getId() + " agregado al tráfico.";
        } else {
            return "El tráfico está lleno. No se pueden agregar más coches.";
        }
    }

    // Verificar el estado del tráfico
    public String verificarTrafico() {
        int nivelTrafico = (coches.size() * 100) / MAX_TRAFICO;
        semaforo.ajustarDuracion(); // Ajusta la duración del semáforo según el nivel de tráfico
        return "Nivel actual de tráfico: " + nivelTrafico + "% (" + coches.size() + " coches).";
    }

    // Regular el tráfico eliminando un 20% de coches
    public String regularTrafico() {
        int nivelTrafico = (coches.size() * 100) / MAX_TRAFICO;
        if (nivelTrafico > 70) {
            int cochesAEliminar = (int) (coches.size() * 0.2); // 20% de los coches
            for (int i = 0; i < cochesAEliminar; i++) {
                Coche coche = coches.remove(0); // Elimina el primer coche
                coche.detener(); // Detiene su hilo
            }
            return cochesAEliminar + " coches eliminados para regular el tráfico.";
        } else {
            return "El nivel de tráfico está por debajo del umbral. No es necesario regular.";
        }
    }

    // Obtener la lista de coches
    public List<Coche> getCoches() {
        return coches;
    }

    // Obtener el máximo tráfico permitido
    public int getMaxTrafico() {
        return MAX_TRAFICO;
    }
}
