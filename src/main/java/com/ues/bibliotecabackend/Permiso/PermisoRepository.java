package com.ues.bibliotecabackend.Permiso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long>{
  public Permiso findByNombre(String nombre);
}
