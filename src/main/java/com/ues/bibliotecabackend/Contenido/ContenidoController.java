package com.ues.bibliotecabackend.Contenido;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ues.bibliotecabackend.global.responses.DeleteResponse;
import com.ues.bibliotecabackend.security.HasPermission;
import com.ues.bibliotecabackend.Contenido.responses.ContenidoIndexResponse;
import com.ues.bibliotecabackend.Contenido.requests.ContenidoIndexRequest;
import com.ues.bibliotecabackend.Contenido.responses.ContenidoResponse;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RestController
@RequestMapping("/contenidos")
public class ContenidoController {
      private final ContenidoService contenidoService;

  @GetMapping("/index")
  @HasPermission("contenidos_index")
  public Page<ContenidoIndexResponse> index(@Valid ContenidoIndexRequest request) throws Exception {
    System.out.println("INDEX");
    final Pageable paginacion = PageRequest.of(request.getPage(), request.getSize());
    return contenidoService.paginate(request.getBusqueda(), paginacion);
  }

  @GetMapping("/show/{id}")
  @HasPermission("contenidos_show")
  public ContenidoResponse show(@PathVariable Long id) throws Exception {
    return contenidoService.findById(id);
  }

  @PatchMapping("/update/{id}")
  @HasPermission("contenidos_update")
  public ContenidoResponse update(@PathVariable Long id, @Valid @RequestBody ContenidoResponse request) throws Exception {
    Contenido contenido = contenidoService.findEntityById(id);
    if (request.getTitulo() != null) {
      contenido.setTitulo(request.getTitulo());
    }
    if (request.getAutor() != null) {
      contenido.setAutor(request.getAutor());
    }
    if (request.getGenero() != null) {
      contenido.setGenero(request.getGenero());
    }
    if (request.getPublicador() != null) {
      contenido.setPublicador(request.getPublicador());
    }
    if (request.getFechaPublicacion() != null) {
      contenido.setFechaPublicacion(request.getFechaPublicacion());
    }
    if (request.getIsbn() != null) {
      contenido.setIsbn(request.getIsbn());
    }
    if (request.getIdioma() != null) {
      contenido.setIdioma(request.getIdioma());
    }
    if (request.getRutaImagen() != null) {
      contenido.setRutaImagen(request.getIsbn());
    }
    if (request.getPrestable() != null) {
      contenido.setPrestable(request.getPrestable());
    }
    return contenidoService.update(contenido);
  }

  @DeleteMapping("/delete/{id}")
  @HasPermission("contenidos_delete")
  public ResponseEntity<DeleteResponse> delete(@PathVariable Long id) throws Exception {
    contenidoService.delete(id);
    return ResponseEntity.ok(new DeleteResponse("Usuario eliminado correctamente"));
  }
}
