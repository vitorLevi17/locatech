package br.com.locatech.locatech.services;

import br.com.locatech.locatech.entitys.Aluguel;
import br.com.locatech.locatech.repository.AluguelRepostory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepostory aluguelRepostory;

    public AluguelService(AluguelRepostory aluguelRepostory) {
        this.aluguelRepostory = aluguelRepostory;
    }
    public List<Aluguel> findAllAluguel(int page, int size){
        int offset = (page-1) * size;
        return this.aluguelRepostory.findAll(size,offset);
    }
    public Optional<Aluguel> findAluguelById(Long id){
        return this.aluguelRepostory.findById(id);
    }

    public void saveAluguel(Aluguel aluguel){
        var save = this.aluguelRepostory.save(aluguel);
        //Verificar se só 1 linha foi afetada e mandar msg de erro
        Assert.state(save == 1,"Erro ao salvar o aluguel");
    }
    public void updateAluguel(Aluguel aluguel,Long id){
        var update = this.aluguelRepostory.update(aluguel,id);
        if (update == 0){
            throw new RuntimeException("Aluguel não encontrado");
        }
    }
    public void deleteAluguel(Long id){
        var delete = this.aluguelRepostory.delete(id);
        if (delete == 0){
            throw new RuntimeException("Aluguel não encontrado");
        }
    }
}