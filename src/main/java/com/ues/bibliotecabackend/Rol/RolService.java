package com.ues.bibliotecabackend.Rol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ues.bibliotecabackend.Rol.responses.RolResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolService {
  private final RolRepository rolRepository;

  public List<RolResponse> findAll(String busqueda) throws Exception {
    ArrayList<RolResponse> roles = new ArrayList<>();
    rolRepository.findAll().forEach(rol -> new RolResponse(rol));
    return roles;
  }

  public Page<RolResponse> paginate(String busqueda, Pageable paginacion) throws Exception {
    try {
      Page<Rol> roles = busqueda != null ? rolRepository.busqueda(busqueda, paginacion)
          : rolRepository.findAll(paginacion);
      return roles.map(RolResponse::new);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public RolResponse findById(Long id) throws EntityNotFoundException {
    var rol = rolRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Rol con id " + id + " no encontrado"));
    return new RolResponse(rol);
  }

  public Rol findEntityById(Long id) throws EntityNotFoundException {
    return rolRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Rol con id " + id + " no encontrado"));
  }

  public RolResponse save(Rol entity) throws Exception {
    return new RolResponse(rolRepository.save(entity));
  }

  public RolResponse update(Rol entity) throws EntityNotFoundException {
    return new RolResponse(rolRepository.save(entity));
  }

  
  public boolean delete(Long id) throws EntityNotFoundException {
    rolRepository.deleteById(id);
    return true;
  }
}
