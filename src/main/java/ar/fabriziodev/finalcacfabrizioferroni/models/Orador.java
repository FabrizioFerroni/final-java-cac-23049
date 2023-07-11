package ar.fabriziodev.finalcacfabrizioferroni.models;

import java.time.LocalDateTime;

public class Orador {
    protected Long id;

    protected  String codigo;
    protected  String nombre;

    protected String apellido;

    protected String tema;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    public Orador() {
    }

    public Orador(Long id, String codigo, String nombre, String apellido, String tema, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tema = tema;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Orador(Long id, String codigo, String nombre, String apellido, String tema, LocalDateTime createdAt) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tema = tema;
        this.createdAt = createdAt;
    }

    public Orador(String codigo, String nombre, String apellido, String tema) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tema = tema;
    }

    public Orador(Long id, String nombre, String apellido, String tema) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tema = tema;
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
