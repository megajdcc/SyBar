-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-07-2018 a las 08:44:30
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
-- Base de datos: `barber2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE `client` (
  `ID` bigint(20) NOT NULL,
  `PHONE` bigint(10) UNSIGNED ZEROFILL NOT NULL DEFAULT '0000000000',
  `EMAIL` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`ID`, `PHONE`, `EMAIL`) VALUES
(38, 0525542577, 'adad@'),
(39, 0012122121, 'adad@');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employee`
--

CREATE TABLE `employee` (
  `ID` bigint(20) NOT NULL,
  `PERSON_ID` bigint(20) NOT NULL,
  `JOB_TITTLE_ID` bigint(20) DEFAULT NULL,
  `ENTRYTIME` time NOT NULL DEFAULT '00:00:00',
  `DEPARTURETIME` time NOT NULL DEFAULT '00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Volcado de datos para la tabla `employee`
--

INSERT INTO `employee` (`ID`, `PERSON_ID`, `JOB_TITTLE_ID`, `ENTRYTIME`, `DEPARTURETIME`) VALUES
(200834677, 148, 21, '04:00:00', '14:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empwork`
--

CREATE TABLE `empwork` (
  `idemployee` bigint(15) NOT NULL,
  `idwork` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empwork`
--

INSERT INTO `empwork` (`idemployee`, `idwork`) VALUES
(148, 4),
(148, 5),
(148, 3),
(148, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `haircut_type`
--

CREATE TABLE `haircut_type` (
  `ID` bigint(20) NOT NULL,
  `STYLE` varchar(100) NOT NULL,
  `PRICE` float NOT NULL,
  `GENDER` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Volcado de datos para la tabla `haircut_type`
--

INSERT INTO `haircut_type` (`ID`, `STYLE`, `PRICE`, `GENDER`) VALUES
(11, 'תספורת גבר', 50, 'M'),
(12, 'תספורת נשים', 120, 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `job_tittle`
--

CREATE TABLE `job_tittle` (
  `NAME` varchar(50) DEFAULT NULL,
  `ID` bigint(20) NOT NULL,
  `WORK_POSITION_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Volcado de datos para la tabla `job_tittle`
--

INSERT INTO `job_tittle` (`NAME`, `ID`, `WORK_POSITION_ID`) VALUES
('ספר נשים', 21, 28),
('ספר גברים', 22, 29);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `meeting`
--

CREATE TABLE `meeting` (
  `EMPLOYEE_SUPPORT` bigint(20) NOT NULL,
  `ID` bigint(20) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `CLIENT_ID` bigint(20) NOT NULL,
  `HAIRCUT` bigint(20) DEFAULT NULL,
  `USER_ID` int(20) NOT NULL,
  `COMPLETEDWORK` tinyint(1) NOT NULL DEFAULT '0',
  `TOTALPRICE` double(100,2) DEFAULT NULL,
  `DISCOUNT` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Volcado de datos para la tabla `meeting`
--

INSERT INTO `meeting` (`EMPLOYEE_SUPPORT`, `ID`, `DATE`, `CLIENT_ID`, `HAIRCUT`, `USER_ID`, `COMPLETEDWORK`, `TOTALPRICE`, `DISCOUNT`) VALUES
(200834677, 27, '2018-07-14 20:18:36', 38, 11, 39, 1, 137.50, 45),
(200834677, 28, '2018-07-14 21:02:13', 38, 11, 39, 1, 250.00, 0),
(200834677, 29, '2018-07-14 21:02:30', 38, 11, 39, 1, 50.00, 0),
(200834677, 30, '2018-07-16 19:14:48', 38, 11, 39, 1, 187.50, 25),
(200834677, 31, '2018-07-16 19:15:23', 38, 11, 39, 1, 142.50, 5),
(200834677, 35, '2018-07-17 17:13:07', 38, 11, 39, 1, 50.00, 0),
(200834677, 37, '2018-07-21 13:37:09', 39, 12, 39, 1, 143.00, 35),
(200834677, 38, '2018-07-26 00:42:04', 38, 11, 39, 1, 52.50, 65),
(200834677, 39, '2018-07-26 12:12:12', 39, 12, 39, 0, NULL, NULL),
(200834677, 40, '2018-07-26 01:25:56', 38, 12, 39, 1, 224.00, 30),
(200834677, 41, '2018-07-26 02:12:03', 38, 12, 39, 1, 110.00, 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `meetserv`
--

CREATE TABLE `meetserv` (
  `ids` bigint(15) NOT NULL,
  `idm` bigint(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Volcado de datos para la tabla `meetserv`
--

INSERT INTO `meetserv` (`ids`, `idm`) VALUES
(10, 28),
(10, 30),
(11, 31),
(11, 37),
(11, 38),
(11, 39),
(10, 40),
(11, 41);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `ID` bigint(15) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `LAST_NAME` varchar(30) NOT NULL,
  `PHONE` bigint(10) UNSIGNED NOT NULL,
  `GENDER` char(1) NOT NULL,
  `TYPEPERSON` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`ID`, `NAME`, `LAST_NAME`, `PHONE`, `GENDER`, `TYPEPERSON`) VALUES
(150, 'aaa', 'aaa', 12122121, 'M', 'Client'),
(148, 'עידן', 'קלופפר', 525542571, 'M', 'Employee'),
(149, 'חן', 'יפרח', 525542577, 'M', 'Client');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service`
--

CREATE TABLE `service` (
  `ID` bigint(15) NOT NULL,
  `PRICE` float(15,0) NOT NULL,
  `NAME` varchar(255) CHARACTER SET hebrew COLLATE hebrew_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Volcado de datos para la tabla `service`
--

INSERT INTO `service` (`ID`, `PRICE`, `NAME`) VALUES
(10, 200, 'צבע'),
(11, 100, 'גוונים');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `ID` int(20) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `EMPLOYEE_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`ID`, `NAME`, `PASSWORD`, `EMPLOYEE_ID`) VALUES
(39, 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 200834677);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `workdays`
--

CREATE TABLE `workdays` (
  `days` varchar(20) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `workdays`
--

INSERT INTO `workdays` (`days`, `id`) VALUES
('Monday', 1),
('Tuesday', 2),
('Wednesday', 3),
('Thursday', 4),
('Friday', 5),
('Saturday', 6),
('Sunday', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `work_position`
--

CREATE TABLE `work_position` (
  `NAME` varchar(50) DEFAULT NULL,
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Volcado de datos para la tabla `work_position`
--

INSERT INTO `work_position` (`NAME`, `ID`) VALUES
('1', 28),
('2', 29);

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
  ADD KEY `person` (`PERSON_ID`) USING BTREE,
  ADD KEY `JobTitle` (`JOB_TITTLE_ID`);

--
-- Indices de la tabla `empwork`
--
ALTER TABLE `empwork`
  ADD KEY `workdays` (`idwork`),
  ADD KEY `employefrk` (`idemployee`);

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
  ADD KEY `PHONE` (`PHONE`),
  ADD KEY `idPerson` (`ID`) USING BTREE;

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
-- Indices de la tabla `workdays`
--
ALTER TABLE `workdays`
  ADD PRIMARY KEY (`id`);

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
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de la tabla `employee`
--
ALTER TABLE `employee`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=200834678;

--
-- AUTO_INCREMENT de la tabla `haircut_type`
--
ALTER TABLE `haircut_type`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `job_tittle`
--
ALTER TABLE `job_tittle`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `meeting`
--
ALTER TABLE `meeting`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `person`
--
ALTER TABLE `person`
  MODIFY `ID` bigint(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- AUTO_INCREMENT de la tabla `service`
--
ALTER TABLE `service`
  MODIFY `ID` bigint(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de la tabla `workdays`
--
ALTER TABLE `workdays`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `work_position`
--
ALTER TABLE `work_position`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

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
  ADD CONSTRAINT `person` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empwork`
--
ALTER TABLE `empwork`
  ADD CONSTRAINT `workdays` FOREIGN KEY (`idwork`) REFERENCES `workdays` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `job_tittle`
--
ALTER TABLE `job_tittle`
  ADD CONSTRAINT `position_id` FOREIGN KEY (`WORK_POSITION_ID`) REFERENCES `work_position` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `meeting`
--
ALTER TABLE `meeting`
  ADD CONSTRAINT `client` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `employe` FOREIGN KEY (`EMPLOYEE_SUPPORT`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `haircut` FOREIGN KEY (`HAIRCUT`) REFERENCES `haircut_type` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
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
