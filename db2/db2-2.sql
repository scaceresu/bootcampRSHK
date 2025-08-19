-- Esquema de base de datos para un campeonato de futbol tipo Mundial

-- Tabla de torneos
CREATE TABLE torneos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    anio INT NOT NULL,
    sede VARCHAR(100) NOT NULL
);

-- Tabla de fases (ej: Grupos, Octavos, Cuartos, Semifinal, Final)
CREATE TABLE fases (
    id SERIAL PRIMARY KEY,
    torneo_id INT REFERENCES torneos(id),
    nombre VARCHAR(50) NOT NULL,
    orden INT NOT NULL
);

-- Tabla de grupos (A, B, C, ...)
CREATE TABLE grupos (
    id SERIAL PRIMARY KEY,
    fase_id INT REFERENCES fases(id),
    nombre VARCHAR(5) NOT NULL
);

-- Tabla de equipos
CREATE TABLE equipos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    confederacion VARCHAR(50),
    grupo_id INT REFERENCES grupos(id)
);

-- Tabla de partidos
CREATE TABLE partidos (
    id SERIAL PRIMARY KEY,
    fase_id INT REFERENCES fases(id),
    grupo_id INT REFERENCES grupos(id),
    equipo_local INT REFERENCES equipos(id),
    equipo_visitante INT REFERENCES equipos(id),
    fecha TIMESTAMP NOT NULL,
    estadio VARCHAR(100),
    CONSTRAINT chk_distintos CHECK (equipo_local <> equipo_visitante)
);

-- Tabla de resultados
CREATE TABLE resultados (
    partido_id INT PRIMARY KEY REFERENCES partidos(id),
    goles_local INT NOT NULL DEFAULT 0 CHECK (goles_local >= 0),
    goles_visitante INT NOT NULL DEFAULT 0 CHECK (goles_visitante >= 0),
    ganador INT REFERENCES equipos(id)
);
