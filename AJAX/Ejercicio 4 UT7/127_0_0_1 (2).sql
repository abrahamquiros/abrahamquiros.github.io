-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-02-2020 a las 10:28:35
-- Versión del servidor: 5.7.14
-- Versión de PHP: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ajax`
--
CREATE DATABASE IF NOT EXISTS `ajax` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ajax`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos`
--

CREATE TABLE `datos` (
  `CORREO` varchar(60) NOT NULL,
  `CLAVE` int(8) NOT NULL,
  `NOMBRE` text NOT NULL,
  `FECHA` text NOT NULL,
  `PAIS` text NOT NULL,
  `SALDO` int(11) NOT NULL,
  `PREGUNTA` text NOT NULL,
  `RESPUESTA` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `datos`
--

INSERT INTO `datos` (`CORREO`, `CLAVE`, `NOMBRE`, `FECHA`, `PAIS`, `SALDO`, `PREGUNTA`, `RESPUESTA`) VALUES
('prueba@prueba.es', 12345678, 'Luis Garcia', '12/12/1999', 'EspaÃ±a', 252414, 'Mascota', 'Lulu'),
('segunda@segu.com', 12345678, 'Segunda Primera', '12/12/1987', 'EspaÃ±a', 244422, 'Abuela', 'Segunda');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `datos`
--
ALTER TABLE `datos`
  ADD PRIMARY KEY (`CORREO`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
