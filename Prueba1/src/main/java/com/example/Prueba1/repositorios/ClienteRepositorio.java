package com.example.Prueba1.repositorios;

import com.example.Prueba1.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}