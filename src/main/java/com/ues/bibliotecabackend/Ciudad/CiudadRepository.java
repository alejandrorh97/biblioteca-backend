package com.ues.bibliotecabackend.Ciudad;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
  public Optional<Ciudad> findByCorreo(String correo);

  public boolean existsByCorreo(String correo);

  @Query(
    value = "SELECT * FROM usuarios WHERE nombre LIKE %?1% OR apellido LIKE %?1% OR correo LIKE %?1% or telefono LIKE %?2%",
    nativeQuery = true
  )
  public Page<Ciudad> busqueda(String busqueda, Pageable pageable);
}
