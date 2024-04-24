/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uts.model;

import co.edu.uts.db.ConDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aula4
 */
public class TiendaDAO {

    private ConDB conexion;
    final static String TABLE = "tiendas";
     static final String TABLE_REL_1 = "tiendas_has_productos";

    public TiendaDAO() {
        conexion = new ConDB();
    }

    public List<Tienda> getAll() {
        ArrayList<Tienda> data = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE + " ";
        try {
            PreparedStatement smt = conexion.getConnection()
                    .prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            while (rs != null && rs.next()) {
                long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String ciudad = rs.getString("ciudad");
                int cantidadEmpleado = rs.getInt("cantidad_empleados");
                float presupuestoVenta = rs.getFloat("presupuesto_venta");
                Tienda tienda = new Tienda(id,nombre,direccion,ciudad,cantidadEmpleado,presupuestoVenta);
                data.add(tienda);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

//    public boolean add(Tienda tienda) {
//        boolean respuesta = false;
//        String sql = "INSERT INTO " + TABLE
//                + " (id, nombre, direccion, ciudad, cantidad_empleado, presupuesto_venta) "
//                + " VALUES (?,?,?,?,?,?)";
//
//        try {
//            PreparedStatement stm = conexion.getConnection()
//                    .prepareStatement(sql);
//            stm.setLong(1, getMaxId() + 1);
//            stm.setString(2, tienda.getNombre());
//            stm.setString(3, tienda.getDireccion());
//            stm.setString(4, tienda.getCiudad());
//            stm.setInt(5, tienda.getCantidadEmpleados());
//            stm.setFloat(6, tienda.getPresupuestoVenta());
//            int rs = stm.executeUpdate();
//            if (rs > 0) {
//                respuesta = true;
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return respuesta;
//    }
    
    public void addProductosTienda(long id, String... producto_ids) {
        String sql = "INSERT INTO "+TABLE_REL_1+ " VALUES (NULL, ?, ?)";
        try {
            PreparedStatement stm = this.conexion
                    .getConnection()
                    .prepareStatement(sql);
            stm.setLong(1, id);
            for (String producto_id : producto_ids) {
                stm.setLong(2, Long.parseLong(producto_id));
                
                stm.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deleteProductoTienda(long id, long producto_id) {
        String sql = "DELETE FROM "+ TABLE_REL_1 + " WHERE "
                + " productos_id=? AND tiendas_id=? ";
        try {
            PreparedStatement stm = this.conexion
                    .getConnection()
                    .prepareStatement(sql);
            stm.setLong(1, producto_id);
            stm.setLong(2, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
        public List<Producto> getProductosDisponibles(long id) {
        String sql = "select * from "+ProductoDAO.TABLE+
                " where id NOT IN (" +
                "select productos_id from "+TABLE_REL_1+
                " where tiendas_id=?)";
        List<Producto> productos = new ArrayList();
        try {
            PreparedStatement stm = this.conexion
                        .getConnection()
                        .prepareStatement(sql);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                long producto_id = rs.getLong("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                float precio =rs.getFloat("precio");
                int cantidad = rs.getInt("cantidad");
                
                Producto producto = 
                 new Producto(producto_id, codigo, nombre, categoria, precio, cantidad);
                productos.add(producto);                     
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return productos;
    }
    
    private List<Producto> getProductosTienda(long id) {
        String sql = "select R.* from "+ProductoDAO.TABLE+" as R "+
                " inner join "+TABLE_REL_1+" as PR on R.id=PR.productos_id "+
                " where PR.tiendas_id=?";
        List<Producto> productos = new ArrayList();
        try {
            PreparedStatement stm = this.conexion
                        .getConnection()
                        .prepareStatement(sql);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                long producto_id = rs.getLong("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                float precio =rs.getFloat("precio");
                int cantidad = rs.getInt("cantidad");
                
                Producto producto = 
                 new Producto(producto_id, codigo, nombre, categoria, precio, cantidad);
                productos.add(producto);                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return productos;
    }
    
    public Tienda get(long id) {
        Tienda datos = null;
        String sql = " select * from "+TABLE+" where id=?";
        try {
            PreparedStatement stm = conexion.
                                    getConnection().
                                    prepareStatement(sql);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String ciudad = rs.getString("ciudad");
                int cantidadEmpleados = rs.getInt("cantidad_empleados");
                float presupuestoVenta = rs.getFloat("presupuesto_venta");
                datos = 
                    new Tienda(id, nombre, direccion, ciudad, cantidadEmpleados, presupuestoVenta);
                datos.setProductos(this.getProductosTienda(id));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return datos;
    }
    
     public boolean addTienda(Tienda tienda) {
        String sql = "INSERT INTO "+TABLE+
                " (id, nombre, direccion, ciudad, cantidad_empleados, presupuesto_venta) "
                + " VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement contendor2 = 
                    conexion.getConnection().
                            prepareStatement(sql);
            contendor2.setLong(1, getMaxId()+1);
            contendor2.setString(2, tienda.getNombre());
            contendor2.setString(3, tienda.getDireccion());
            contendor2.setString(4, tienda.getCiudad());
            contendor2.setInt(5, tienda.getCantidadEmpleados());
            contendor2.setFloat(6, tienda.getPresupuestoVenta());
            int rs = contendor2.executeUpdate();
            if (rs>0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private long getMaxId() {
        try {
            String sql = "SELECT max(id) FROM "+TABLE;
            PreparedStatement stm = 
                    conexion.getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
      private long getMaxId_Rel1() {
        try {
            String sql = "SELECT max(id) FROM "+TABLE_REL_1;
            PreparedStatement stm = 
                    conexion.getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
}
