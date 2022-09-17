package br.edu.universidadedevassouras.SCP.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PessoaUpdateRequest {

    private Date dataNascimento;

    private String foto;
}
