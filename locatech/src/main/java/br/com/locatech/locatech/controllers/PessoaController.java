package br.com.locatech.locatech.controllers;

import br.com.locatech.locatech.entitys.Pessoa;
import br.com.locatech.locatech.services.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);
    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAllPessoas(
            @RequestParam("page") int page,
            @RequestParam("size")int size
    ){
        logger.info("O endpoint foi acessado para ver veiculos");
        var pessoas = this.pessoaService.findAllPessoa(page, size);
        return ResponseEntity.ok(pessoas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findByIdPessoa(@PathVariable("id")Long id){
        logger.info("O endpoint foi acessado para ver 1 pessoa");
        var pessoa = this.pessoaService.findPessoaById(id);
        return ResponseEntity.ok(pessoa);
    }
    @PostMapping
    public ResponseEntity<Void> savePessoa(@RequestBody Pessoa pessoa){
        logger.info("O endpoint foi acessado para criar 1 pessoa");
        this.pessoaService.savePessoa(pessoa);
        return ResponseEntity.status(201).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(@PathVariable("id")Long id, @RequestBody Pessoa pessoa){
        logger.info("O endpoint foi acessado para atualizar 1 pessoa");
        this.pessoaService.updatePessoa(pessoa,id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable("id")Long id){
        logger.info("O endpoint foi acessado para deletar 1 pessoa");
        this.pessoaService.deletePessoa(id);
        return ResponseEntity.ok().build();
    }
}