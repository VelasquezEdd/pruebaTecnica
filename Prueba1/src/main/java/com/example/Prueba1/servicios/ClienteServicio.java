package com.example.Prueba1.servicios;

import com.example.Prueba1.modelos.Cliente;
import com.example.Prueba1.repositorios.ClienteRepositorio;
import com.example.Prueba1.repositorios.PaisRepositorio;
import com.example.Prueba1.repositorios.DepartamentoRepositorio;
import com.example.Prueba1.repositorios.CiudadRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServicio {

    private final ClienteRepositorio clienteRepo;
    private final PaisRepositorio paisRepo;
    private final DepartamentoRepositorio deptoRepo;
    private final CiudadRepositorio ciudadRepo;

    public ClienteServicio(ClienteRepositorio clienteRepo,
                           PaisRepositorio paisRepo,
                           DepartamentoRepositorio deptoRepo,
                           CiudadRepositorio ciudadRepo) {
        this.clienteRepo = clienteRepo;
        this.paisRepo = paisRepo;
        this.deptoRepo = deptoRepo;
        this.ciudadRepo = ciudadRepo;
    }
public Cliente guardar(Cliente cliente) {
    if (cliente.getPais() != null && cliente.getPais().getIdPais() != null) {
        cliente.setPais(paisRepo.findById(cliente.getPais().getIdPais())
            .orElseThrow(() -> new RuntimeException("Pais no encontrado")));
    } else {
        throw new RuntimeException("El campo 'pais' es obligatorio.");
    }

    if (cliente.getDepartamento() != null && cliente.getDepartamento().getIdDepartamento() != null) {
        cliente.setDepartamento(deptoRepo.findById(cliente.getDepartamento().getIdDepartamento())
            .orElseThrow(() -> new RuntimeException("Departamento no encontrado")));
    } else {
        throw new RuntimeException("El campo 'departamento' es obligatorio.");
    }

    if (cliente.getCiudad() != null && cliente.getCiudad().getIdCiudad() != null) {
        cliente.setCiudad(ciudadRepo.findById(cliente.getCiudad().getIdCiudad())
            .orElseThrow(() -> new RuntimeException("Ciudad no encontrada")));
    } else {
        throw new RuntimeException("El campo 'ciudad' es obligatorio.");
    }

    if (cliente.getFechaNacimiento() == null) {
        throw new RuntimeException("El campo 'fechaNacimiento' es obligatorio.");
    }

    return clienteRepo.save(cliente);
}

    public List<Cliente> listar() {
        return clienteRepo.findAll();
    }
}
