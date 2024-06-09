package com.ues.bibliotecabackend.Contenido;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
  
    Optional<Contenido> findByTitulo(String titulo);
  
    Optional<Contenido> findByAutor(String autor);
  
    Optional<Contenido> findByIsbn(String isbn);
  
    boolean existsByTitulo(String titulo);
  
    boolean existsByAutor(String autor);
  
    boolean existsByIsbn(String isbn);
  
      @Query(
        value = "SELECT * FROM contenids WHERE titulo LIKE %?1% OR autor LIKE %?1% OR isbn LIKE %?1%",
        nativeQuery = true
        )

    public Page<Contenido> busqueda(String busqueda, Pageable pageable);
    // Método para realizar una búsqueda general por título, autor e ISBN
    Page<Contenido> findByTituloContainingOrAutorContainingOrIsbnContaining(String titulo, String autor, String isbn, Pageable pageable);
}
