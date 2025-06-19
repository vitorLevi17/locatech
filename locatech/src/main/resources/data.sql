CREATE TABLE VEICULOS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR (255),
    modelo VARCHAR (255),
    placa VARCHAR (255),
    ano INT,
    cor VARCHAR(255),
    diaria_valor DECIMAL(10,2)
);
INSERT INTO veiculos(marca,modelo,placa,ano,cor,diaria_valor) values ('VW','GOL','PQP2025',2025,'AZUL',300.00);

CREATE TABLE PESSOA(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR (255),
    cpf VARCHAR (255),
    telefone VARCHAR (255),
    email VARCHAR (255)
);
INSERT INTO pessoa(nome,cpf,telefone,email) values('YLDIZ','10000110001','1010101010','yl@gmail.com');