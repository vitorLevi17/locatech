package br.com.locatech.locatech.services;

import br.com.locatech.locatech.entitys.Veiculo;
import br.com.locatech.locatech.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findAllVeiculos(int page, int size){
        int offset = (page-1) * size;
        return this.veiculoRepository.findAll(size,offset);
    }
    public Optional<Veiculo> findVeiculoById(Long id){
        return this.veiculoRepository.findById(id);
    }
    public void saveVeiculo(Veiculo veiculo){
        var save = this.veiculoRepository.save(veiculo);
        //Verificar se só 1 linha foi afetada e mandar msg de erro
        Assert.state(save == 1,"Erro ao salvar veiculo");
    }

    public void updateVeiculo(Veiculo veiculo,Long id){
        var update = this.veiculoRepository.update(veiculo,id);
        if (update == 0){
            throw new RuntimeException("Veiculo não encontrado");
        }
    }
    public void deleteVeiculo(Long id){
        var delete = this.veiculoRepository.delete(id);
        if (delete == 0){
            throw new RuntimeException("Veiculo não encontrado");
        }
    }

}
