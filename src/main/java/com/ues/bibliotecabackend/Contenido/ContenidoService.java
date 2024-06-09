package com.ues.bibliotecabackend.Contenido;


import com.ues.bibliotecabackend.Contenido.responses.ContenidoResponse;
import com.ues.bibliotecabackend.Contenido.responses.ContenidoIndexResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContenidoService {
  private final ContenidoRepository contenidoRepository;

  public List<ContenidoResponse> findAll(String busqueda) throws Exception {
    throw new UnsupportedOperationException("No se implementara por tamano de la tabla");
  }

  public Page<ContenidoIndexResponse> paginate(String busqueda, Pageable paginacion) throws Exception {
    try {
      Page<Contenido> contenidos = busqueda != null ? contenidoRepository.busqueda(busqueda, paginacion)
          : contenidoRepository.findAll(paginacion);
      return contenidos.map(ContenidoIndexResponse::new);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public ContenidoResponse findById(Long id) throws EntityNotFoundException {
    var contenido = contenidoRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Libro con contenido " + id + " no encontrado"));
    return new ContenidoResponse(contenido);
  }

  
  public Contenido findEntityById(Long id) throws EntityNotFoundException {
   return contenidoRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Contenido con id " + id + " no encontrado"));
  }

  public ContenidoResponse save(Contenido entity) throws Exception {
    return new ContenidoResponse(contenidoRepository.save(entity));
  }

  public ContenidoResponse update(Contenido entity) throws EntityNotFoundException {
    return new ContenidoResponse(contenidoRepository.save(entity));
  }

  public boolean delete(Long id) throws EntityNotFoundException {
    contenidoRepository.deleteById(id);
    return true;
  }
}
