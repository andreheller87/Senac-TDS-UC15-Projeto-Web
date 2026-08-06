package br.senac.escolainfo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> tratarResourceNotFound(
            ResourceNotFoundException ex
    ){


        ErrorResponse erro = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.NOT_FOUND.value(),

                "Recurso não encontrado",

                ex.getMessage()

        );


        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(erro);

    }



}