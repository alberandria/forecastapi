CREATE TABLE `forecast` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` int(11) NOT NULL,
  `forecast` varchar(45) NOT NULL,
  `areaTriangle` decimal(2,0) NOT NULL,
  `degVulcano` int(11) NOT NULL,
  `degBetasoide` int(11) NOT NULL,
  `degFerengi` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idforecast_UNIQUE` (`id`),
  UNIQUE KEY `day_UNIQUE` (`day`)
);