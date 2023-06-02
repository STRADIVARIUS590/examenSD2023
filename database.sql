-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-06-2023 a las 00:48:35
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
-- Base de datos: `database`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `logs`
--

CREATE TABLE `logs` (
  `id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `name`, `brand`, `price`) VALUES
(1, 'Nintendo Entertainment System (NES)', 'Nintendo', '3980.00'),
(2, 'Super Nintendo Entertainment System (SNES)', 'Nintendo', '3980.00'),
(3, 'Nintendo 64', 'Nintendo', '3980.00'),
(4, 'GameCube', 'Nintendo', '3980.00'),
(5, 'Wii', 'Nintendo', '4980.00'),
(6, 'Wii U', 'Nintendo', '5980.00'),
(7, 'Nintendo Switch', 'Nintendo', '5980.00'),
(8, 'Sega Master System', 'Sega', '3980.00'),
(9, 'Sega Genesis', 'Sega', '3780.00'),
(10, 'Sega Saturn', 'Sega', '7980.00'),
(11, 'Sega Dreamcast', 'Sega', '3980.00'),
(12, 'PlayStation', 'Sony', '5980.00'),
(13, 'PlayStation 2', 'Sony', '5980.00'),
(14, 'PlayStation 3', 'Sony', '9980.00'),
(15, 'PlayStation 4', 'Sony', '7980.00'),
(16, 'PlayStation 5', 'Sony', '9980.00'),
(17, 'Xbox', 'Microsoft', '5980.00'),
(18, 'Xbox 360', 'Microsoft', '5980.00'),
(19, 'Xbox One', 'Microsoft', '5980.00'),
(20, 'Xbox Series X', 'Microsoft', '9980.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `rol`) VALUES
(1, 'Demian', 'secret', 'Panel de control'),
(2, 'Eduardo', 'secret', 'Monitor'),
(3, 'Daniel', 'secret', 'Servidor Log'),
(4, 'Joel', 'secret', 'Administrador');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `logs`
--
ALTER TABLE `logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
