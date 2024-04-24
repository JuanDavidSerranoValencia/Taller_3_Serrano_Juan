<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agregar Productos</title>
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
    <h1>Agregar Productos</h1>
    <a href="producto.do?action=list">Volver</a>
    <form method="post" action="producto.do?action=save"> 
        <table border="0">
            <tbody>
                <tr>
                    <td>
                        <label for="codigo">Código</label>
                    </td>
                    <td>
                        <input id="codigo" name="codigo" type="text" placeholder="Digite el código del producto" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nombre">Nombre</label>
                    </td>
                    <td>
                        <input id="nombre" name="nombre" type="text" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="categoria">Categoría</label>
                    </td>
                    <td>
                        <input id="categoria" name="categoria" type="text" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="precio">Precio</label>
                    </td>
                    <td>
                        <input id="precio" name="precio" type="number" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="cantidad">Cantidad</label>
                    </td>
                    <td>
                        <input id="cantidad" name="cantidad" type="number" required />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">Guardar</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
