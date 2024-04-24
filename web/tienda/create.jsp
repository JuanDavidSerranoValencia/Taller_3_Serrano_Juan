<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Tienda</title>
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
            width: 50%;
            margin: 0 auto;
            border-collapse: collapse;
            margin-top: 20px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"] {
            width: calc(100% - 10px);
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="text"]:focus,
        input[type="number"]:focus {
            outline: none;
            border-color: #007bff;
        }
        button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>

    </head>
    <body>
        
        <h1>Agregar Tienda</h1>
        <br/><br/>
        <a href="tienda.do?op=index">Volver</a>
        <br/><br/>
        <form method="POST" action="tienda.do?op=save">
            <table>
                <tbody>

                    <tr>
                        <td><label>Nombre</label></td>
                        <td>
                            <input type="text" name="nombre" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>direccion</label></td>
                        <td>
                            <input type="text" name="direccion" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>ciudad</label></td>
                        <td>
                            <input type="text" name="ciudad" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>Cantidad Empleados</label></td>
                        <td>
                            <input type="number" name="cantidadEmpleados" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>Presupuesto Venta</label></td>
                        <td>
                            <input type="number" name="presupuestoVenta" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button>Guardar</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
