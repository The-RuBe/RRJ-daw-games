DROP DATABASE IF EXISTS daw_games;
CREATE DATABASE daw_games;
USE daw_games;

INSERT INTO juego (nombre, genero, plataformas, precio, descargas, fecha_lanzamiento, tipo, completado) VALUES
('Minecraft', 'Sandbox', 'PC, Consolas, Movil', 29.99, 500000000, '2011-11-18', 'BASE', 0),
('Fortnite', 'Battle Royale', 'PC, Consolas, Movil', 0.00, 350000000, '2017-07-25', 'BASE', 0),
('Roblox', 'Plataforma', 'PC, Consolas, Movil', 0.00, 200000000, '2006-09-01', 'BASE', 0),
('Elden Ring: Shadow of the Erdtree', 'RPG', 'PC, Consolas', 39.99, 15000000, '2024-06-21', 'EXPANSION', 0),
('Cyberpunk 2077: Phantom Liberty', 'RPG', 'PC, Consolas', 29.99, 10000000, '2023-09-26', 'DLC', 1),
('Terraria', 'Sandbox', 'PC, Consolas, Movil', 9.99, 40000000, '2011-05-16', 'BASE', 1);