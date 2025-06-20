package br.com.locatech.locatech.controllers;

import br.com.locatech.locatech.entitys.Aluguel;

import br.com.locatech.locatech.services.AluguelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    private static final Logger logger = LoggerFactory.getLogger(AluguelController.class);
    private final AluguelService aluguelService;
    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }
    @GetMapping
    public ResponseEntity<List<Aluguel>> findAllAluguel(
            @RequestParam("page") int page,
            @RequestParam("size")int size
    ){
        logger.info("O endpoint foi acessado para ver alugueis");
        var alugueis = this.aluguelService.findAllAluguel(page, size);
        return ResponseEntity.ok(alugueis);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findByIdAluguel(@PathVariable("id")Long id){
        logger.info("O endpoint foi acessado para ver 1 aluguel");
        var aluguel = this.aluguelService.findAluguelById(id);
        return ResponseEntity.ok(aluguel);
    }
    @PostMapping
    public ResponseEntity<Void> saveAluguel(@RequestBody Aluguel aluguel){
        logger.info("O endpoint foi acessado para criar 1 aluguel");
        this.aluguelService.saveAluguel(aluguel);
        return ResponseEntity.status(201).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAluguel(@PathVariable("id")Long id, @RequestBody Aluguel aluguel){
        logger.info("O endpoint foi acessado para atualizar 1 aluguel");
        this.aluguelService.updateAluguel(aluguel,id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluguel(@PathVariable("id")Long id){
        logger.info("O endpoint foi acessado para deletar 1 aluguel");
        this.aluguelService.deleteAluguel(id);
        return ResponseEntity.ok().build();
    }
}