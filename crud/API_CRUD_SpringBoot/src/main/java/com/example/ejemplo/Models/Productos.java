package com.example.ejemplo.Models;

public class Productos {
    private String nombre;
    private float precio;
    private String foto;
    private int id;
    private int cantidad;
    
    public int getCantidad() {
      return cantidad;
    }

    public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Productos() {
    }

    public Productos(String nombre, float precio, String foto, int id, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.foto = foto;
        this.id = id;
        this.cantidad = cantidad;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
}
