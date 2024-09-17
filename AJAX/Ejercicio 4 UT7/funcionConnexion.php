<?php
function conexion($bbdd) {
    $serv="localhost";
    $usuario="root";
    $clave="";
    $con=mysqli_connect($serv,$usuario,$clave,$bbdd);
    if (mysqli_connect_errno()) {
        printf("Conexion fallida: %s\n", mysqli_connect_errno());
        exit();
    }else {
    }
    return $con;
}
?>