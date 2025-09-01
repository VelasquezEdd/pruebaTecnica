package com.example.Prueba1.modelos;

import jakarta.persistence.*;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    private String nombre;

    // Getters y setters
    public Long getIdPais() { return idPais; }
    public void setIdPais(Long idPais) { this.idPais = idPais; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
