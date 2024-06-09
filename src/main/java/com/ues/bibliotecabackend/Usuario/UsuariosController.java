package com.ues.bibliotecabackend.Usuario;

import com.ues.bibliotecabackend.Usuario.requests.UsuarioUpdate;
import com.ues.bibliotecabackend.Usuario.responses.UsuarioIndexResponse;
import com.ues.bibliotecabackend.Usuario.responses.UsuarioResponse;
import com.ues.bibliotecabackend.global.responses.DeleteResponse;
import com.ues.bibliotecabackend.security.HasPermission;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.Map;
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
@RequestMapping("/usuarios")
public class UsuariosController {
  private final UsuarioService usuarioService;

  @GetMapping("/index")
  @HasPermission("usuarios_index")
  public Page<UsuarioIndexResponse> index(@RequestParam Map<String, String> request) throws Exception {
    int page = request.get("page") != null ? Integer.parseInt(request.get("page")) : 0;
    int size = request.get("size") != null ? Integer.parseInt(request.get("size")) : 10;
    int rol = request.get("rol") != null ? Integer.parseInt(request.get("rol")) : 0;
    String busqueda = request.get("busqueda") != null ? request.get("busqueda") : "";
    
    Pageable paginacion = PageRequest.of(page, size);
    return usuarioService.paginate(busqueda, rol, paginacion);
  }

  @GetMapping("/show/{id}")
  @HasPermission("usuarios_show")
  public UsuarioResponse show(@PathVariable Long id) throws Exception {
    return usuarioService.findById(id);
  }

  @PatchMapping("/update/{id}")
  @HasPermission("usuarios_update")
  public UsuarioResponse update(@PathVariable Long id, @Valid @RequestBody UsuarioUpdate request) throws Exception {
    Usuario usuario = usuarioService.findEntityById(id);
    if (request.getNombre() != null) {
      usuario.setNombre(request.getNombre());
    }
    if (request.getApellido() != null) {
      usuario.setApellido(request.getApellido());
    }
    if (request.getCorreo() != null) {
      usuario.setCorreo(request.getCorreo());
    }
    if (request.getTelefono() != null) {
      usuario.setTelefono(request.getTelefono());
    }
    return usuarioService.update(usuario);
  }

  @DeleteMapping("/delete/{id}")
  @HasPermission("usuarios_delete")
  public ResponseEntity<DeleteResponse> delete(@PathVariable Long id) throws Exception {
    usuarioService.delete(id);
    return ResponseEntity.ok(new DeleteResponse("Usuario eliminado correctamente"));
  }
}
