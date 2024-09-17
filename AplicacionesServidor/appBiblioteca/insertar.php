<?php
$host = 'localhost';
$db = 'biblioteca';
$user = 'root';
$password = '';

$dsn = "mysql:host=$host;dbname=$db;charset=UTF8";

    $conexion = new PDO($dsn, $user, $password);

    if (isset($_POST["nombre"]) && isset($_POST["autor"]) && isset($_POST["genero"])) {
        $nombre = $_POST["nombre"];
        $autor = $_POST["autor"];
        $genero = $_POST["genero"];

        $sqlInsertarLibro = 'INSERT INTO t_libros (nombre_libro, autor, id_genero) VALUES (:nombre, :autor, :genero)';
        $statementInsertarLibro = $conexion->prepare($sqlInsertarLibro);
        $statementInsertarLibro->execute([':nombre' => $nombre, ':autor' => $autor, ':genero' => $genero]);

        echo 'Libro insertado correctamente.';
        exit();
    } 
?>
