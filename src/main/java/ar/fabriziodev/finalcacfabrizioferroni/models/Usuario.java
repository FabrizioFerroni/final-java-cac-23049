package ar.fabriziodev.finalcacfabrizioferroni.models;

import java.sql.Date;
import java.time.LocalDateTime;

public class Usuario {

    protected Long id;

    protected  String nombre;

    protected String apellido;

    protected String username;

    protected String password;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    public Usuario(Long id, String nombre, String apellido, String username, LocalDateTime createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.createdAt = createdAt;
    }

    public Usuario(Long id, String nombre, String apellido, String username, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Usuario(String nombre, String apellido, String username, String password, LocalDateTime createdAt) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
    }

    public Usuario(Long id, String nombre, String apellido, String username, String password, LocalDateTime createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
    }

    public Usuario(Long id, String nombre, String apellido, String username) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
    }

    public Usuario(String nombre, String apellido, String username) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", nombre=" + nombre  +
                ", apellido=" + apellido +
                ", username=" + username +
                '}';
    }
}
