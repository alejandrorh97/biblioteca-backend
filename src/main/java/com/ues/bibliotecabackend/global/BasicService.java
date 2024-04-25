package com.ues.bibliotecabackend.global;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.EntityNotFoundException;

public interface BasicService<E, D> {
  public List<D> findAll(String busqueda) throws Exception;

  public Page<D> paginate(String busqueda, Pageable paginacion) throws Exception;

  public D findById(Long id) throws EntityNotFoundException;

  public E findEntityById(Long id) throws EntityNotFoundException;

  public D save(E entity) throws Exception;

  public D update(E entity) throws EntityNotFoundException;

  public boolean delete(Long id) throws EntityNotFoundException;
}