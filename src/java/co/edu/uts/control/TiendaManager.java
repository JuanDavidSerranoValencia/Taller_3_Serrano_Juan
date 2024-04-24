/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.edu.uts.control;

import co.edu.uts.model.Producto;
import co.edu.uts.model.Tienda;
import co.edu.uts.model.TiendaDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Yii
 */
public class TiendaManager extends HttpServlet {

    private TiendaDAO tDAO = new TiendaDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option = request.getParameter("op");
        option = (option != null) ? option : "index";
        if (option.equals("index")) {
            List<Tienda> prestamos = tDAO.getAll();
            request.setAttribute("tiendas", prestamos);
            request.getRequestDispatcher("tienda/index.jsp")
                    .forward(request, response);
        } else if (option.equals("create")) {
            request.getRequestDispatcher("tienda/create.jsp").forward(request, response);
            return;
        } else if (option.equals("save")) {
            String txtNombre = request.getParameter("nombre");
            String txtDireccion = request.getParameter("direccion");
            String txtCiudad = request.getParameter("ciudad");
            String txtCantidadEmpleados = request.getParameter("cantidadEmpleados");
            String txtPresupuestoVenta = request.getParameter("presupuestoVenta");
            Tienda tienda
                    = new Tienda(txtNombre, txtDireccion, txtCiudad, Integer.parseInt(txtCantidadEmpleados), Float.parseFloat(txtPresupuestoVenta));
            if (tDAO.addTienda(tienda)) {
                response.sendRedirect("?op=index&obj=tienda");
            } else {
                request.setAttribute("error", "La tienda no se creo");
                request.getRequestDispatcher("tienda/index.jsp").forward(request, response);
                return;
            }
        }
        else if (option.equals("show")) {
            String idTxt = request.getParameter("id");
            if (idTxt!=null && idTxt.length()>0) {
                Tienda tienda = tDAO.get(Long.parseLong(idTxt));
                request.setAttribute("tienda", tienda);
                request.getRequestDispatcher("tienda/show.jsp")
                        .forward(request, response);
            } else {
                response.sendRedirect("?op=index&obj=tienda");
            }

///
        } else if (option.equals("addProductos")) {
            String idTxt = request.getParameter("id");
            request.setAttribute("id", idTxt);
            List<Producto> productos = 
                    tDAO.getProductosDisponibles(Long.parseLong(idTxt));
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("tienda/productos.jsp")
                    .forward(request, response);
        } else if (option.equals("saveProductos")) {
            String idTxt = request.getParameter("id");
            String [] producto_ids = 
                    request.getParameterValues("producto_ids");
            tDAO.addProductosTienda(Long.parseLong(idTxt), producto_ids);
            response.sendRedirect("?op=show&obj=tienda&id="+idTxt);
        } else if (option.equals("deleteProducto")) {
            String idTxt = request.getParameter("id");
            String producto_idTxt = request.getParameter("producto_id");
            tDAO.deleteProductoTienda(Long.parseLong(idTxt),
                    Long.parseLong(producto_idTxt));
            response.sendRedirect("?op=show&obj=tienda&id="+idTxt);
        }
    }

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
