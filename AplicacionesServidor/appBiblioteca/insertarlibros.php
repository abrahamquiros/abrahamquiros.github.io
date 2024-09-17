<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Insertar Libros</title>
</head>
<body>
    <h2>Insertar Libro</h2>
    
    <form action="insertar.php" method="post">
        <label for="nombre">Nombre del Libro:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        <label for="autor">Autor:</label>
        <input type="text" id="autor" name="autor" required><br><br>

        <label for="genero">Género:</label>
        <select id="genero" name="genero" required>
            <?php
                    $host = 'localhost';
                    $db = 'biblioteca';
                    $user = 'root';
                    $password = '';

                    $dsn = "mysql:host=$host;dbname=$db;charset=UTF8";

                    $conexion = new PDO($dsn, $user, $password);

                    $query = "SELECT id_genero, nombre_genero FROM t_genero";
                    $result = $conexion->query($query);

                    while ($row = $result->fetch()) {
                        echo "<option value='{$row["id_genero"]}'>{$row["nombre_genero"]}</option>";
                    }
            ?>
        </select><br><br>
        <input type="submit" value="Insertar Libro">
    </form><br><br>
    <a href="verlibros2.php">Ver Libros</a>
</body>
</html>

