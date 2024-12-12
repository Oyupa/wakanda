package GestionTrafico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Sensor {

    @Autowired
    private ServicioTrafico servicioTrafico;

    // Detecta el nivel de tráfico basado en la cantidad de coches
    public int detectarNivelTrafico() {
        List<Coche> coches = servicioTrafico.getCoches();
        int maxTrafico = servicioTrafico.getMaxTrafico();
        return (coches.size() * 100) / maxTrafico;
    }
}
