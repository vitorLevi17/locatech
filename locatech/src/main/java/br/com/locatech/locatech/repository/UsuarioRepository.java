package br.com.locatech.locatech.repository;

import br.com.locatech.locatech.entitys.Usuarios;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuarios> findById(Long id);
    Optional<Usuarios> findByUsuario(String usuario);
    List<Usuarios> findAll(int size, int offset);
    Integer save(Usuarios Usuarios);
    Integer update(Usuarios Usuarios,Long id);
    Integer delete(Long id);
}
