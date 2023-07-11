package ar.fabriziodev.finalcacfabrizioferroni.models;

import java.time.LocalDateTime;

public class Ticket {

    protected Long id;

    protected  String codigo;

    protected  String nombre;

    protected String apellido;

    protected String email;

    protected  Integer cantidad;


    protected  double total;

    protected String categoria;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    public Ticket() {
    }

    public Ticket(Long id, String codigo, String nombre, String apellido, String email, Integer cantidad, double total, String categoria, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cantidad = cantidad;
        this.total = total;
        this.categoria = categoria;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Ticket(Long id, String codigo, String nombre, String apellido, String email, Integer cantidad, double total, String categoria, LocalDateTime createdAt) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cantidad = cantidad;
        this.total = total;
        this.categoria = categoria;
        this.createdAt = createdAt;
    }

    public Ticket(Long id, String nombre, String apellido, String email, Integer cantidad, double total, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cantidad = cantidad;
        this.total = total;
        this.categoria = categoria;
    }

    public Ticket(String codigo, String nombre, String apellido, String email, Integer cantidad, double total, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cantidad = cantidad;
        this.total = total;
        this.categoria = categoria;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
                ", email=" + email +
                ", cantidad=" + cantidad +
                ", total=" + total +
                ", categoria=" + categoria +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
