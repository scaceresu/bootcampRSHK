
-- creando la tabla usuarios 
-- Serial hace que sea del tipo entero y autoincremento 
CREATE TABLE usuarios(
	id SERIAL PRIMARY KEY,
	username varchar(30) UNIQUE NOT NULL ,
	password varchar(30) NOT NULL,
	date_of_birth DATE
);


CREATE TABLE posteos (
    id SERIAL PRIMARY KEY,                             -- ID del post
    creator_id INT NOT NULL REFERENCES usuarios(id),   -- relación con usuario
    texto TEXT NOT NULL,                               -- contenido del post
    date_of_publishment TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE comentarios(
	id SERIAL PRIMARY KEY,
	texto varchar(100) NOT NULL,
	username_id INT NOT NULL REFERENCES usuarios(id),
    date_of_publishment TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);