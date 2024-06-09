package com.ues.bibliotecabackend.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria> {
  public boolean existsByNombre(String nombre);
  public Categoria findByNombre(String nombre);
}
