package com.ues.bibliotecabackend.Contenido;

import com.ues.bibliotecabackend.Contenido.responses.ContenidoResponse;
import com.ues.bibliotecabackend.Inventario.Inventario;
import com.ues.bibliotecabackend.Categoria.Categoria;
import com.ues.bibliotecabackend.Contenido.responses.ContenidoIndexResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContenidoService {
  private final ContenidoRepository contenidoRepository;

  public List<ContenidoResponse> findAll(String busqueda) throws Exception {
    throw new UnsupportedOperationException("No se implementara por tamano de la tabla");
  }

  public Page<ContenidoIndexResponse> paginate(String busqueda, int categoria, Pageable paginacion) throws Exception {
    try {
      Specification<Contenido> especificacion = Specification.where(ContenidoSpec.withBusqueda(busqueda))
          .and(ContenidoSpec.hasCategoria(categoria));
      return contenidoRepository.findAll(especificacion, paginacion).map(ContenidoIndexResponse::new);
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

  @Transactional
  public Contenido saveCategoria(Contenido entity, Categoria categoria) {
    entity.setCategoria(categoria);
    return contenidoRepository.save(entity);
  }

  @Transactional
  public Contenido saveInventario(Contenido entity, Inventario inventario) {
    entity.setInventario(inventario);
    return contenidoRepository.save(entity);
  }
}
