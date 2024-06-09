package com.ues.bibliotecabackend.Ciudad;

import com.ues.bibliotecabackend.Ciudad.responses.CiudadResponse;
import com.ues.bibliotecabackend.Ciudad.responses.CiudadIndexResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CiudadService {
  private final CiudadRepository ciudadRepository;

  public List<CiudadResponse> findAll(String busqueda) throws Exception {
    throw new UnsupportedOperationException("No se implementara por tamano de la tabla");
  }

  public Page<CiudadIndexResponse> paginate(String busqueda, Pageable paginacion) throws Exception {
    try {
      Page<Ciudad> ciudad = busqueda != null ? ciudadRepository.busqueda(busqueda, paginacion)
          : ciudadRepository.findAll(paginacion);
      return ciudad.map(CiudadIndexResponse::new);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public CiudadResponse findById(Long id) throws EntityNotFoundException {
    var ciudad = ciudadRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Ciudad con id " + id + " no encontrado"));
    return new CiudadResponse(ciudad);
  }

  public Ciudad findEntityById(Long id) throws EntityNotFoundException {
   return ciudadRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Ciudad con id " + id + " no encontrado"));
  }

  public CiudadResponse save(Ciudad entity) throws Exception {
    return new CiudadResponse(ciudadRepository.save(entity));
  }

  public CiudadResponse update(Ciudad entity) throws EntityNotFoundException {
    return new CiudadResponse(ciudadRepository.save(entity));
  }

  public boolean delete(Long id) throws EntityNotFoundException {
    ciudadRepository.deleteById(id);
    return true;
  }
}