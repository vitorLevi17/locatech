package br.com.locatech.locatech.services;

import br.com.locatech.locatech.entitys.Pessoa;
import br.com.locatech.locatech.repository.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAllPessoa(int page, int size){
        int offset = (page-1) * size;
        return this.pessoaRepository.findAll(size,offset);
    }
    public Optional<Pessoa> findPessoaById(Long id){
        return this.pessoaRepository.findById(id);
    }

    public void savePessoa(Pessoa pessoa){
        var save = this.pessoaRepository.save(pessoa);
        //Verificar se só 1 linha foi afetada e mandar msg de erro
        Assert.state(save == 1,"Erro ao salvar pessoa");
    }
    public void updatePessoa(Pessoa pessoa,Long id){
        var update = this.pessoaRepository.update(pessoa,id);
        if (update == 0){
            throw new RuntimeException("Pessoa não encontrado");
        }
    }
    public void deletePessoa(Long id){
        var delete = this.pessoaRepository.delete(id);
        if (delete == 0){
            throw new RuntimeException("Pessoa não encontrado");
        }
    }
}
