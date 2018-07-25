-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-07-2018 a las 05:14:59
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `barberq`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE `client` (
  `ID` bigint(20) NOT NULL,
  `PHONE` bigint(20) NOT NULL,
  `EMAIL` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`ID`, `PHONE`, `EMAIL`) VALUES
(1, 4125204186, 'analecia@hotmail.com'),
(2, 4128519120, 'saraycol1@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employee`
--

CREATE TABLE `employee` (
  `ID` bigint(20) NOT NULL,
  `PERSON_DNI` bigint(20) NOT NULL,
  `JOB_TITTLE_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `employee`
--

INSERT INTO `employee` (`ID`, `PERSON_DNI`, `JOB_TITTLE_ID`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `haircut_type`
--

CREATE TABLE `haircut_type` (
  `ID` bigint(20) NOT NULL,
  `STYLE` varchar(100) NOT NULL,
  `PRICE` float NOT NULL,
  `GENDER` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `haircut_type`
--

INSERT INTO `haircut_type` (`ID`, `STYLE`, `PRICE`, `GENDER`) VALUES
(1, 'refinado', 10500, 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `job_tittle`
--

CREATE TABLE `job_tittle` (
  `NAME` varchar(50) DEFAULT NULL,
  `ID` bigint(20) NOT NULL,
  `WORK_POSITION_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `job_tittle`
--

INSERT INTO `job_tittle` (`NAME`, `ID`, `WORK_POSITION_ID`) VALUES
('profetion1', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `meeting`
--

CREATE TABLE `meeting` (
  `EMPLOYEE_SUPPORT` bigint(20) NOT NULL,
  `ID` bigint(20) NOT NULL,
  `DATE` date NOT NULL DEFAULT '0000-00-00',
  `CLIENT_ID` bigint(20) NOT NULL,
  `HAIRCUT` bigint(20) DEFAULT NULL,
  `USER_ID` int(20) NOT NULL,
  `COMPLETEDWORK` tinyint(1) NOT NULL DEFAULT '0',
  `TOTALPRICE` double(100,2) DEFAULT NULL,
  `DISCOUNT` int(3) DEFAULT NULL,
  `HOUR` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `meeting`
--

INSERT INTO `meeting` (`EMPLOYEE_SUPPORT`, `ID`, `DATE`, `CLIENT_ID`, `HAIRCUT`, `USER_ID`, `COMPLETEDWORK`, `TOTALPRICE`, `DISCOUNT`, `HOUR`) VALUES
(1, 1, '2018-06-28', 1, 1, 1, 1, 12800.00, 20, '00:00:00'),
(1, 2, '2018-06-28', 1, 1, 1, 1, 25500.00, 0, '00:00:00'),
(1, 3, '2018-07-21', 2, 1, 1, 1, 20400.00, 20, '00:00:00'),
(1, 4, '2018-07-23', 2, 1, 1, 1, 12800.00, 20, '12:12:12'),
(1, 5, '2018-07-24', 1, 1, 1, 1, 19125.00, 25, '10:34:00'),
(1, 6, '2018-07-24', 1, 1, 1, 0, NULL, NULL, '22:30:00'),
(1, 7, '2018-07-23', 2, 1, 1, 1, 4000.00, 75, '00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `meetserv`
--

CREATE TABLE `meetserv` (
  `ids` bigint(15) NOT NULL,
  `idm` bigint(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `meetserv`
--

INSERT INTO `meetserv` (`ids`, `idm`) VALUES
(1, 1),
(2, 2),
(2, 3),
(1, 4),
(2, 5),
(1, 6),
(1, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `ID` bigint(15) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `LAST_NAME` varchar(30) NOT NULL,
  `PHONE` bigint(10) NOT NULL,
  `GENDER` char(1) NOT NULL,
  `TYPEPERSON` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`ID`, `NAME`, `LAST_NAME`, `PHONE`, `GENDER`, `TYPEPERSON`) VALUES
(2, 'Ana', 'Torrealba', 4125204186, 'F', 'Client'),
(1, 'jhonatan', 'Crespo', 4128505504, 'M', 'Employee'),
(4, 'Saray', 'Colmenarez', 4128519120, 'F', 'Client');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service`
--

CREATE TABLE `service` (
  `ID` bigint(15) NOT NULL,
  `PRICE` float(15,0) NOT NULL,
  `NAME` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `service`
--

INSERT INTO `service` (`ID`, `PRICE`, `NAME`) VALUES
(1, 5500, 'secado'),
(2, 15000, 'planchado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `ID` int(20) NOT NULL,
  `NAME` varchar(50) CHARACTER SET latin5 NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `EMPLOYEE_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`ID`, `NAME`, `PASSWORD`, `EMPLOYEE_ID`) VALUES
(1, 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `work_position`
--

CREATE TABLE `work_position` (
  `NAME` varchar(50) DEFAULT NULL,
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `work_position`
--

INSERT INTO `work_position` (`NAME`, `ID`) VALUES
('position1', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `phoneperson` (`PHONE`) USING BTREE;

--
-- Indices de la tabla `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`) USING BTREE,
  ADD KEY `person` (`PERSON_DNI`) USING BTREE,
  ADD KEY `JobTitle` (`JOB_TITTLE_ID`);

--
-- Indices de la tabla `haircut_type`
--
ALTER TABLE `haircut_type`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `haircut` (`ID`) USING BTREE;

--
-- Indices de la tabla `job_tittle`
--
ALTER TABLE `job_tittle`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `position_id` (`WORK_POSITION_ID`);

--
-- Indices de la tabla `meeting`
--
ALTER TABLE `meeting`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `userfo` (`USER_ID`),
  ADD KEY `clientt` (`CLIENT_ID`) USING HASH,
  ADD KEY `haircut` (`HAIRCUT`),
  ADD KEY `employe` (`EMPLOYEE_SUPPORT`);

--
-- Indices de la tabla `meetserv`
--
ALTER TABLE `meetserv`
  ADD KEY `id_s` (`ids`),
  ADD KEY `id_m` (`idm`);

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`PHONE`,`ID`),
  ADD KEY `dni` (`ID`) USING BTREE;

--
-- Indices de la tabla `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `employee` (`EMPLOYEE_ID`);

--
-- Indices de la tabla `work_position`
--
ALTER TABLE `work_position`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `client`
--
ALTER TABLE `client`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `employee`
--
ALTER TABLE `employee`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `haircut_type`
--
ALTER TABLE `haircut_type`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `job_tittle`
--
ALTER TABLE `job_tittle`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `meeting`
--
ALTER TABLE `meeting`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `person`
--
ALTER TABLE `person`
  MODIFY `ID` bigint(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `service`
--
ALTER TABLE `service`
  MODIFY `ID` bigint(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `work_position`
--
ALTER TABLE `work_position`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `phoneperson` FOREIGN KEY (`PHONE`) REFERENCES `person` (`PHONE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `JobTitle` FOREIGN KEY (`JOB_TITTLE_ID`) REFERENCES `job_tittle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `person` FOREIGN KEY (`PERSON_DNI`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `job_tittle`
--
ALTER TABLE `job_tittle`
  ADD CONSTRAINT `word` FOREIGN KEY (`WORK_POSITION_ID`) REFERENCES `work_position` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `meeting`
--
ALTER TABLE `meeting`
  ADD CONSTRAINT `client` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `employe` FOREIGN KEY (`EMPLOYEE_SUPPORT`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `haircut` FOREIGN KEY (`HAIRCUT`) REFERENCES `haircut_type` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `userfo` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `meetserv`
--
ALTER TABLE `meetserv`
  ADD CONSTRAINT `id_m` FOREIGN KEY (`idm`) REFERENCES `meeting` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_s` FOREIGN KEY (`ids`) REFERENCES `service` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `employee` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
