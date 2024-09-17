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
        if (isset($_POST['cantidad'])) {
            if (isset($_POST['mc'])) {         
                $cantidad=$_POST['cantidad'];
                $mc=$_POST['mc'];
                $correo=$_POST['correo'];
                $ingreso = $cantidad * $mc;
                require("funcionConnexion.php");
                $con=conexion("ajax");

                // Obtener el saldo actual
                $querySaldo = "SELECT SALDO FROM datos WHERE CORREO='$correo'";
                $resultSaldo = mysqli_query($con, $querySaldo);
                $fila = mysqli_fetch_assoc($resultSaldo);
                $saldoActual = $fila['SALDO'];

                // Sumar el saldo actual con el ingreso
                $nuevoSaldo = $saldoActual + $ingreso;

                $accion="UPDATE datos SET SALDO='$nuevoSaldo' WHERE CORREO='$correo'";
                $result=mysqli_query($con,$accion);

                if ($result) {
                    echo "Ingreso completado, su saldo actual es de: " . $nuevoSaldo . " MegaCoins";
                }else {
                    echo "Error al realizar el ingreso";
                }
                mysqli_close($con);
                
            }
        }            
    ?>
</body>
</html>