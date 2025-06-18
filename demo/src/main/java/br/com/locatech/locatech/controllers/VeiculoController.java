package br.com.locatech.locatech.controllers;

import br.com.locatech.locatech.entitys.Veiculo;
import br.com.locatech.locatech.services.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);

    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService=veiculoService;

    }
    @GetMapping
    public ResponseEntity<List<Veiculo>> findAllVeiculos(
            @RequestParam("page") int page,
            @RequestParam("size")int size
    ){
        logger.info("O endpoint foi acessado para ver veiculos");
        var veiculos = this.veiculoService.findAllVeiculos(page,size);
        return ResponseEntity.ok(veiculos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findByIdVeiculo(@PathVariable("id") Long id){
        logger.info("O endpoint foi acessado para ver 1 veiculo");
        var veiculo = this.veiculoService.findVeiculoById(id);
        return ResponseEntity.ok(veiculo);
    }
    @PostMapping
    public ResponseEntity<Void> saveVeiculo(@RequestBody Veiculo veiculo){
        logger.info("O endpoint foi acessado para salvar 1 veiculo");
        this.veiculoService.saveVeiculo(veiculo);
        return ResponseEntity.status(201).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVeiculo(@PathVariable("id") Long id,@RequestBody Veiculo veiculo){
        logger.info("O endpoint foi acessado para atualizar 1 veiculo");
        this.veiculoService.updateVeiculo(veiculo,id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable("id") Long id){
        logger.info("O endpoint foi acessado para deletar 1 veiculo");
        this.veiculoService.deleteVeiculo(id);
        return ResponseEntity.ok().build();
    }
}
