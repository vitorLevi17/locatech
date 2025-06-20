package br.com.locatech.locatech.services;

import br.com.locatech.locatech.dtos.AluguelRequesstDTO;
import br.com.locatech.locatech.entitys.Aluguel;
import br.com.locatech.locatech.repository.AluguelRepostory;
import br.com.locatech.locatech.repository.VeiculoRepository;
import br.com.locatech.locatech.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepostory aluguelRepostory;
    private final VeiculoRepository veiculoRepository;

    public AluguelService(AluguelRepostory aluguelRepostory, VeiculoRepository veiculoRepository) {
        this.aluguelRepostory = aluguelRepostory;
        this.veiculoRepository = veiculoRepository;
    }
    public List<Aluguel> findAllAluguel(int page, int size){
        int offset = (page-1) * size;
        return this.aluguelRepostory.findAll(size,offset);
    }
    public Optional<Aluguel> findAluguelById(Long id){
        return Optional.ofNullable(this.aluguelRepostory.findById(id).orElseThrow(() -> new ResourceNotFoundException("ALUGUEL NÃO ENCONTRADO")));
    }

    public void saveAluguel(AluguelRequesstDTO aluguel){
        var aluguel_entity = calculaAluguel(aluguel);
        var save = this.aluguelRepostory.save(aluguel_entity);
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
    private Aluguel calculaAluguel(AluguelRequesstDTO aluguelRequesstDTO){
        var veiculo = this.veiculoRepository.findById(aluguelRequesstDTO.veiculo_id()).orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
        var qntd_dias = BigDecimal.valueOf(aluguelRequesstDTO.data_final().getDayOfYear() - aluguelRequesstDTO.data_inicio().getDayOfYear());
        var valor = veiculo.getDiaria_valor().multiply(qntd_dias);
        return new Aluguel(aluguelRequesstDTO,valor);
    }
}