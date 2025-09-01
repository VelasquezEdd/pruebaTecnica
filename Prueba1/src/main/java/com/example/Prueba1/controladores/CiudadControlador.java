package com.example.Prueba1.controladores;

import com.example.Prueba1.modelos.Ciudad;
import com.example.Prueba1.servicios.CiudadServicio;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
@CrossOrigin("*")
public class CiudadControlador {
    private final CiudadServicio servicio;

    public CiudadControlador(CiudadServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Ciudad> listar() {
        return servicio.listar();
    }

    @GetMapping("/porDepartamento/{idDepartamento}")
    public List<Ciudad> listarPorDepartamento(@PathVariable Long idDepartamento) {
        return servicio.listarPorDepartamento(idDepartamento);
    }

    @PostMapping
    public Ciudad guardar(@RequestBody Ciudad ciudad) {
        return servicio.guardar(ciudad);
    }
}
