create database formularioclientes;
use formularioclientes;

CREATE TABLE pais (
  id_pais BIGINT NOT NULL,
  nombre VARCHAR(255),
  PRIMARY KEY (id_pais)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO pais (id_pais, nombre) VALUES
(1, 'Colombia'),
(2, 'Argentina'),
(3, 'Brasil'),
(4, 'Perú');

CREATE TABLE departamento (
  id_departamento BIGINT NOT NULL,
  nombre VARCHAR(255),
  id_pais BIGINT NOT NULL,
  PRIMARY KEY (id_departamento),
  FOREIGN KEY (id_pais) REFERENCES pais(id_pais)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO departamento (id_departamento, nombre, id_pais) VALUES
(1, 'Antioquia', 1),
(2, 'Cundinamarca', 1),
(3, 'Valle del Cauca', 1),
(4, 'Buenos Aires', 2),
(5, 'Córdoba', 2),
(6, 'Mendoza', 2),
(7, 'São Paulo', 3),
(8, 'Río de Janeiro', 3),
(9, 'Bahía', 3),
(10, 'Lima', 4),
(11, 'Cusco', 4),
(12, 'Arequipa', 4);

CREATE TABLE ciudad (
  id_ciudad INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255),
  id_departamento BIGINT NOT NULL,
  PRIMARY KEY (id_ciudad),
  FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO ciudad (id_ciudad, nombre, id_departamento) VALUES
(1, 'Medellín', 1),
(2, 'Bello', 1),
(3, 'Itagüí', 1),
(4, 'Bogotá', 2),
(5, 'Soacha', 2),
(6, 'Zipaquirá', 2),
(7, 'Cali', 3),
(8, 'Palmira', 3),
(9, 'Buenaventura', 3),
(10, 'La Plata', 4),
(11, 'Mar del Plata', 4),
(12, 'Bahía Blanca', 4),
(13, 'Córdoba', 5),
(14, 'Villa María', 5),
(15, 'Río Cuarto', 5),
(16, 'Mendoza', 6),
(17, 'San Rafael', 6),
(18, 'Godoy Cruz', 6),
(19, 'São Paulo', 7),
(20, 'Campinas', 7),
(21, 'Santos', 7),
(22, 'Río de Janeiro', 8),
(23, 'Niterói', 8),
(24, 'Petrópolis', 8),
(25, 'Salvador', 9),
(26, 'Feira de Santana', 9),
(27, 'Ilhéus', 9),
(28, 'Lima', 10),
(29, 'Callao', 10),
(30, 'Chosica', 10),
(31, 'Cusco', 11),
(32, 'Sicuani', 11),
(33, 'Quillabamba', 11),
(34, 'Arequipa', 12),
(35, 'Camaná', 12),
(36, 'Mollendo', 12);

CREATE TABLE cliente (
  id_cliente BIGINT NOT NULL AUTO_INCREMENT,
  tipo_identificacion VARCHAR(10) NOT NULL,
  numero_identificacion VARCHAR(20) NOT NULL UNIQUE,
  nombres VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  direccion VARCHAR(200) NOT NULL,
  id_ciudad INT NOT NULL,
  id_departamento BIGINT NOT NULL,
  id_pais BIGINT NOT NULL,
  marca ENUM('AMERICANINO','AMERICAN_EAGLE','CHEVIGNON','ESPRIT','NAF_NAF','RIFLE') NOT NULL,
  PRIMARY KEY (id_cliente),
  FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad),
  FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento),
  FOREIGN KEY (id_pais) REFERENCES pais(id_pais)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO cliente (id_cliente, tipo_identificacion, numero_identificacion, nombres, apellidos, fecha_nacimiento, direccion, id_ciudad, id_departamento, id_pais, marca) VALUES
(1, 'CC', '12345', 'aillodge andrea', 'suarez acevedo', '2025-08-28', 'Cra 41 #28-52 Sandiego', 2, 1, 1, 'NAF_NAF'),
(3, 'TI', '123458', 'aillodge andrea', 'suarez acevedo', '2025-08-20', 'Cra 41 #28-52 Sandiego', 3, 1, 1, 'AMERICANINO'),
(4, 'CC', '10456', 'Jose', 'Becerra', '2025-08-21', 'sad', 22, 8, 3, 'ESPRIT');
