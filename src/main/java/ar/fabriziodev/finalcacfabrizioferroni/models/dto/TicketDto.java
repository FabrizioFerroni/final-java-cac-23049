package ar.fabriziodev.finalcacfabrizioferroni.models.dto;

import java.time.LocalDateTime;

public class TicketDto {

    protected  String codigo;

    protected  String nombre;

    protected String apellido;

    protected String email;

    protected String dni;

    protected  Integer cantidad;


    protected  double total;

    protected String categoria;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    protected Long userId;

    protected Long oradorId;

    public TicketDto() {
    }

    public TicketDto(String codigo, String nombre, String apellido, String email, String dni, Integer cantidad, double total, String categoria, LocalDateTime createdAt, LocalDateTime updatedAt, Long userId, Long oradorId) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.cantidad = cantidad;
        this.total = total;
        this.categoria = categoria;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.oradorId = oradorId;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOradorId() {
        return oradorId;
    }

    public void setOradorId(Long oradorId) {
        this.oradorId = oradorId;
    }
}
