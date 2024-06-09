package com.ues.bibliotecabackend.Contenido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long>, JpaSpecificationExecutor<Contenido> {
  public boolean existsByTitulo(String titulo);

  public Contenido findByTitulo(String titulo);
}
