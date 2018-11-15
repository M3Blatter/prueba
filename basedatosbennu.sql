-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 10-11-2018 a las 06:56:01
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `basedatosbennu`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE IF NOT EXISTS `alumno` (
  `id_alumno` int(11) NOT NULL AUTO_INCREMENT,
  `id_colegio` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_nac` date NOT NULL,
  PRIMARY KEY (`id_alumno`),
  KEY `id_colegio` (`id_colegio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id_alumno`, `id_colegio`, `nombre`, `fecha_nac`) VALUES
(1, 1, 'Juan Perez', '2006-05-08'),
(2, 1, 'Pedro Muñoz', '2008-11-06'),
(3, 1, 'nicolas ulloa', '2008-11-20'),
(4, 1, 'vicente valenzuela', '2007-11-19'),
(5, 1, 'andres gonzales', '2009-11-12'),
(6, 1, 'marcela muñoz', '2009-11-20'),
(9, 1, 'alonso romero', '2007-05-08'),
(10, 1, 'constanza riquelme', '2009-11-28'),
(13, 2, 'joaquin perez', '2009-11-06'),
(14, 2, 'monica muñoz', '2008-11-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE IF NOT EXISTS `asignatura` (
  `id_asignatura` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_asignatura`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`id_asignatura`, `nombre`) VALUES
(1, 'matematicas'),
(2, 'lenguaje'),
(3, 'ciencias'),
(4, 'historia'),
(5, 'fisica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colegio`
--

CREATE TABLE IF NOT EXISTS `colegio` (
  `id_colegio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_colegio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Volcado de datos para la tabla `colegio`
--

INSERT INTO `colegio` (`id_colegio`, `nombre`, `direccion`) VALUES
(1, 'Emilia Romania', 'Saveedra 512'),
(2, 'Diego Portales', 'Santa Cruz 617'),
(20, 'san sebastian', 'Lagos 863'),
(22, 'Louis Pasteur', 'general gana 789'),
(24, 'Lucila Godoy Alcayaga', 'Coronel Urrutia'),
(26, 'Camilo Henriquez', 'faeaefaefe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE IF NOT EXISTS `nota` (
  `id_nota` int(11) NOT NULL AUTO_INCREMENT,
  `id_alumno` int(11) NOT NULL,
  `id_asignatura` int(11) NOT NULL,
  `nota` float NOT NULL,
  PRIMARY KEY (`id_nota`),
  KEY `id_alumno` (`id_alumno`),
  KEY `id_asignatura` (`id_asignatura`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `nota`
--

INSERT INTO `nota` (`id_nota`, `id_alumno`, `id_asignatura`, `nota`) VALUES
(1, 1, 1, 4.5),
(2, 1, 1, 3.9),
(3, 2, 1, 7),
(4, 2, 1, 3.3),
(5, 3, 1, 4.1),
(6, 3, 1, 3.4),
(7, 4, 1, 6.4),
(8, 4, 1, 3.8),
(9, 5, 1, 6.2),
(10, 5, 1, 2.1),
(11, 6, 1, 6.1),
(12, 6, 1, 3.1),
(13, 9, 2, 5.1),
(14, 9, 2, 3),
(15, 10, 3, 3.2),
(16, 10, 3, 4),
(17, 13, 4, 3.9),
(18, 14, 5, 2.3),
(19, 10, 5, 2.4),
(20, 13, 4, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE IF NOT EXISTS `profesor` (
  `id_profesor` int(11) NOT NULL AUTO_INCREMENT,
  `id_colegio` int(11) NOT NULL,
  `id_asignatura` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_Nac` date NOT NULL,
  `activo` enum('Si','No') NOT NULL,
  PRIMARY KEY (`id_profesor`),
  KEY `id_colegio` (`id_colegio`),
  KEY `id_asignatura` (`id_asignatura`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id_profesor`, `id_colegio`, `id_asignatura`, `nombre`, `fecha_Nac`, `activo`) VALUES
(1, 1, 1, 'Rodrigo Leal', '1988-11-05', 'Si'),
(2, 1, 2, 'constanza Rivas', '1978-11-13', 'Si'),
(3, 1, 3, 'Ignacio Vazques', '1979-11-20', 'Si'),
(4, 1, 4, 'Nicolas Romero', '1994-11-26', 'Si'),
(5, 1, 5, 'Pedro Guzman', '1988-11-05', 'Si'),
(6, 2, 1, 'Rosa Rosales', '1969-11-13', 'No');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`id_colegio`) REFERENCES `colegio` (`id_colegio`);

--
-- Filtros para la tabla `nota`
--
ALTER TABLE `nota`
  ADD CONSTRAINT `nota_ibfk_1` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`),
  ADD CONSTRAINT `nota_ibfk_2` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id_asignatura`);

--
-- Filtros para la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD CONSTRAINT `profesor_ibfk_1` FOREIGN KEY (`id_colegio`) REFERENCES `colegio` (`id_colegio`),
  ADD CONSTRAINT `profesor_ibfk_2` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id_asignatura`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
