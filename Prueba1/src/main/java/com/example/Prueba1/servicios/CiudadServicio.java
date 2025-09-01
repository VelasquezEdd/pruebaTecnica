package com.example.Prueba1.servicios;

import com.example.Prueba1.modelos.Ciudad;
import com.example.Prueba1.repositorios.CiudadRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CiudadServicio {

    private final CiudadRepositorio repositorio;

    public CiudadServicio(CiudadRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Ciudad> listar() {
        return repositorio.findAll();
    }

    public Ciudad guardar(Ciudad ciudad) {
        return repositorio.save(ciudad);
    }

    public List<Ciudad> listarPorDepartamento(Long idDepartamento) {
        return repositorio.findByDepartamento_IdDepartamento(idDepartamento);
    }
}
