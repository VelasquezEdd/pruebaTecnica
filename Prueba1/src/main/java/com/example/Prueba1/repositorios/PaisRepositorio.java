package com.example.Prueba1.repositorios;

import com.example.Prueba1.modelos.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepositorio extends JpaRepository<Pais, Long> {
}