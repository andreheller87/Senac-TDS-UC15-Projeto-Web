package br.senac.escolainfo.teste;


import br.senac.escolainfo.dto.*;
import br.senac.escolainfo.model.Usuario.Perfil;

import br.senac.escolainfo.service.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.time.LocalDate;



@Component
public class TesteSistema implements CommandLineRunner {


    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final CursoService cursoService;
    private final MatriculaService matriculaService;
    private final PagamentoService pagamentoService;
    private final CertificadoService certificadoService;
    private final UsuarioService usuarioService;
    private final ComunicadoService comunicadoService;



    public TesteSistema(

            AlunoService alunoService,
            ProfessorService professorService,
            CursoService cursoService,
            MatriculaService matriculaService,
            PagamentoService pagamentoService,
            CertificadoService certificadoService,
            UsuarioService usuarioService,
            ComunicadoService comunicadoService

    ){

        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
        this.matriculaService = matriculaService;
        this.pagamentoService = pagamentoService;
        this.certificadoService = certificadoService;
        this.usuarioService = usuarioService;
        this.comunicadoService = comunicadoService;

    }





    @Override
    public void run(String... args){


        System.out.println("==============================");
        System.out.println(" TESTE INTEGRADO ESCOLAINFO ");
        System.out.println("==============================");



        testeAluno();


        testeProfessor();


        testeCurso();


        testeMatricula();


        testePagamento();


        testeCertificado();


        testeUsuario();


        testeComunicado();



        System.out.println("==============================");
        System.out.println(" TODOS OS TESTES FINALIZADOS ");
        System.out.println("==============================");


    }






    private Integer idAluno;
    private Integer idProfessor;
    private Integer idCurso;
    private Integer idMatricula;





    private void testeAluno(){


        System.out.println("\n1 - Testando Aluno");


        AlunoDTO dto = new AlunoDTO();


        dto.setNome("André Teste");


        dto.setCpf("111.222.333-44");


        dto.setEmail("andre@teste.com");


        dto.setTelefone("47999999999");


        dto.setStatus("Ativo");



        AlunoDTO salvo =
                alunoService.salvar(dto);



        idAluno = salvo.getIdAluno();



        System.out.println(
                "Aluno criado ID: "
                + idAluno
        );


    }






    private void testeProfessor(){


        System.out.println("\n2 - Testando Professor");



        ProfessorDTO dto =
                new ProfessorDTO();



        dto.setNome("Professor Teste");


        dto.setDisciplina("Java");


        dto.setHorarioDisponivel("18:00");


        dto.setEmail("professor@teste.com");



        ProfessorDTO salvo =
                professorService.salvar(dto);



        idProfessor =
                salvo.getIdProfessor();



        System.out.println(
                "Professor criado ID: "
                + idProfessor
        );


    }






    private void testeCurso(){


        System.out.println("\n3 - Testando Curso");



        CursoDTO dto =
                new CursoDTO();



        dto.setNome("Curso Java Spring");


        dto.setDescricao(
                "Curso de API REST"
        );


        dto.setCargaHoraria(80);


        dto.setValor(
                new BigDecimal("500")
        );


        dto.setDataInicio(
                LocalDate.now()
        );


        dto.setDataTermino(
                LocalDate.now().plusMonths(3)
        );


        dto.setIdProfessor(
                idProfessor
        );



        CursoDTO salvo =
                cursoService.salvar(dto);



        idCurso =
                salvo.getIdCurso();



        System.out.println(
                "Curso criado ID: "
                + idCurso
        );


    }







    private void testeMatricula(){


        System.out.println("\n4 - Testando Matricula");



        MatriculaDTO dto =
                new MatriculaDTO();



        dto.setIdAluno(idAluno);


        dto.setIdCurso(idCurso);


        dto.setDataMatricula(
                LocalDate.now()
        );


        dto.setStatus("Ativa");



        MatriculaDTO salvo =
                matriculaService.salvar(dto);



        idMatricula =
                salvo.getIdMatricula();



        System.out.println(
                "Matricula criada ID: "
                + idMatricula
        );


    }







    private void testePagamento(){


        System.out.println("\n5 - Testando Pagamento");



        PagamentoDTO dto =
                new PagamentoDTO();



        dto.setIdMatricula(idMatricula);


        dto.setValor(
                new BigDecimal("500")
        );


        dto.setDataPagamento(
                LocalDate.now()
        );


        dto.setStatus("Pago");



        PagamentoDTO salvo =
                pagamentoService.salvar(dto);



        System.out.println(
                "Pagamento criado ID: "
                + salvo.getIdPagamento()
        );


    }






    private void testeCertificado(){


        System.out.println("\n6 - Testando Certificado");



        CertificadoDTO dto =
                new CertificadoDTO();



        dto.setIdMatricula(idMatricula);


        dto.setDataEmissao(
                LocalDate.now()
        );


        dto.setCodigoVerificacao(
                "CERT-0001"
        );



        CertificadoDTO salvo =
                certificadoService.salvar(dto);



        System.out.println(
                "Certificado criado ID: "
                + salvo.getIdCertificado()
        );


    }






    private void testeUsuario(){


        System.out.println("\n7 - Testando Usuario");



        UsuarioDTO dto =
                new UsuarioDTO();



        dto.setNome("Administrador");


        dto.setEmail(
                "admin@teste.com"
        );


        dto.setSenha("123456");


        dto.setPerfil(
                Perfil.Administrador
        );



        UsuarioDTO salvo =
                usuarioService.salvar(dto);



        System.out.println(
                "Usuario criado ID: "
                + salvo.getIdUsuario()
        );


    }






    private void testeComunicado(){


        System.out.println("\n8 - Testando Comunicado");



        ComunicadoDTO dto =
                new ComunicadoDTO();



        dto.setTitulo(
                "Aviso importante"
        );


        dto.setMensagem(
                "Sistema funcionando corretamente"
        );


        dto.setDataEnvio(
                LocalDate.now()
        );



        ComunicadoDTO salvo =
                comunicadoService.salvar(dto);



        System.out.println(
                "Comunicado criado ID: "
                + salvo.getIdComunicado()
        );


    }


}