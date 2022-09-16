package br.edu.universidadedevassouras.SCP.repository;

import br.edu.universidadedevassouras.SCP.model.entity.Presenca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresencaRepository extends CrudRepository<Presenca, Long> {
}
