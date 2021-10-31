package pe.upn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upn.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
