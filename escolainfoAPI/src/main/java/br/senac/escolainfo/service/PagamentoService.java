package br.senac.escolainfo.service;


import br.senac.escolainfo.dto.PagamentoDTO;
import br.senac.escolainfo.exception.ResourceNotFoundException;
import br.senac.escolainfo.mapper.PagamentoMapper;
import br.senac.escolainfo.model.Pagamento;
import br.senac.escolainfo.repository.PagamentoRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class PagamentoService {



    private final PagamentoRepository repository;



    public PagamentoService(PagamentoRepository repository){

        this.repository = repository;

    }





    public List<PagamentoDTO> listar(){


        return repository.findAll()

                .stream()

                .map(PagamentoMapper::toDTO)

                .collect(Collectors.toList());

    }





    public PagamentoDTO buscar(Integer id){


        Pagamento pagamento = repository.findById(id)

                .orElseThrow(

                () -> new ResourceNotFoundException(
                        "Pagamento não encontrado com id: " + id
                )

        );


        return PagamentoMapper.toDTO(pagamento);

    }





    public PagamentoDTO salvar(PagamentoDTO dto){


        Pagamento pagamento = PagamentoMapper.toEntity(dto);


        Pagamento salvo = repository.save(pagamento);


        return PagamentoMapper.toDTO(salvo);

    }





    public void excluir(Integer id){

        repository.deleteById(id);

    }

}