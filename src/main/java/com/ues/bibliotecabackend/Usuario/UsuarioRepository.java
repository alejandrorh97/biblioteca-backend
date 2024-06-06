package com.ues.bibliotecabackend.Usuario;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  @EntityGraph(attributePaths = { "rol.permisos" })
  public Optional<Usuario> findByCorreo(String correo);

  public boolean existsByCorreo(String correo);

  @Query(value = "SELECT * FROM usuarios WHERE nombre LIKE %?1% OR apellido LIKE %?1% OR correo LIKE %?1% or telefono LIKE %?2%", nativeQuery = true)
  public Page<Usuario> busqueda(String busqueda, Pageable pageable);

}
