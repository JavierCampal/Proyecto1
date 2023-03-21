-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-03-2023 a las 21:00:00
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `acdat`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `nombre` text NOT NULL,
  `apellidos` text NOT NULL,
  `ad` double NOT NULL,
  `sge` double NOT NULL,
  `di` double NOT NULL,
  `pmdm` double NOT NULL,
  `psp` double NOT NULL,
  `eie` double NOT NULL,
  `hlc` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`nombre`, `apellidos`, `ad`, `sge`, `di`, `pmdm`, `psp`, `eie`, `hlc`) VALUES
('Lucia', 'Perez Villalta', 7, 8, 1, 5, 6, 5.5, 5.75),
('Marta', 'Moreno Baldomero', 7, 8, 1, 5, 6, 5.5, 5.75),
('Lucas', 'Gil Gutierrez', 7, 8, 1, 5, 6, 5.5, 5.75),
('Antonio', 'De la Rosa', 6, 4, 3, 7, 8, 2, 10),
('Rachel', 'Martinez', 9.75, 9, 8, 7, 7, 8, 9),
('Miguel', 'Hernan', 1, 2, 3, 4, 5, 6, 7);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
