package com.ues.bibliotecabackend.Direccion;

import com.ues.bibliotecabackend.Direccion.responses.DireccionResponse;
import com.ues.bibliotecabackend.Direccion.responses.DireccionIndexResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DireccionService {
  private final DireccionRepository direccionRepository;

  public List<DireccionResponse> findAll(String busqueda) throws Exception {
    throw new UnsupportedOperationException("No se implementara por tamano de la tabla");
  }

  public Page<DireccionIndexResponse> paginate(String busqueda, Pageable paginacion) throws Exception {
    try {
      Page<Direccion> direccion = busqueda != null ? direccionRepository.busqueda(busqueda, paginacion)
          : direccionRepository.findAll(paginacion);
      return direccion.map(DireccionIndexResponse::new);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public DireccionResponse findById(Long id) throws EntityNotFoundException {
    var direccion = direccionRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Ciudad con id " + id + " no encontrado"));
    return new DireccionResponse(direccion);
  }

  public Direccion findEntityById(Long id) throws EntityNotFoundException {
   return direccionRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Ciudad con id " + id + " no encontrado"));
  }

  public DireccionResponse save(Direccion entity) throws Exception {
    return new DireccionResponse(direccionRepository.save(entity));
  }

  public DireccionResponse update(Direccion entity) throws EntityNotFoundException {
    return new DireccionResponse(direccionRepository.save(entity));
  }

  public boolean delete(Long id) throws EntityNotFoundException {
    direccionRepository.deleteById(id);
    return true;
  }
}