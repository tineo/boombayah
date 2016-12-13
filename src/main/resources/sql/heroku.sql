CREATE TABLE IF NOT EXISTS `etiqueta` (
  `id_etiqueta` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_etiqueta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table biblioteca.etiqueta_libro
CREATE TABLE IF NOT EXISTS `etiqueta_libro` (
  `id_etiqueta_libro` int(11) NOT NULL AUTO_INCREMENT,
  `id_libro` varchar(10) NOT NULL,
  `id_etiqueta` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_etiqueta_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table biblioteca.existencias
CREATE TABLE IF NOT EXISTS `existencias` (
  `id_existencias` int(11) NOT NULL AUTO_INCREMENT,
  `id_libro` varchar(10) NOT NULL,
  `ubicacion` varchar(45) DEFAULT 'FISI',
  `estado` varchar(20) DEFAULT NULL,
  `tipoPrestamo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_existencias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table biblioteca.libro
CREATE TABLE IF NOT EXISTS `libro` (
  `id_libro` int(11) NOT NULL AUTO_INCREMENT,
  `codigoClasificacion` varchar(20) DEFAULT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `formato` varchar(45) DEFAULT NULL,
  `ISBN` varchar(45) DEFAULT NULL,
  `autor` varchar(45) DEFAULT NULL,
  `pieImprenta` varchar(45) DEFAULT NULL,
  `paginas` int(11) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `idioma` varchar(20) DEFAULT NULL,
  `vistas` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table biblioteca.prestamo
CREATE TABLE IF NOT EXISTS `prestamo` (
  `id_prestamo` int(11) NOT NULL,
  `id_existencia` varchar(10) DEFAULT NULL,
  `fecha_prestamo` date DEFAULT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `codigo_alumno` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_prestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table biblioteca.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) DEFAULT NULL,
  `apellido_paterno` varchar(45) DEFAULT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;