package com.ues.bibliotecabackend.Costo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ues.bibliotecabackend.Costo.requests.CostoIndexRequest;
import com.ues.bibliotecabackend.Costo.requests.CostoUpdate;
import com.ues.bibliotecabackend.Costo.responses.CostoIndexResponse;
import com.ues.bibliotecabackend.Costo.responses.CostoResponse;
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
@RequestMapping("/costos")
public class CostoController {
  private final CostoService costoService;

  @GetMapping("/index")
  public Page<CostoIndexResponse> index(@Valid CostoIndexRequest request) throws Exception {
    System.out.println("INDEX");
    final Pageable paginacion = PageRequest.of(request.getPage(), request.getSize());
    return costoService.paginate(request.getBusqueda(), paginacion);
  }

  @GetMapping("/show/{id}")
  public CostoResponse show(@PathVariable Long id) throws Exception {
    return costoService.findById(id);
  }

  @PatchMapping("/update/{id}")
  public CostoResponse update(@PathVariable Long id, @Valid @RequestBody CostoUpdate request) throws Exception {
    Costo costo = costoService.findEntityById(id);
    if (request.getCantidad() != null) {
      costo.setCantidad(request.getCantidad());
    }
    if (request.getTotal() != null) {
      costo.setTotal(request.getTotal());
    }
    if (request.getFecha_cobro() != null) {
      costo.setFecha_cobro(request.getFecha_cobro());
    }

    
    return costoService.update(costo);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<DeleteResponse> delete(@PathVariable Long id) throws Exception {
    costoService.delete(id);
    return ResponseEntity.ok(new DeleteResponse("Costo eliminada correctamente"));
  }
}