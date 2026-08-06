package br.senac.escolainfo.service;


import br.senac.escolainfo.model.Usuario;
import br.senac.escolainfo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {


    private final UsuarioRepository repository;


    public UsuarioService(UsuarioRepository repository){
        this.repository=repository;
    }



    public List<Usuario> listar(){
        return repository.findAll();
    }



    public Usuario buscar(Integer id){

        return repository.findById(id)
                .orElseThrow(() ->
                new RuntimeException("Usuário não encontrado"));
    }



    public Usuario salvar(Usuario usuario){
        return repository.save(usuario);
    }



    public void excluir(Integer id){
        repository.deleteById(id);
    }

}
