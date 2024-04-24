/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.edu.uts.control;

import co.edu.uts.model.Producto;
import co.edu.uts.model.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Yii
 */
public class ProductoManager extends HttpServlet {

    private ProductoDAO pDAO = new ProductoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("list")) {
            List<Producto> lista = pDAO.getAll();
            request.setAttribute("productos", lista);
            request.getRequestDispatcher("producto-mvc/index.jsp")
                    .forward(request, response);
            return;
        } else if (action.equals("create")) {
            request.getRequestDispatcher("producto-mvc/create.jsp")
                    .forward(request, response);
            return;
        } else if (action.equals("save")) {
            String txtCodigo = request.getParameter("codigo");
            String txtNombre = request.getParameter("nombre");
            String txtCategoria = request.getParameter("categoria");
            String txtPrecio = request.getParameter("precio");
            String txtCantidad = request.getParameter("cantidad");

            Producto producto
                    = new Producto(txtCodigo, txtNombre, txtCategoria, Float.parseFloat(txtPrecio), Integer.parseInt(txtCantidad));
            boolean result = pDAO.add(producto);
            if (result != true) {
                request.setAttribute("error",
                        "Error al crear el producto");
            }

            request.setAttribute("productos",
                    pDAO.getAll());
            request.getRequestDispatcher("producto-mvc/index.jsp")
                    .forward(request, response);
            return;

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
