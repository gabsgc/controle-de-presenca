package br.edu.universidadedevassouras.SCP.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PessoaResponse {
    private Long id;
    private String cpf;
    private String nome;
    private Integer matricula;
    private Date dataNascimento;
    private String genero;
    private String foto;
}
