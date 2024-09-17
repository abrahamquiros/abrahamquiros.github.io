<?php
    $correo2=$_POST['correo2'];
    $clave2=$_POST['clave2'];
    $pregunta=$_POST['pregunta'];
    $respuesta=$_POST['respuesta'];
    $nombre=$_POST['nombre'];
    $fecha=$_POST['fecha'];
    $pais=$_POST['pais'];
    $ingreso=$_POST['ingreso'];
    $mc=$_POST['mc'];

    require("funcionConnexion.php");
    $con=conexion("ajax");

    // Sumar el saldo actual con el ingreso
    $ingresoActual = $ingreso * $mc;

    $sql = "INSERT INTO `datos`(`CORREO`, `CLAVE`, `NOMBRE`, `FECHA`, `PAIS`, `SALDO`, `PREGUNTA`, `RESPUESTA`) 
    VALUES ('$correo2','$clave2','$nombre','$fecha','$pais','$ingresoActual','$pregunta','$respuesta');";

    if (mysqli_query($con, $sql)) {
        echo "Alta completada correctamente";
    } 
    else {
        echo "Error al insertar los datos";
    }
    mysqli_close($con);
?>