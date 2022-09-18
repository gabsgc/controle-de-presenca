package br.edu.universidadedevassouras.SCP.model.dto;

import br.edu.universidadedevassouras.SCP.model.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PresencaResponse {
    private Long id;
    private Date data;
    private Boolean situacao;
    private Pessoa pessoa;
}