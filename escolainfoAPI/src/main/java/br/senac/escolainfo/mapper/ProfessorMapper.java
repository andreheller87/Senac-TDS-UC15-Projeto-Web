package br.senac.escolainfo.mapper;


import br.senac.escolainfo.dto.ProfessorDTO;
import br.senac.escolainfo.model.Professor;



public class ProfessorMapper {



    public static ProfessorDTO toDTO(Professor professor){


        ProfessorDTO dto = new ProfessorDTO();


        dto.setIdProfessor(
                professor.getIdProfessor()
        );


        dto.setNome(
                professor.getNome()
        );


        dto.setDisciplina(
                professor.getDisciplina()
        );


        dto.setHorarioDisponivel(
                professor.getHorarioDisponivel()
        );


        dto.setEmail(
                professor.getEmail()
        );


        return dto;

    }





    public static Professor toEntity(ProfessorDTO dto){


        Professor professor = new Professor();


        professor.setIdProfessor(
                dto.getIdProfessor()
        );


        professor.setNome(
                dto.getNome()
        );


        professor.setDisciplina(
                dto.getDisciplina()
        );


        professor.setHorarioDisponivel(
                dto.getHorarioDisponivel()
        );


        professor.setEmail(
                dto.getEmail()
        );


        return professor;

    }

}