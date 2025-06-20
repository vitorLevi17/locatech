package br.com.locatech.locatech.repository;

import br.com.locatech.locatech.entitys.Aluguel;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AluguelRepositortImp implements AluguelRepostory{
    private final JdbcClient jdbcClient;
    public AluguelRepositortImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Aluguel> findById(Long id) {
        return this.jdbcClient.sql("SELECT a.id,a.pessoa_id,a.veiculo_id,a.data_inicio, a.data_final,a.valor_total, " +
                        "p.nome AS pessoa_nome, p.cpf AS pessoa_CPF, " +
                        "v.modelo AS veiculo_modelo, v.placa AS veiculo_placa " +
                        "FROM aluguel a " +
                        "INNER JOIN pessoa p ON a.pessoa_id = p.id " +
                        "INNER JOIN veiculos v ON a.veiculo_id = v.id " +
                        "WHERE a.id = :id ")
                .param("id",id)
                .query(Aluguel.class)
                .optional();
    }

    @Override
    public List<Aluguel> findAll(int size, int offset) {
        return this.jdbcClient.sql("SELECT a.id,a.pessoa_id,a.veiculo_id,a.data_inicio, a.data_final,a.valor_total, " +
                        "p.nome AS pessoa_nome, p.cpf AS pessoa_CPF, " +
                        "v.modelo AS veiculo_modelo, v.placa AS veiculo_placa " +
                        "FROM aluguel a " +
                        "INNER JOIN pessoa p ON a.pessoa_id = p.id " +
                        "INNER JOIN veiculos v ON a.veiculo_id = v.id " +
                        "LIMIT :size OFFSET :offset")
                .param("size",size)
                .param("offset",offset)
                .query(Aluguel.class)
                .list();
    }

    @Override
    public Integer save(Aluguel aluguel) {
        return this.jdbcClient.sql("INSERT INTO aluguel (pessoa_id,veiculo_id,data_inicio,data_final,valor_total) VALUES(:pessoa_id,:veiculo_id,:data_inicio,:data_final,:valor_total)")
                .param("pessoa_id",aluguel.getPessoa_id())
                .param("veiculo_id",aluguel.getVeiculo_id())
                .param("data_inicio",aluguel.getData_inicio())
                .param("data_final",aluguel.getData_final())
                .param("valor_total",aluguel.getValor_total())
                .update();
    }

    @Override
    public Integer update(Aluguel aluguel, Long id) {
        return this.jdbcClient.sql("UPDATE aluguel SET pessoa_id = :pessoa_id, veiculo_id = :veiculo_id,data_inicio = :data_inicio,data_final = :data_final,valor_total = :valor_total WHERE id = :id")
                .param("id",id)
                .param("pessoa_id",aluguel.getPessoa_id())
                .param("veiculo_id",aluguel.getVeiculo_id())
                .param("data_inicio",aluguel.getData_inicio())
                .param("data_final",aluguel.getData_final())
                .param("valor_total",aluguel.getValor_total())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient.sql("DELETE FROM aluguel WHERE id=:id").param("id",id).update();
    }
}

