package pe.upn.repository;

import org.springframework.data.jpa.repository.EntityGraph;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upn.model.Usuario;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
   @EntityGraph(attributePaths = "authorities")
   Optional<Usuario> findOneWithAuthoritiesByUsuario(String username);
}
