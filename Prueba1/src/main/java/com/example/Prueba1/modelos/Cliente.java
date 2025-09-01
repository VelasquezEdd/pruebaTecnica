package com.example.Prueba1.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "tipo_identificacion", nullable = false, length = 10)
    private String tipoIdentificacion;

    @Column(name = "numero_identificacion", nullable = false, unique = true, length = 20)
    private String numeroIdentificacion;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 200)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_ciudad", nullable = true)
    @JsonIgnoreProperties("departamento")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = true)
    @JsonIgnoreProperties("pais")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = true)
    @JsonIgnoreProperties("departamentos")
    private Pais pais;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Marca marca;

    // Métodos auxiliares para setear solo los IDs
    public void setIdPais(Long idPais) {
        this.pais = new Pais();
        this.pais.setIdPais(idPais);
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.departamento = new Departamento();
        this.departamento.setIdDepartamento(idDepartamento);
    }

    public void setIdCiudad(Long idCiudad) {
        this.ciudad = new Ciudad();
        this.ciudad.setIdCiudad(idCiudad);
    }

    // Getters y Setters
    public Long getIdCliente() { return idCliente; }
    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }

    public String getTipoIdentificacion() { return tipoIdentificacion; }
    public void setTipoIdentificacion(String tipoIdentificacion) { this.tipoIdentificacion = tipoIdentificacion; }

    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public void setNumeroIdentificacion(String numeroIdentificacion) { this.numeroIdentificacion = numeroIdentificacion; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Ciudad getCiudad() { return ciudad; }
    public void setCiudad(Ciudad ciudad) { this.ciudad = ciudad; }

    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }

    public Pais getPais() { return pais; }
    public void setPais(Pais pais) { this.pais = pais; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }
}
