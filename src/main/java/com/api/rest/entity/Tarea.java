package com.api.rest.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "completado")
    private Boolean completado = false;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "titulo")
    private String titulo;

    @Version
    @Column(name = "version")
    private Long version = 0L;

    // ==========================================
    // Constructors
    // ==========================================
    public Tarea() {}

    public Tarea(String titulo, String fecha, Boolean completado) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.completado = completado;
    }

    // ==========================================
    // Getters & Setters
    // ==========================================
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Boolean getCompletado() { return completado; }
    public void setCompletado(Boolean completado) { this.completado = completado; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }

    // ==========================================
    // toString
    // ==========================================
    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", completado=" + completado +
                ", version=" + version +
                '}';
    }
}