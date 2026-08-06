package br.senac.escolainfo.service;


import br.senac.escolainfo.model.Certificado;
import br.senac.escolainfo.repository.CertificadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CertificadoService {


    private final CertificadoRepository repository;


    public CertificadoService(CertificadoRepository repository){
        this.repository=repository;
    }



    public List<Certificado> listar(){
        return repository.findAll();
    }



    public Certificado buscar(Integer id){

        return repository.findById(id)
                .orElseThrow(() ->
                new RuntimeException("Certificado não encontrado"));
    }



    public Certificado salvar(Certificado certificado){
        return repository.save(certificado);
    }



    public void excluir(Integer id){
        repository.deleteById(id);
    }

}