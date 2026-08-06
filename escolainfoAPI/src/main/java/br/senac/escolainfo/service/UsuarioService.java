package br.senac.escolainfo.service;


import br.senac.escolainfo.dto.UsuarioDTO;
import br.senac.escolainfo.exception.ResourceNotFoundException;
import br.senac.escolainfo.mapper.UsuarioMapper;
import br.senac.escolainfo.model.Usuario;
import br.senac.escolainfo.repository.UsuarioRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class UsuarioService {



    private final UsuarioRepository repository;



    public UsuarioService(UsuarioRepository repository){

        this.repository = repository;

    }





    public List<UsuarioDTO> listar(){


        return repository.findAll()

                .stream()

                .map(UsuarioMapper::toDTO)

                .collect(Collectors.toList());

    }





    public UsuarioDTO buscar(Integer id){


        Usuario usuario = repository.findById(id)

                .orElseThrow(

                () -> new ResourceNotFoundException(
                        "Usuário não encontrado com id: " + id
                )

        );


        return UsuarioMapper.toDTO(usuario);

    }





    public UsuarioDTO salvar(UsuarioDTO dto){


        Usuario usuario =
                UsuarioMapper.toEntity(dto);



        Usuario salvo =
                repository.save(usuario);



        return UsuarioMapper.toDTO(salvo);

    }





    public void excluir(Integer id){

        repository.deleteById(id);

    }

}