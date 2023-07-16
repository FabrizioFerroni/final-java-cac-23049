package ar.fabriziodev.finalcacfabrizioferroni.models.dto;

import java.time.LocalDateTime;

public class UsuarioDto {
    protected  String nombre;

    protected String apellido;

    protected String email;

    protected String username;

    protected String password;

    protected String rol;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    public UsuarioDto() {
    }

    public UsuarioDto(String nombre, String apellido, String email, String username, String password, String rol, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
                "nombre=" + nombre  +
                ", apellido=" + apellido +
                ", username=" + username +
                ", email=" + email +
                ", rol=" + rol +
                '}';
    }
}
