-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-03-2023 a las 14:09:21
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
CREATE DATABASE IF NOT EXISTS `acdat` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `acdat`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnado`
--

CREATE TABLE `alumnado` (
  `id` int(11) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `telefono` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `ad` decimal(10,2) NOT NULL,
  `di` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumnado`
--

INSERT INTO `alumnado` (`id`, `nombre`, `telefono`, `email`, `ad`, `di`) VALUES
(1, 'Miguel de Loria', '111-222-333', 'miguel@gmail.com', '5.00', '7.20'),
(2, 'Lucía Pacheco', '222-333-444', 'lucia@gmail.com', '8.00', '4.00'),
(3, 'Paula Belmonte', '123-444-444', 'paula@gmail.com', '10.00', '9.00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnado`
--
ALTER TABLE `alumnado`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
