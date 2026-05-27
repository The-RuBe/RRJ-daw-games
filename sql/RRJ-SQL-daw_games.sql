DROP DATABASE IF EXISTS daw_games;
CREATE DATABASE daw_games;
USE daw_games;

CREATE TABLE juegos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    genero VARCHAR(50),
    plataforma VARCHAR(50),
    precio DECIMAL(6,2),
    completado BOOLEAN DEFAULT FALSE
);

INSERT INTO juegos (nombre, genero, plataforma, precio, completado) VALUES
("Hollow Knight", "Metroidvania", "PC", 14.99, true),
("Elden Ring", "RPG", "PS5", 59.99, false),
("Stardew Valley", "Simulación", "Nintendo Switch", 13.99, true),
("Zelda: Breath of the Wild", "Aventura", "Nintendo Switch", 59.99, true),
("Cyberpunk 2077", "Acción", "PC", 29.99, false);