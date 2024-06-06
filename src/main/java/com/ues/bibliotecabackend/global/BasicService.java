package com.ues.bibliotecabackend.global;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.EntityNotFoundException;

public interface BasicService<E> {
  public List<Object> findAll(String busqueda) throws Exception;

  public Page<Object> paginate(String busqueda, Pageable paginacion) throws Exception;

  public E findById(Long id) throws EntityNotFoundException;

  public E findEntityById(Long id) throws EntityNotFoundException;

  public E save(E entity) throws Exception;

  public E update(E entity) throws EntityNotFoundException;

  public boolean delete(Long id) throws EntityNotFoundException;
}