package GestionTrafico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trafico")
public class ControladorTrafico {

    @Autowired
    private ServicioTrafico servicioTrafico;

    @PostMapping("/agregarCoche")
    public String agregarCoche() {
        return servicioTrafico.agregarCoche();
    }

    @GetMapping("/estadoTrafico")
    public String estadoTrafico() {
        return servicioTrafico.verificarTrafico();
    }

    @PostMapping("/regularTrafico")
    public String regularTrafico() {
        return servicioTrafico.regularTrafico();
    }
}
