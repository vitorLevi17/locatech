CREATE TABLE VEICULOS(
    id SERIAL PRIMARY KEY,
    marca VARCHAR (255),
    modelo VARCHAR (255),
    placa VARCHAR (255),
    ano INT,
    cor VARCHAR(255),
    diaria_valor DECIMAL(10,2)
);
INSERT INTO veiculos(marca,modelo,placa,ano,cor,diaria_valor) values ('VW','GOL','PQP2025',2025,'AZUL',300.00);

CREATE TABLE PESSOA(
    id SERIAL PRIMARY KEY,
    nome VARCHAR (255),
    cpf VARCHAR (255),
    telefone VARCHAR (255),
    email VARCHAR (255)
);
INSERT INTO pessoa(nome,cpf,telefone,email) values('YLDIZ','10000110001','1010101010','yl@gmail.com');

CREATE TABLE ALUGUEL(
    id SERIAL PRIMARY KEY,
    pessoa_id BIGINT NOT NULL,
    veiculo_id BIGINT NOT NULL,
    data_inicio DATE,
    data_final DATE,
    valor_total DECIMAL(10,2),
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
    FOREIGN KEY (veiculo_id) REFERENCES veiculos(id)
);

INSERT INTO pessoa(nome,cpf,telefone,email) values('Pele','1001','10110','pele@gmail.com');
INSERT INTO veiculos(marca,modelo,placa,ano,cor,diaria_valor) values ('VW','POLO','PDF2025',2025,'PRETO',150.00);
INSERT INTO aluguel(pessoa_id,veiculo_id,data_inicio,data_final,valor_total) values(1,1,'2025-06-19','2025-06-20',300)