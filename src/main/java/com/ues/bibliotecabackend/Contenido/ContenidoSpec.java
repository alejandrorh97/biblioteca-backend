package com.ues.bibliotecabackend.Contenido;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ContenidoSpec {

  public static Specification<Contenido> withBusqueda(String busqueda) {
    return new Specification<Contenido>() {
      @Override
      public Predicate toPredicate(Root<Contenido> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (busqueda == null) {
          return criteriaBuilder.conjunction();
        }
        return criteriaBuilder.or(
            criteriaBuilder.like(criteriaBuilder.lower(root.get("titulo")), "%" + busqueda.toLowerCase() + "%"),
            criteriaBuilder.like(criteriaBuilder.lower(root.get("autor")), "%" + busqueda.toLowerCase() + "%"),
            criteriaBuilder.like(criteriaBuilder.lower(root.get("publicador")), "%" + busqueda.toLowerCase() + "%"),
            criteriaBuilder.like(criteriaBuilder.lower(root.get("genero")), "%" + busqueda.toLowerCase() + "%"),
            criteriaBuilder.like(criteriaBuilder.lower(root.get("isbn")), "%" + busqueda.toLowerCase() + "%")
        );
      }
    };
  }

  public static Specification<Contenido> hasCategoria(Integer categoria) {
    return new Specification<Contenido>() {
      @Override
      public Predicate toPredicate(Root<Contenido> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (categoria == null || categoria == 0) {
          return criteriaBuilder.conjunction();
        }
        return criteriaBuilder.equal(root.get("categoria").get("id"), categoria);
      }
    };
  }
  
}
