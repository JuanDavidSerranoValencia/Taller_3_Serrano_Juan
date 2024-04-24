/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uts.model;


public class Producto {

    private long id;
    private String codigo;
    private String nombre;
    private String categoria;
    private float precio;
    private int cantidad;

    public Producto() {
    }
    
    
    public Producto(long id, String codigo, String nombre, String categoria, float precio, int cantidad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto(String codigo, String nombre, String categoria, float precio, int cantidad) {
        this(0, codigo, nombre, categoria, precio, cantidad);
    }
    

    public long getId() {
        return id;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }

}
