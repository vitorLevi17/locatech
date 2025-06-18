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