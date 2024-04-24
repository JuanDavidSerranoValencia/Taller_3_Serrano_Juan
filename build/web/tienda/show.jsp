<%@page import="co.edu.uts.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Tienda tienda = (Tienda) request.getAttribute("tienda");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ver Tienda</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border-bottom: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        td {
            background-color: #fff;
        }
        tr:hover {
            background-color: #f0f0f0;
        }
        .add-button {
            display: block;
            width: fit-content;
            margin: 20px auto;
            background-color: #007bff;
            color: #fff;
            padding: 8px 16px;
            text-decoration: none;
            border-radius: 5px;
        }
        .add-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Ver Tienda</h1>
    <a href="?obj=tienda&op=index">Volver</a>
    <table>
        <tr>
            <td>Id</td>
            <td><%=tienda.getId()%> </td>
        </tr>
        <tr>
            <td>Nombre</td>
            <td><%=tienda.getNombre()%> </td>
        </tr>
        <tr>
            <td>Dirección</td>
            <td><%=tienda.getDireccion()%> </td>
        </tr>
        <tr>
            <td>Ciudad</td>
            <td><%=tienda.getCiudad()%> </td>
        </tr>
        <tr>
            <td>Cantidad Empleados</td>
            <td><%=tienda.getCantidadEmpleados()%> </td>
        </tr>
        <tr>
            <td>Presupuesto Venta</td>
            <td><%=tienda.getPresupuestoVenta()%> </td>
        </tr>
    </table>
    <a href="?obj=tienda&op=addProductos&id=<%=tienda.getId()%>" class="add-button">Add Productos</a>
    <h2>Lista de Productos</h2>
    <% if (tienda.getProductos() != null && tienda.getProductos().size() > 0) { %>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Categoria</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% for (Producto pd : tienda.getProductos()) { %>
                    <tr>
                        <td><%=pd.getId()%></td>
                        <td><%=pd.getCodigo()%></td>
                        <td><%=pd.getNombre()%></td>
                        <td><%=pd.getCategoria()%></td>
                        <td><%=pd.getPrecio()%></td>
                        <td><%=pd.getCantidad()%></td>
                        <td>
                            <a href="?obj=tienda&op=deleteProducto&id=<%=tienda.getId()%>&producto_id=<%=pd.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <h3>No tiene Productos en la tienda</h3>
    <% } %>
</body>
</html>
