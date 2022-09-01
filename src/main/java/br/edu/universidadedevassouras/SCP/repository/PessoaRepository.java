package br.edu.universidadedevassouras.SCP.repository;

import br.edu.universidadedevassouras.SCP.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
