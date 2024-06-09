package com.ues.bibliotecabackend.Ciudad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ues.bibliotecabackend.Ciudad.requests.CiudadIndexRequest;
import com.ues.bibliotecabackend.Ciudad.requests.CiudadUpdate;
import com.ues.bibliotecabackend.Ciudad.responses.CiudadIndexResponse;
import com.ues.bibliotecabackend.Ciudad.responses.CiudadResponse;
import com.ues.bibliotecabackend.global.responses.DeleteResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ciudades")
public class CiudadController {
  private final CiudadService ciudadService;

  @GetMapping("/index")
  public Page<CiudadIndexResponse> index(@Valid CiudadIndexRequest request) throws Exception {
    System.out.println("INDEX");
    final Pageable paginacion = PageRequest.of(request.getPage(), request.getSize());
    return ciudadService.paginate(request.getBusqueda(), paginacion);
  }

  @GetMapping("/show/{id}")
  public CiudadResponse show(@PathVariable Long id) throws Exception {
    return ciudadService.findById(id);
  }

  @PatchMapping("/update/{id}")
  public CiudadResponse update(@PathVariable Long id, @Valid @RequestBody CiudadUpdate request) throws Exception {
    Ciudad ciudad = ciudadService.findEntityById(id);
    if (request.getNombre() != null) {
      ciudad.setNombre(request.getNombre());
    }
    if (request.getCodigo_ciudad() != null) {
      ciudad.setCodigo_ciudad(request.getCodigo_ciudad());
    }
    
    return ciudadService.update(ciudad);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<DeleteResponse> delete(@PathVariable Long id) throws Exception {
    ciudadService.delete(id);
    return ResponseEntity.ok(new DeleteResponse("Ciudad eliminada correctamente"));
  }
}