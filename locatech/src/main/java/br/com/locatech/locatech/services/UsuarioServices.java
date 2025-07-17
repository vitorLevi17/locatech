package br.com.locatech.locatech.services;

import br.com.locatech.locatech.entitys.Usuarios;
import br.com.locatech.locatech.repository.UsuarioRepositoryImp;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {

    private UsuarioRepositoryImp usuarioRepositoryImp;
    public UsuarioServices(UsuarioRepositoryImp usuarioRepositoryImp) {
        this.usuarioRepositoryImp = usuarioRepositoryImp;
    }
    public List<Usuarios> findAllUsuarios(int page, int size){
        int offset = (page-1) * size;
        return this.usuarioRepositoryImp.findAll(size,offset);
    }
    public Optional<Usuarios> findUsuarioById(Long id){
        return this.usuarioRepositoryImp.findById(id);
    }
    public Optional<Usuarios> findUsuarioByUsuario(String usuario){
        return this.usuarioRepositoryImp.findByUsuario(usuario);
    }
    public void saveUsuario(Usuarios usuarios){
        var save = this.usuarioRepositoryImp.save(usuarios);
        //Verificar se só 1 linha foi afetada e mandar msg de erro
        Assert.state(save == 1,"Erro ao salvar Usuario");
    }

    public void updateUsuario(Usuarios usuarios,Long id){
        var update = this.usuarioRepositoryImp.update(usuarios,id);
        if (update == 0){
            throw new RuntimeException("Usuario não encontrado");
        }
    }
    public void deleteUsuario(Long id){
        var delete = this.usuarioRepositoryImp.delete(id);
        if (delete == 0){
            throw new RuntimeException("Usuario não encontrado");
        }
    }



}
