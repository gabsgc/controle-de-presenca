package br.edu.universidadedevassouras.SCP.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class PessoaRequest {

    @NotEmpty(message = "Por favor, informe o cpf.")
    private String cpf;

    @NotEmpty(message = "Por favor, informe o nome.")
    private String nome;

    @NotEmpty(message = "Por favor, informe a matrícula.")
    private Integer matricula;

    private Date dataNascimento;

    private String genero;

    private String foto;
}