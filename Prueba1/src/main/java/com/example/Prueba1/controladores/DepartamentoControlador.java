package com.example.Prueba1.controladores;

import com.example.Prueba1.modelos.Departamento;
import com.example.Prueba1.servicios.DepartamentoServicio;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin("*")
public class DepartamentoControlador {

    private final DepartamentoServicio servicio;

    public DepartamentoControlador(DepartamentoServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Departamento> listar() {
        return servicio.listar();
    }

    @GetMapping("/porPais/{idPais}")
    public List<Departamento> listarPorPais(@PathVariable Long idPais) {
        return servicio.listarPorPais(idPais);
    }

    @PostMapping
    public Departamento guardar(@RequestBody Departamento departamento) {
        return servicio.guardar(departamento);
    }
}
