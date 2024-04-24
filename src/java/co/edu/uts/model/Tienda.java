/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uts.model;

import java.util.List;


public class Tienda {

    private long id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private int cantidadEmpleados;
    private float presupuestoVenta;
    
    private List<Producto> productos;

    public Tienda() {
    }

    public Tienda(long id, String nombre, String direccion, String ciudad, int cantidadEmpleados, float presupuestoVenta) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.cantidadEmpleados = cantidadEmpleados;
        this.presupuestoVenta = presupuestoVenta;
    }

    public Tienda(String nombre, String direccion, String ciudad, int cantidadEmpleados, float presupuestoVenta, List<Producto> productos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.cantidadEmpleados = cantidadEmpleados;
        this.presupuestoVenta = presupuestoVenta;
        this.productos = productos;
    }
    
    
      public Tienda( String nombre, String direccion, String ciudad, int cantidadEmpleados, float presupuestoVenta) {
        this(0,nombre,direccion, ciudad,cantidadEmpleados,presupuestoVenta);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
      
      

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(int cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public float getPresupuestoVenta() {
        return presupuestoVenta;
    }

    public void setPresupuestoVenta(float presupuestoVenta) {
        this.presupuestoVenta = presupuestoVenta;
    }

    @Override
    public String toString() {
        return "Tienda{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad + ", cantidadEmpleados=" + cantidadEmpleados + ", presupuestoVenta=" + presupuestoVenta + '}';
    }
  
 
    
    
}
