package pe.upn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.upn.model.Persona;

@Repository
public interface IPersonaRepository extends CrudRepository<Persona, Long> {
}
