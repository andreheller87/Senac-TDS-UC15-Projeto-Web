package br.senac.escolainfo.mapper;


import br.senac.escolainfo.dto.CursoDTO;
import br.senac.escolainfo.model.Curso;
import br.senac.escolainfo.model.Professor;


public class CursoMapper {


    public static CursoDTO toDTO(Curso curso){

        CursoDTO dto = new CursoDTO();


        dto.setIdCurso(curso.getIdCurso());
        dto.setNome(curso.getNome());
        dto.setDescricao(curso.getDescricao());
        dto.setCargaHoraria(curso.getCargaHoraria());
        dto.setValor(curso.getValor());
        dto.setDataInicio(curso.getDataInicio());
        dto.setDataTermino(curso.getDataTermino());


        if(curso.getProfessor()!=null){
            dto.setIdProfessor(
                    curso.getProfessor().getIdProfessor()
            );
        }


        return dto;
    }





    public static Curso toEntity(CursoDTO dto){

        Curso curso = new Curso();


        curso.setIdCurso(dto.getIdCurso());
        curso.setNome(dto.getNome());
        curso.setDescricao(dto.getDescricao());
        curso.setCargaHoraria(dto.getCargaHoraria());
        curso.setValor(dto.getValor());
        curso.setDataInicio(dto.getDataInicio());
        curso.setDataTermino(dto.getDataTermino());


        if(dto.getIdProfessor()!=null){

            Professor professor = new Professor();

            professor.setIdProfessor(dto.getIdProfessor());

            curso.setProfessor(professor);
        }


        return curso;
    }

}