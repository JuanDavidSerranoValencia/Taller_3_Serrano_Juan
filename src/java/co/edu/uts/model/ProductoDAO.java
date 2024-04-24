/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uts.model;

import co.edu.uts.db.ConDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aula4
 */
public class ProductoDAO {

    private ConDB conexion;
    static final String TABLE = "productos";
   

    public ProductoDAO() {
        conexion = new ConDB();
    }

    public List<Producto> getAll() {
        List<Producto> datos = new ArrayList<>();
        String sql = " select * from " + TABLE + "";
        try {
            PreparedStatement stm = conexion.
                    getConnection().
                    prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                float precio = rs.getFloat("precio");
                int cantidad = rs.getInt("cantidad");

                Producto producto
                        = new Producto(id, codigo, nombre, categoria, precio, cantidad);
                datos.add(producto);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return datos;
    }
    
     public boolean add(Producto producto) {
        boolean respuesta = false;
        String sql = "INSERT INTO "+TABLE +
                " (id, codigo, nombre, categoria, precio, cantidad) "+
                " VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement stm = conexion.getConnection()
                .prepareStatement(sql);
            stm.setLong(1, getMaxId()+1);
            stm.setString(2, producto.getCodigo());
            stm.setString(3, producto.getNombre());
            stm.setString(4, producto.getCategoria());
            stm.setFloat(5, producto.getPrecio());
            stm.setInt(6, producto.getCantidad());
            int rs = stm.executeUpdate();
            if (rs>0) {
                respuesta=true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return respuesta;
    }


    private long getMaxId() {
        long id = 0;
        String sql = "SELECT max(id) FROM "+TABLE+" ";
        try {
            PreparedStatement smt = conexion.getConnection()
                    .prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            if (rs != null && rs.next()) {
                id = rs.getLong(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }   


}
