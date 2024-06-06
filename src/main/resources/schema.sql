-- Tablas principales
-- Crear tabla roles
CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR NOT NULL
);

-- Crear tabla permisos
CREATE TABLE IF NOT EXISTS permisos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR NOT NULL
);

-- Crear tabla departamentos
CREATE TABLE IF NOT EXISTS departamentos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(75) NOT NULL,
    pais VARCHAR(75) NOT NULL
);

-- Crear tabla tipos_faltas
CREATE TABLE IF NOT EXISTS tipos_faltas (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(75) NOT NULL
);

-- Crear tabla categorias_contenidos
CREATE TABLE IF NOT EXISTS categorias_contenidos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100)
);

-- Crear tabla tipos_prestamos
CREATE TABLE IF NOT EXISTS tipos_prestamos (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(25) NOT NULL
);

-- Crear tabla servicios
CREATE TABLE IF NOT EXISTS servicios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio_unitario DOUBLE PRECISION NOT NULL CHECK (precio_unitario > 0)
);

-- Tablas secundarias
-- Crear tabla roles_permisos
CREATE TABLE IF NOT EXISTS roles_permisos (
    id SERIAL PRIMARY KEY,
    id_rol INT REFERENCES roles(id),
    id_permiso INT REFERENCES permisos(id),
    CONSTRAINT fk_rol FOREIGN KEY (id_rol) REFERENCES roles(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_permiso FOREIGN KEY (id_permiso) REFERENCES permisos(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- Crear tabla ciudades
CREATE TABLE IF NOT EXISTS ciudades (
    id SERIAL PRIMARY KEY,
    id_departamento INT REFERENCES departamentos(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    nombre VARCHAR(75) NOT NULL,
    codigo_ciudad VARCHAR(25)
);

-- Crear tabla contenidos
CREATE TABLE IF NOT EXISTS contenidos (
    id SERIAL PRIMARY KEY,
    id_categoria INT REFERENCES categorias_contenidos(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    publicador VARCHAR(50) NOT NULL,
    fecha_publicacion DATE NOT NULL,
    ISBN VARCHAR(100),
    idioma VARCHAR(25) NOT NULL,
    ruta_imagen VARCHAR(150),
    prestable BOOLEAN NOT NULL DEFAULT TRUE
);

-- Crear tabla inventario
CREATE TABLE IF NOT EXISTS inventario (
    id_contenido INT REFERENCES contenidos(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    unidades_registradas INT NOT NULL CHECK (unidades_registradas > 0),
    unidades_disponibles INT NOT NULL CHECK (unidades_disponibles >= 0)
);

-- Crear tabla direcciones
CREATE TABLE IF NOT EXISTS direcciones (
    id SERIAL PRIMARY KEY,
    id_ciudad INT REFERENCES ciudades(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    linea1 VARCHAR(150) NOT NULL,
    linea2 VARCHAR(150) NOT NULL,
    casa VARCHAR(25) NOT NULL,
    referencia VARCHAR(150),
    codigo_postal VARCHAR(25)
);

-- Crear tabla usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id SERIAL PRIMARY KEY,
    id_rol INT REFERENCES roles(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    id_direccion INT REFERENCES direcciones(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    fecha_registro DATE DEFAULT CURRENT_DATE,
    eliminado BOOLEAN NOT NULL DEFAULT FALSE
);

-- Crear tabla faltas
CREATE TABLE IF NOT EXISTS faltas (
    id_usuario INT REFERENCES usuarios(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    id_falta INT REFERENCES tipos_faltas(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- Crear tabla prestamos
CREATE TABLE IF NOT EXISTS prestamos (
    id SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuarios(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    id_contenido INT REFERENCES contenidos(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    id_tipo INT REFERENCES tipos_prestamos(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    fecha_prestamo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_devolucion TIMESTAMP
);

-- Crear tabla cobros
CREATE TABLE IF NOT EXISTS cobros (
    id SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuarios(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    id_servicio INT REFERENCES servicios(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    cantidad INT NOT NULL CHECK (cantidad > 0),
    total DOUBLE PRECISION NOT NULL CHECK (total > 0),
    fecha_cobro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crear tabla carnets
CREATE TABLE IF NOT EXISTS carnets (
    carnet VARCHAR(25) PRIMARY KEY,
    id_usuario INT REFERENCES usuarios(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    fecha_emision DATE DEFAULT CURRENT_DATE,
    fecha_vencimiento DATE
);