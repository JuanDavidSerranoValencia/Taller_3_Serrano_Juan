<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.uts.model.Producto"%>
<%

String idTxt = (String) request.getAttribute("id");
List<Producto> productos =
        (List<Producto>) request.getAttribute("productos");
    
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Productos Disponibles</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        h1 {
            margin-bottom: 20px;
        }
        a {
            text-decoration: none;
            color: #007bff;
            margin-bottom: 10px;
            display: inline-block;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        input[type="checkbox"] {
            margin-right: 5px;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Productos Disponibles</h1>
    <a href="?obj=tienda&op=show&id=<%=idTxt%>">Volver</a>
    <form method="post" action="?obj=tienda&op=saveProductos&id=<%=idTxt %>" onsubmit="return validarAgregar()">
        <table>
            <thead>
                <tr>
                    <th></th>
                    <th>Id</th>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Categoria</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <% for(Producto pd : productos) { %>
                    <tr>
                        <td>
                            <input type="checkbox" name="producto_ids" value="<%=pd.getId() %>" />
                        </td>
                        <td><%=pd.getId() %></td>
                        <td><%=pd.getCodigo() %></td>
                        <td><%=pd.getNombre() %></td>
                        <td><%=pd.getCategoria() %></td>
                        <td><%=pd.getPrecio() %></td>
                        <td><%=pd.getCantidad() %></td>
                    </tr>
                <% } %>
                <tr>
                    <td colspan="7">
                        <button type="submit">Agregar</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
