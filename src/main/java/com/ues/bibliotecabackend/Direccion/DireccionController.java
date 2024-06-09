package com.ues.bibliotecabackend.Direccion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ues.bibliotecabackend.Direccion.requests.DireccionIndexRequest;
import com.ues.bibliotecabackend.Direccion.requests.DireccionUpdate;
import com.ues.bibliotecabackend.Direccion.responses.DireccionIndexResponse;
import com.ues.bibliotecabackend.Direccion.responses.DireccionResponse;
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
@RequestMapping("/direcciones")
public class DireccionController {
  private final DireccionService direccionService;

  @GetMapping("/index")
  public Page<DireccionIndexResponse> index(@Valid DireccionIndexRequest request) throws Exception {
    System.out.println("INDEX");
    final Pageable paginacion = PageRequest.of(request.getPage(), request.getSize());
    return direccionService.paginate(request.getBusqueda(), paginacion);
  }

  @GetMapping("/show/{id}")
  public DireccionResponse show(@PathVariable Long id) throws Exception {
    return direccionService.findById(id);
  }

  @PatchMapping("/update/{id}")
  public DireccionResponse update(@PathVariable Long id, @Valid @RequestBody DireccionUpdate request) throws Exception {
    Direccion direccion = direccionService.findEntityById(id);
    if (request.getLinea1() != null) {
      direccion.setLinea1(request.getLinea1());
    }
    if (request.getLinea2() != null) {
      direccion.setLinea2(request.getLinea2());
    }
    if (request.getCasa() != null) {
      direccion.setCasa(request.getCasa());
    }
    if (request.getReferencia() != null) {
      direccion.setReferencia(request.getReferencia());
    }
    if (request.getCodigo_postal() != null) {
      direccion.setCodigo_postal(request.getCodigo_postal());
    }
    
    return direccionService.update(direccion);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<DeleteResponse> delete(@PathVariable Long id) throws Exception {
    direccionService.delete(id);
    return ResponseEntity.ok(new DeleteResponse("Ciudad eliminada correctamente"));
  }
}