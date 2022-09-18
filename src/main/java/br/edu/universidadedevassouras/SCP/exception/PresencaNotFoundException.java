package br.edu.universidadedevassouras.SCP.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PresencaNotFoundException extends RuntimeException {
    public PresencaNotFoundException() {
        super("Presenca não encontrada.");
    }
}
