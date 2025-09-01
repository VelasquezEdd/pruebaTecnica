package com.example.Prueba1.controladores;

import com.example.Prueba1.modelos.Cliente;
import com.example.Prueba1.servicios.ClienteServicio;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteControlador {

    private final ClienteServicio servicio;

    public ClienteControlador(ClienteServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Cliente> listar() {
        return servicio.listar();
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return servicio.guardar(cliente);
    }
}
