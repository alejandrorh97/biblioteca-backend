package com.ues.bibliotecabackend.Rol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ues.bibliotecabackend.Rol.responses.RolResponse;
import com.ues.bibliotecabackend.global.BasicService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolService implements BasicService<Rol, RolResponse> {
  private final RolRepository rolRepository;

  @Override
  public List<RolResponse> findAll(String busqueda) throws Exception {
    ArrayList<RolResponse> roles = new ArrayList<>();
    rolRepository.findAll().forEach(rol -> roles.add(rol.toResponse()));
    return roles;
  }

  @Override
  public Page<RolResponse> paginate(String busqueda, Pageable paginacion) throws Exception {
    try {
      Page<Rol> roles = busqueda != null ? rolRepository.busqueda(busqueda, paginacion)
          : rolRepository.findAll(paginacion);
      return roles.map(rol -> rol.toResponse());
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public RolResponse findById(Long id) throws EntityNotFoundException {
    return rolRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Rol con id " + id + " no encontrado"))
        .toResponse();
  }

  @Override
  public Rol findEntityById(Long id) throws EntityNotFoundException {
    return rolRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Rol con id " + id + " no encontrado"));
  }

  @Override
  public RolResponse save(Rol entity) throws Exception {
    return rolRepository.save(entity).toResponse();
  }

  @Override
  public RolResponse update(Rol entity) throws EntityNotFoundException {
    return rolRepository.save(entity).toResponse();
  }

  @Override
  public boolean delete(Long id) throws EntityNotFoundException {
    rolRepository.deleteById(id);
    return true;
  }
}
