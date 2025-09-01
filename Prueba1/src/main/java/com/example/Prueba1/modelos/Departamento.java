package com.example.Prueba1.modelos;

import jakarta.persistence.*;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    // Getters y setters
    public Long getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(Long idDepartamento) { this.idDepartamento = idDepartamento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Pais getPais() { return pais; }
    public void setPais(Pais pais) { this.pais = pais; }
}
