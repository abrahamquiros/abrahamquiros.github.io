<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ver Libros</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            /* padding: 8px; */
            text-align: left;
        }

        /* th {
            background-color: #f2f2f2;
        } */
    </style>
</head>
<body>
    <h2>Lista de Libros</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Autor</th>
            <th>Género</th>
        </tr>

        <?php
                $host = 'localhost';
                $db = 'biblioteca';
                $user = 'root';
                $password = '';

                $dsn = "mysql:host=$host;dbname=$db;charset=UTF8";
                $conexion = new PDO($dsn, $user, $password);

                $query = "SELECT t_libros.id_libro, t_libros.nombre_libro, t_libros.autor, t_genero.nombre_genero
                          FROM t_libros
                          INNER JOIN t_genero ON t_libros.id_genero = t_genero.id_genero";
                $result = $conexion->query($query);

                while ($row = $result->fetch()) {
                    echo "<tr>";
                    echo "<td>{$row["id_libro"]}</td>";
                    echo "<td>{$row["nombre_libro"]}</td>";
                    echo "<td>{$row["autor"]}</td>";
                    echo "<td>{$row["nombre_genero"]}</td>";
                    echo "</tr>";
                }
        ?>
    </table>
</body>
</html>

