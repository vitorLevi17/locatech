package br.com.locatech.locatech.repository;

import br.com.locatech.locatech.entitys.Aluguel;

import java.util.List;
import java.util.Optional;

public interface AluguelRepostory {

    Optional<Aluguel> findById(Long id);
    List<Aluguel> findAll(int size, int offset);
    Integer save(Aluguel aluguel);
    Integer update(Aluguel aluguel,Long id);
    Integer delete(Long id);
}
