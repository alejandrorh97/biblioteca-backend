package com.ues.bibliotecabackend.Rol;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
  public Rol findByNombre(String nombre);

  public boolean existsByNombre(String nombre);

  @Query(
    value = "SELECT * FROM roles WHERE nombre LIKE %?1%",
    nativeQuery = true
  )
  public Page<Rol> busqueda(String busqueda, Pageable pageable);
}
