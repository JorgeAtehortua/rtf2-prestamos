-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-07-2014 a las 10:06:54
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `prestamos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispositivo`
--

CREATE TABLE IF NOT EXISTS `dispositivo` (
  `IdDispositivo` int(11) NOT NULL,
  `NombreDispositivo` varchar(25) NOT NULL,
  `DescripcionDispositivo` varchar(50) DEFAULT NULL,
  `Cantidad` int(11) NOT NULL,
  `Disponibles` int(11) NOT NULL,
  `TipoDispositivo` varchar(25) NOT NULL,
  PRIMARY KEY (`IdDispositivo`),
  KEY `tipoDispositivo` (`TipoDispositivo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `dispositivo`
--

INSERT INTO `dispositivo` (`IdDispositivo`, `NombreDispositivo`, `DescripcionDispositivo`, `Cantidad`, `Disponibles`, `TipoDispositivo`) VALUES
(1, 'Pc Investigacion1', 'Intel Core i5 8Gb Ram', 2, 1, 'Pc'),
(2, 'VideoBeam', 'Esta en muy buen estado', 4, 4, 'Proyectores');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE IF NOT EXISTS `prestamo` (
  `IdPrestamo` int(11) NOT NULL,
  `FechaPrestamo` date NOT NULL,
  `HoraInicio` time NOT NULL,
  `HoraFin` time NOT NULL,
  `HoraEntrega` time DEFAULT NULL,
  `Cantidad` int(11) NOT NULL,
  `Observacion` varchar(50) DEFAULT NULL,
  `NumeroDocumento` int(11) NOT NULL,
  `TipoDocumento` varchar(25) NOT NULL,
  `IdDispositivo` int(11) NOT NULL,
  PRIMARY KEY (`IdPrestamo`),
  KEY `iddispositivo` (`IdDispositivo`),
  KEY `numeroDocumento` (`NumeroDocumento`),
  KEY `tipoDocumentoPrestamo` (`TipoDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`IdPrestamo`, `FechaPrestamo`, `HoraInicio`, `HoraFin`, `HoraEntrega`, `Cantidad`, `Observacion`, `NumeroDocumento`, `TipoDocumento`, `IdDispositivo`) VALUES
(1, '2014-07-21', '08:01:28', '10:01:28', '09:50:00', 1, 'Se entrego el producto en buen estado', 1036941185, 'Cedula', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `Rol` varchar(25) NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`Rol`, `Descripcion`) VALUES
('Administrador', 'Rol de los usuarios que administran el sistema'),
('Investigador', 'Rol de los usuarios que pueden realizar prestamos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE IF NOT EXISTS `solicitud` (
  `IdSolicitud` int(11) NOT NULL,
  `FechaSolicitud` date NOT NULL,
  `FechaPrestamo` date NOT NULL,
  `HoraInicioPrestamo` time NOT NULL,
  `HoraFinPrestamo` time NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `NumeroDocumento` int(11) NOT NULL,
  `TipoDocumento` varchar(25) NOT NULL,
  `IdDispositivo` int(11) NOT NULL,
  PRIMARY KEY (`IdSolicitud`),
  KEY `tipoDocumentoSolicitud` (`TipoDocumento`),
  KEY `numeroDocumentoSolicitud` (`NumeroDocumento`),
  KEY `idDispositivoSolicitud` (`IdDispositivo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodispositivo`
--

CREATE TABLE IF NOT EXISTS `tipodispositivo` (
  `TipoDispositivo` varchar(25) NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TipoDispositivo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipodispositivo`
--

INSERT INTO `tipodispositivo` (`TipoDispositivo`, `Descripcion`) VALUES
('Microscopio', 'Categoria para los diferentes microscopios.'),
('Pc', 'Categoria para los computadores de escritorio'),
('Proyectores', 'Dispositivos como Video Beam,etc.'),
('Transistror', 'Descripcion del transistor :P');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE IF NOT EXISTS `tipodocumento` (
  `TipoDocumento` varchar(25) NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TipoDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`TipoDocumento`, `Descripcion`) VALUES
('Cedula', 'Cedula de Ciudadania'),
('Id', 'Tipo de documento proporcionado por la empresa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `NumeroDocumento` int(11) NOT NULL,
  `TipoDocumento` varchar(25) CHARACTER SET latin1 NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `Apellido` varchar(25) NOT NULL,
  `Contrasena` varchar(25) NOT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Rol` varchar(25) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`NumeroDocumento`,`TipoDocumento`),
  KEY `rol` (`Rol`),
  KEY `tipoDocumento` (`TipoDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`NumeroDocumento`, `TipoDocumento`, `Nombre`, `Apellido`, `Contrasena`, `Email`, `Rol`) VALUES
(5982, 'Id', 'David', 'Florez', '123', 'david.r.florez@algo.com', 'Investigador'),
(1036941185, 'Cedula', 'Cristian', 'Ospina', 'contrasena1', 'ospinaospinacristian@gmail.com', 'Administrador');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dispositivo`
--
ALTER TABLE `dispositivo`
  ADD CONSTRAINT `tipoDispositivo` FOREIGN KEY (`TipoDispositivo`) REFERENCES `tipodispositivo` (`TipoDispositivo`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `iddispositivo` FOREIGN KEY (`IdDispositivo`) REFERENCES `dispositivo` (`IdDispositivo`),
  ADD CONSTRAINT `numeroDocumento` FOREIGN KEY (`NumeroDocumento`) REFERENCES `usuario` (`NumeroDocumento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tipoDocumentoPrestamo` FOREIGN KEY (`TipoDocumento`) REFERENCES `usuario` (`TipoDocumento`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `idDispositivoSolicitud` FOREIGN KEY (`IdDispositivo`) REFERENCES `dispositivo` (`IdDispositivo`),
  ADD CONSTRAINT `numeroDocumentoSolicitud` FOREIGN KEY (`NumeroDocumento`) REFERENCES `usuario` (`NumeroDocumento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tipoDocumentoSolicitud` FOREIGN KEY (`TipoDocumento`) REFERENCES `usuario` (`TipoDocumento`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `rol` FOREIGN KEY (`Rol`) REFERENCES `rol` (`Rol`),
  ADD CONSTRAINT `tipoDocumento` FOREIGN KEY (`TipoDocumento`) REFERENCES `tipodocumento` (`TipoDocumento`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
