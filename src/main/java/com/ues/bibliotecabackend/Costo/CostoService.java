package com.ues.bibliotecabackend.Costo;

import com.ues.bibliotecabackend.Costo.responses.CostoResponse;
import com.ues.bibliotecabackend.Costo.responses.CostoIndexResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostoService {
  private final CostoRepository costoRepository;

  public List<CostoResponse> findAll(String busqueda) throws Exception {
    throw new UnsupportedOperationException("No se implementara por tamano de la tabla");
  }

  public Page<CostoIndexResponse> paginate(String busqueda, Pageable paginacion) throws Exception {
    try {
      Page<Costo> costo = busqueda != null ? costoRepository.busqueda(busqueda, paginacion)
          : costoRepository.findAll(paginacion);
      return costo.map(CostoIndexResponse::new);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public CostoResponse findById(Long id) throws EntityNotFoundException {
    var costo = costoRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Ciudad con id " + id + " no encontrado"));
    return new CostoResponse(costo);
  }

  public Costo findEntityById(Long id) throws EntityNotFoundException {
   return costoRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Ciudad con id " + id + " no encontrado"));
  }

  public CostoResponse save(Costo entity) throws Exception {
    return new CostoResponse(costoRepository.save(entity));
  }

  public CostoResponse update(Costo entity) throws EntityNotFoundException {
    return new CostoResponse(costoRepository.save(entity));
  }

  public boolean delete(Long id) throws EntityNotFoundException {
    costoRepository.deleteById(id);
    return true;
  }
}