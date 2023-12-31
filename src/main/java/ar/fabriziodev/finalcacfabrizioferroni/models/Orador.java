package ar.fabriziodev.finalcacfabrizioferroni.models;

import java.time.LocalDateTime;

public class Orador {
    protected Long id;

    protected  String codigo;

    protected  String nombre;

    protected String apellido;

    protected String tema;

    protected String descripcion;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    public Orador() {
    }

    public Orador(Long id, String codigo, String nombre, String apellido, String tema, String descripcion, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tema = tema;
        this.descripcion = descripcion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String toFullName() {
        return nombre + " " + apellido + " - " + tema;
    }
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", nombre=" + nombre +
                ", apellido=" + apellido +
                ", tema=" + tema +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
