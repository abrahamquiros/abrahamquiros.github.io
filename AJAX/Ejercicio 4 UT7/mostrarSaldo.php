<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        #consulta{
            border: 3px solid black;
            text-align: center;
            width: 20%;
        }
        .negrita{
            font-weight: bold;
        }
    </style>
</head>
<body>
    <?php
        if (isset($_POST['correo'])) {
            if (isset($_POST['clave'])) {
                $correo=$_POST['correo'];
                $clave=$_POST['clave'];
                require("funcionConnexion.php");
                $con=conexion("ajax");
                $accion="SELECT NOMBRE, FECHA, PAIS, SALDO FROM datos WHERE CORREO='$correo' AND CLAVE='$clave'";
                $result=mysqli_query($con,$accion);
                $cantidad=mysqli_num_rows($result);
                if ($cantidad>0) {
                    $datos=mysqli_fetch_array($result);

                    echo "<div id='consulta'>";
                    echo "<p>Consulta de la cuenta con saldo:</p>";
                    echo "<p class='negrita'>$datos[NOMBRE]</p>";
                    echo "<p>$datos[FECHA]</p>";
                    echo "<p>$datos[PAIS]</p>";
                    echo "<p>SALDO:  $datos[SALDO] MegaCoins</p>";

                }else {
                    echo "false";
                }
                mysqli_close($con);
            }
        }            
    ?>
</body>
</html>