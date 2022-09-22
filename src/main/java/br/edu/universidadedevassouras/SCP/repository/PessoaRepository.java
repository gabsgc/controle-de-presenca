package br.edu.universidadedevassouras.SCP.repository;

import br.edu.universidadedevassouras.SCP.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByUsername(String userName);
}
