<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión Tiendas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            max-width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .button-container {
            display: flex;
            margin-bottom: 20px;
        }

        .button {
            margin: 0 5px;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            font-size: 18px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Gestión Tiendas</h1>
        <div class="button-container">
            <button class="button" onclick="location.href='?action=list&obj=producto'">Productos MVC</button>
            <button class="button" onclick="location.href='?action=list&obj=tienda'">Tiendas MVC</button>
        </div>
    </div>
</body>
</html>
