package br.com.locatech.locatech.repository;

import br.com.locatech.locatech.entitys.Usuarios;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public class UsuarioRepositoryImp implements UsuarioRepository{

    private final JdbcClient jdbcClient;

    public UsuarioRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Usuarios> findById(Long id) {
        return this.jdbcClient.sql("SELECT * FROM usuarios WHERE id = :id")
                .param("id",id)
                .query(Usuarios.class)
                .optional();
    }

    @Override
    public Optional<Usuarios> findByUsuario(String usuario) {
        return this.jdbcClient.sql("SELECT * FROM usuarios WHERE usuarios = :usuarios")
                .param("usuario",usuario)
                .query(Usuarios.class)
                .optional();
    }

    @Override
    public List<Usuarios> findAll(int size, int offset) {
        return this.jdbcClient.sql("SELECT * FROM usuarios LIMIT :size OFFSET :offset")
                .param("size",size)
                .param("offset",offset)
                .query(Usuarios.class)
                .list();
    }

    @Override
    public Integer save(Usuarios usuarios) {
        return this.jdbcClient.sql("INSERT INTO usuarios (usuario,senha,tipo_usuario) VALUES(:usuario,:senha,:tipo_usuario)")
                .param("usuario",usuarios.getUsuario())
                .param("senha",usuarios.getSenha())
                .param("tipo_usuario",usuarios.getTpUsuarioEnum())
                .update();
    }

    @Override
    public Integer update(Usuarios usuarios, Long id) {
        return this.jdbcClient.sql("UPDATE usuarios SET usuario = :usuario,senha = :senha,tipo_usuario = :tipo_usuario WHERE id = :id")
                .param("id",id)
                .param("usuario",usuarios.getUsuario())
                .param("senha",usuarios.getSenha())
                .param("tipo_usuario",usuarios.getTpUsuarioEnum())
                .update();
    }
    @Override
    public Integer delete(Long id) {
        return this.jdbcClient.sql("DELETE FROM usuarios WHERE id=:id").param("id",id).update();
    }
}
