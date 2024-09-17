<?php
    $clave=rand(10000000,99999999);
    if (isset($_POST['correo3'])) {
        if (isset($_POST['fecha2'])) {
            $correo3=$_POST['correo3'];
            $fecha=$_POST['fecha2'];
            require("funcionConnexion.php");
            $con=conexion("ajax");
            $accion="UPDATE datos SET CLAVE='$clave' WHERE CORREO='$correo3' AND FECHA='$fecha'";

            $result=mysqli_query($con,$accion);
            if ($result) {
                echo "Su nueva clave es: $clave";
            }else {
                echo "false";
            }
            mysqli_close($con);
        }
    }
?>