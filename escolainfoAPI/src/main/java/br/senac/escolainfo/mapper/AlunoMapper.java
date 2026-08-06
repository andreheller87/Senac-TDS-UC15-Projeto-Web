package br.senac.escolainfo.mapper;

import br.senac.escolainfo.dto.AlunoDTO;
import br.senac.escolainfo.model.Aluno;

public class AlunoMapper {


    public static AlunoDTO toDTO(Aluno aluno) {

        AlunoDTO dto = new AlunoDTO();

        dto.setIdAluno(aluno.getIdAluno());
        dto.setNome(aluno.getNome());
        dto.setCpf(aluno.getCpf());
        dto.setEmail(aluno.getEmail());
        dto.setTelefone(aluno.getTelefone());
        dto.setStatus(aluno.getStatus());

        return dto;
    }



    public static Aluno toEntity(AlunoDTO dto) {

        Aluno aluno = new Aluno();

        aluno.setIdAluno(dto.getIdAluno());
        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf());
        aluno.setEmail(dto.getEmail());
        aluno.setTelefone(dto.getTelefone());
        aluno.setStatus(dto.getStatus());

        return aluno;
    }

}