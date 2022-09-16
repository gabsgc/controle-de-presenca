package br.edu.universidadedevassouras.SCP.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PessoaNotFoundException extends RuntimeException {
    public PessoaNotFoundException() {
        super("Pessoa não encontrada.");
    }
}
