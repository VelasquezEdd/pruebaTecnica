package com.example.Prueba1.servicios;

import com.example.Prueba1.modelos.Departamento;
import com.example.Prueba1.repositorios.DepartamentoRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartamentoServicio {
    private final DepartamentoRepositorio repositorio;

    public DepartamentoServicio(DepartamentoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Departamento> listar() {
        return repositorio.findAll();
    }

    public Departamento guardar(Departamento dep) {
        return repositorio.save(dep);
    }
    public List<Departamento> listarPorPais(Long idPais) {
        return repositorio.findByPais_IdPais(idPais);
    }
}
