package br.com.locatech.locatech.controllers;

import br.com.locatech.locatech.entitys.Usuarios;
import br.com.locatech.locatech.services.UsuarioServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    private UsuarioServices usuarioServices;

    public UsuarioController(UsuarioServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }
    @GetMapping
    public ResponseEntity<List<Usuarios>> findAllUsuarios(
            @RequestParam("page") int page,
            @RequestParam("size")int size
    ){
        logger.info("O endpoint foi acessado para ver Usuarios");
        var usuarios = this.usuarioServices.findAllUsuarios(page,size);
        return ResponseEntity.ok(usuarios);
    }
}
