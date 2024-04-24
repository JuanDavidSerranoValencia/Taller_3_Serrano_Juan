<%@page import="java.util.List"%>
<%@page import="co.edu.uts.model.Tienda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
List<Tienda> tiendas = (List<Tienda>) request.getAttribute("tiendas");
String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestión de Tiendas</title>
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
    </style>
</head>
<body>
    <h1>Gestión de Tiendas</h1>
    <a href="?op=create&obj=tienda">Crear Tienda</a>
    <% if (error!=null) { %>
        <b style="color:red;"><%=error%></b><br/><br/>
    <% } %>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Dirección</th>
                <th>Ciudad</th>
                <th>Cantidad Empleados</th>
                <th>Presupuesto Venta</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% for (Tienda td: tiendas) { %>
                <tr>
                    <td><%=td.getId()%></td>
                    <td><%=td.getNombre()%></td>
                    <td><%=td.getDireccion()%></td>
                    <td><%=td.getCiudad()%></td>
                    <td><%=td.getCantidadEmpleados()%></td>
                    <td><%=td.getPresupuestoVenta()%></td>
                    <td>
                        <a href="?obj=tienda&op=show&id=<%=td.getId()%>">Ver</a>
                    </td>
                </tr>
            <% } %>
            <% if (tiendas.isEmpty()) { %>
                <tr><td colspan="7">No tiene Tiendas</td></tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
