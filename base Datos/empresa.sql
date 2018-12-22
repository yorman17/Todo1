-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-12-2018 a las 02:58:43
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresa`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `REGISTRAR_VENTA` (IN `p_ID_P` INT, IN `p_FECHA` VARCHAR(10), IN `p_CLIENTE` VARCHAR(50), IN `p_CANTIDAD` INT, IN `p_TOTAL` DECIMAL(15,4), OUT `p_MENSAJE` VARCHAR(50))  BEGIN	
IF
(EXISTS(SELECT * FROM PRODUCTO WHERE STOCK<p_CANTIDAD)) THEN
	SET p_MENSAJE ='NO HAY SUFICIENTE STOCK';
	END IF;
	BEGIN

INSERT VENTA (CLIENTE,CANTIDAD,FECHA,TOTAL,ID_P)
VALUES(p_CLIENTE,p_CANTIDAD,p_FECHA,p_TOTAL,p_ID_P );
UPDATE PRODUCTO SET STOCK =STOCK - p_CANTIDAD WHERE ID_P=p_ID_P;
	SET p_MENSAJE ='VENTA REGISTRADA CORRECTAMENTE';
END; 
	END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID_P` int(11) NOT NULL,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `PRECIO` int(11) DEFAULT NULL,
  `STOCK` int(11) DEFAULT NULL,
  `FECHA` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID_P`, `NOMBRE`, `PRECIO`, `STOCK`, `FECHA`) VALUES
(1, 'comics', 15000, 0, '2018-12-20'),
(2, 'teclado', 3000, 15, '2018-12-20'),
(3, 'pantallas', 50000, 20, '2018-12-08'),
(4, 'mause', 15000, 21, '2018-12-22'),
(5, 'camisetas', 30000, 50, '2018-12-21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `USUARIO` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `CONTRASENA` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`USUARIO`, `CONTRASENA`) VALUES
('YORMAN', '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `ID_V` int(11) NOT NULL,
  `CLIENTE` varchar(50) DEFAULT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `FECHA` varchar(10) DEFAULT NULL,
  `TOTAL` int(11) DEFAULT NULL,
  `ID_P` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`ID_V`, `CLIENTE`, `CANTIDAD`, `FECHA`, `TOTAL`, `ID_P`) VALUES
(5, 'po', 39, '10', 2, 1),
(6, 'sdsd', 99, '2018-12-15', 297000, 2),
(7, 'gh', 30, '2018-12-15', 450000, 1),
(8, 'dilan', 80, '2018-12-20', 4000000, 3),
(9, 'fg', 1, '2018-12-01', 3000, 2),
(10, 'fg', 1, '2018-12-01', 15000, 1),
(11, 'gh', 9, '2018-12-08', 135000, 1),
(12, 'jaja', 100, '2018-12-08', 5000000, 3),
(13, 'fd', 5, '2018-12-01', 15000, 2),
(14, 'dilan', 80, '2018-12-20', 4000000, 3),
(15, 'yorman', 5, '2018-12-21', 250000, 3),
(16, 'deisy', 12, '2018-12-21', 360000, 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID_P`);

--
-- Indices de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`USUARIO`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`ID_V`),
  ADD KEY `producto - venta` (`ID_P`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `ID_V` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `producto - venta` FOREIGN KEY (`ID_P`) REFERENCES `producto` (`ID_P`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
