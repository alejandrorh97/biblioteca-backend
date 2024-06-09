package com.ues.bibliotecabackend.Usuario;

import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

  @EntityGraph(attributePaths = { "rol.permisos" })
  public Optional<Usuario> findByCorreo(String correo);

  public boolean existsByCorreo(String correo);
}
