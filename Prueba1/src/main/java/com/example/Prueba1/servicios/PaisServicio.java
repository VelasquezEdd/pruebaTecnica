package com.example.Prueba1.servicios;

import com.example.Prueba1.modelos.Pais;
import com.example.Prueba1.repositorios.PaisRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaisServicio {
    private final PaisRepositorio repositorio;

    public PaisServicio(PaisRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Pais> listar() {
        return repositorio.findAll();
    }

    public Pais guardar(Pais pais) {
        return repositorio.save(pais);
    }
}
