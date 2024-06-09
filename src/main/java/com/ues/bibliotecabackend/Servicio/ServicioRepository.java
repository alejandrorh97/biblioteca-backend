package com.ues.bibliotecabackend.Servicio;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
  public Optional<Servicio> findByCorreo(String correo);

  public boolean existsByCorreo(String correo);

  @Query(
    value = "SELECT * FROM usuarios WHERE nombre LIKE %?1% OR apellido LIKE %?1% OR correo LIKE %?1% or telefono LIKE %?2%",
    nativeQuery = true
  )
  public Page<Servicio> busqueda(String busqueda, Pageable pageable);
}
