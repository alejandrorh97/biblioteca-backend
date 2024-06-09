package com.ues.bibliotecabackend.Contenido;

import com.ues.bibliotecabackend.Contenido.responses.ContenidoIndexResponse;
import com.ues.bibliotecabackend.Contenido.responses.ContenidoResponse;
import com.ues.bibliotecabackend.global.responses.DeleteResponse;
import com.ues.bibliotecabackend.security.HasPermission;
import jakarta.validation.Valid;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contenidos")
public class ContenidoController {
  private final ContenidoService contenidoService;

  @GetMapping("/index")
  @HasPermission("contenidos_index")
  public Page<ContenidoIndexResponse> index(@RequestParam Map<String, String> request) throws Exception {
    int page = request.get("page") != null ? Integer.parseInt(request.get("page")) : 0;
    int size = request.get("size") != null ? Integer.parseInt(request.get("size")) : 10;
    int rol = request.get("categoria") != null ? Integer.parseInt(request.get("categoria")) : 0;
    String busqueda = request.get("busqueda") != null ? request.get("busqueda") : "";

    Pageable paginacion = PageRequest.of(page, size);
    return contenidoService.paginate(busqueda, rol, paginacion);
  }

  @GetMapping("/show/{id}")
  @HasPermission("contenidos_show")
  public ContenidoResponse show(@PathVariable Long id) throws Exception {
    return contenidoService.findById(id);
  }

  @PatchMapping("/update/{id}")
  @HasPermission("contenidos_update")
  public ContenidoResponse update(@PathVariable Long id, @Valid @RequestBody ContenidoResponse request)
      throws Exception {
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
