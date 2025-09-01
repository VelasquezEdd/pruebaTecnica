package com.example.Prueba1.controladores;

import com.example.Prueba1.modelos.Pais;
import com.example.Prueba1.servicios.PaisServicio;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/paises")
@CrossOrigin("*")
public class PaisControlador {

    private final PaisServicio servicio;

    public PaisControlador(PaisServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Pais> listar() {
        return servicio.listar();
    }

    @PostMapping
    public Pais guardar(@RequestBody Pais pais) {
        return servicio.guardar(pais);
    }
}
