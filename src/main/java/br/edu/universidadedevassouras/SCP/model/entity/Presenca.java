package br.edu.universidadedevassouras.SCP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Presenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Boolean situacao;

    @JsonIgnore
    @ManyToOne
    private Pessoa pessoa;
}