package br.edu.universidadedevassouras.SCP.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class PresencaRequest {
    @NotEmpty(message = "Por favor, informe a data.")
    private Date data;

    @NotEmpty(message = "Por favor, informe a situação (ausente ou presente).")
    private Boolean situacao;

    @NotEmpty(message = "Por favor, informe o id da pessoa.")
    private Long pessoa;
}
