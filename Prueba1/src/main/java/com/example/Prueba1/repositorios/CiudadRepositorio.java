package com.example.Prueba1.repositorios;

import com.example.Prueba1.modelos.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CiudadRepositorio extends JpaRepository<Ciudad, Long> {
    List<Ciudad> findByDepartamento_IdDepartamento(Long idDepartamento);
}
