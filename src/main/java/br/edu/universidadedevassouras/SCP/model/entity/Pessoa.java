package br.edu.universidadedevassouras.SCP.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private Integer matricula;

    private Date dataNascimento;

    private String genero;

    @Lob
    private String Foto;

    @OneToMany(mappedBy = "pessoa")
    private List<Presenca> presencas;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
