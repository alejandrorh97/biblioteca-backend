package com.ues.bibliotecabackend.Usuario;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UsuarioSpec {
  public static Specification<Usuario> withBusqueda(String busqueda) {
    return new Specification<Usuario>() {
      @Override
      public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (busqueda == null) {
          return criteriaBuilder.conjunction();
        }
        return criteriaBuilder.or(
            criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + busqueda.toLowerCase() + "%"),
            criteriaBuilder.like(criteriaBuilder.lower(root.get("apellido")), "%" + busqueda.toLowerCase() + "%"),
            criteriaBuilder.like(criteriaBuilder.lower(root.get("correo")), "%" + busqueda.toLowerCase() + "%"),
            criteriaBuilder.like(criteriaBuilder.lower(root.get("telefono")), "%" + busqueda.toLowerCase() + "%")
        );
      }
    };
  }

  public static Specification<Usuario> hasRol(Integer rol) {
    return new Specification<Usuario>() {
      @Override
      public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (rol == null || rol == 0) {
          return criteriaBuilder.conjunction();
        }
        return criteriaBuilder.equal(root.get("rol").get("id"), rol);
      }
    };
  }
}
