package com.ues.bibliotecabackend.Rol;

import com.ues.bibliotecabackend.Rol.requests.RolAttachPermissionsRequest;
import com.ues.bibliotecabackend.Rol.requests.RolCreateRequest;
import com.ues.bibliotecabackend.Rol.requests.RolIndexRequest;
import com.ues.bibliotecabackend.Rol.responses.RolResponse;
import com.ues.bibliotecabackend.global.responses.DeleteResponse;
import com.ues.bibliotecabackend.security.HasPermission;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/roles")
public class RolController {

  private final RolService rolService;

  @GetMapping("/all")
  @HasPermission("roles_all")
  public List<RolResponse> all() throws Exception {
    return rolService.findAll();
  }

  @GetMapping("/index")
  public Page<RolResponse> index(@Valid RolIndexRequest request) throws Exception {
    final Pageable paginacion = Pageable.ofSize(request.getSize()).withPage(request.getPage());
    return rolService.paginate(request.getBusqueda(), paginacion);
  }

  @GetMapping("/show/{id}")
  public RolResponse show(@PathVariable Long id) throws Exception {
    return rolService.findById(id);
  }

  @PostMapping("/create")
  public RolResponse create(@Valid @RequestBody RolCreateRequest request) throws Exception {
    return rolService.save(request.toEntity());
  }

  @PatchMapping("/update/{id}")
  public RolResponse update(@PathVariable Long id, @Valid @RequestBody RolCreateRequest request) throws Exception {
    Rol rol = rolService.findEntityById(id);
    rol.setNombre(request.getNombre());
    return rolService.update(rol);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<DeleteResponse> delete(@PathVariable Long id) throws Exception {
    rolService.delete(id);
    return ResponseEntity.ok(new DeleteResponse("Rol eliminado correctamente"));
  }

  @PostMapping("/attach-permission/{id}")
  public RolResponse attachPermission(@PathVariable Long id,
      @Valid @RequestBody RolAttachPermissionsRequest request) throws Exception {
    return null;
  }
}
