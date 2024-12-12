package GestionTrafico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Semaforo {

    private int duracionLuzVerde = 30; // Duración inicial en segundos

    @Autowired
    private Sensor sensor;

    public void ajustarDuracion() {
        int nivelTrafico = sensor.detectarNivelTrafico();
        if (nivelTrafico > 70) {
            duracionLuzVerde = 15; // Reduce el tiempo en tráfico alto
        } else if (nivelTrafico < 30) {
            duracionLuzVerde = 45; // Aumenta el tiempo en tráfico bajo
        }
        System.out.println("Duración de la luz verde ajustada a " + duracionLuzVerde + " segundos.");
    }

    public int getDuracionLuzVerde() {
        return duracionLuzVerde;
    }
}
