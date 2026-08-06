package br.senac.escolainfo.mapper;


import br.senac.escolainfo.dto.MatriculaDTO;
import br.senac.escolainfo.model.Aluno;
import br.senac.escolainfo.model.Curso;
import br.senac.escolainfo.model.Matricula;



public class MatriculaMapper {


    public static MatriculaDTO toDTO(Matricula matricula){


        MatriculaDTO dto = new MatriculaDTO();


        dto.setIdMatricula(
                matricula.getIdMatricula()
        );


        if(matricula.getAluno()!=null){

            dto.setIdAluno(
                    matricula.getAluno().getIdAluno()
            );

        }


        if(matricula.getCurso()!=null){

            dto.setIdCurso(
                    matricula.getCurso().getIdCurso()
            );

        }


        dto.setDataMatricula(
                matricula.getDataMatricula()
        );


        dto.setStatus(
                matricula.getStatus()
        );


        return dto;

    }




    public static Matricula toEntity(MatriculaDTO dto){


        Matricula matricula = new Matricula();


        matricula.setIdMatricula(
                dto.getIdMatricula()
        );


        if(dto.getIdAluno()!=null){

            Aluno aluno = new Aluno();

            aluno.setIdAluno(dto.getIdAluno());

            matricula.setAluno(aluno);

        }



        if(dto.getIdCurso()!=null){

            Curso curso = new Curso();

            curso.setIdCurso(dto.getIdCurso());

            matricula.setCurso(curso);

        }


        matricula.setDataMatricula(
                dto.getDataMatricula()
        );


        matricula.setStatus(
                dto.getStatus()
        );


        return matricula;

    }

}