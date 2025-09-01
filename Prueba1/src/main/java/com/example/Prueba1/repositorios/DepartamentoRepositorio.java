package com.example.Prueba1.repositorios;

import com.example.Prueba1.modelos.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long> {
    List<Departamento> findByPais_IdPais(Long idPais);
}
