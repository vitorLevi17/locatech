package br.com.locatech.locatech.repository;

import br.com.locatech.locatech.entitys.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class VeiculoRepositoryImp implements VeiculoRepository{
    //Conexão com H2
    private final JdbcClient jdbcClient;

    public VeiculoRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Veiculo> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM veiculos WHERE id = :id")
                .param("id",id)
                .query(Veiculo.class)
                .optional();
    }

    @Override
    public List<Veiculo> findyAll(int size, int offset) {
        return this.jdbcClient.
                sql("SELECT * FROM veiculos LIMIT : size OFFSET :offset")
                .param("size",size)
                .param("offset",offset)
                .query(Veiculo.class)
                .list();
    }

    @Override
    public Integer save(Veiculo veiculo) {
        return this.jdbcClient.sql("INSERT INTO veiculos (marca, modelo,placa,ano,cor,diaria_valor) VALUES(:marca,:modelo,:placa,:ano,:cor,:diaria_valor)")
                .param("marca",veiculo.getMarca())
                .param("modelo",veiculo.getModelo())
                .param("placa",veiculo.getPlaca())
                .param("ano",veiculo.getAno())
                .param("cor",veiculo.getCor())
                .param("diaria_valor",veiculo.getDiaria_valor()).update();
    }

    @Override
    public Integer update(Veiculo veiculo, Long id) {
        return this.jdbcClient.sql("UPDATE veiculos ( SET marca = :marca,modelo = :modelo,placa = :placa,ano = :ano,cor = :cor,diaria_valor = :diaria_valor WHERE id = :id)")
                .param("id",id)
                .param("marca",veiculo.getMarca())
                .param("modelo",veiculo.getModelo())
                .param("placa",veiculo.getPlaca())
                .param("ano",veiculo.getAno())
                .param("cor",veiculo.getCor())
                .param("diaria_valor",veiculo.getDiaria_valor())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient.sql("DELETE FROM veiculos WHERE id=:id").param("id",id).update();
    }
}
