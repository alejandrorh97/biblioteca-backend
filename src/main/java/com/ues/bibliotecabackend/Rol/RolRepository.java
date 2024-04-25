package com.ues.bibliotecabackend.Rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
  public Rol findByNombre(String nombre);

  public boolean existsByNombre(String nombre);
}
