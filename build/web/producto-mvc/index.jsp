
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="co.edu.uts.model.Producto" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestión de productos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        a {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        a:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <% String error = (String) request.getAttribute("error");
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    %>
    <div class="error-message">
        <% if (error != null) {
        out.print("<h3>" + error + "</h3>");
        } %>
    </div>
    <h1>Gestión de Productos</h1>
    <a href="producto.do?action=create">Agregar Productos</a>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Código</th>
                <th>Nombre</th>
                <th>Categoría</th>
                <th>Precio</th>
                <th>Cantidad</th>
            </tr>
        </thead>
        <tbody>
            <% for (Producto pd : productos) { %>
            <tr>
                <td><%= pd.getId() %></td>
                <td><%= pd.getCodigo() %></td>
                <td><%= pd.getNombre() %></td>
                <td><%= pd.getCategoria() %></td>
                <td><%= pd.getPrecio() %></td>
                <td><%= pd.getCantidad() %></td>
            </tr>
            <% } %>
            <% if (productos != null && productos.size() == 0) { %>
            <tr>
                <td colspan="6">Sin Productos</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
