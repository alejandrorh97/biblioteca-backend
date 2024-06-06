package com.ues.bibliotecabackend.Usuario;

import com.ues.bibliotecabackend.Usuario.responses.UsuarioIndexResponse;
import com.ues.bibliotecabackend.Usuario.responses.UsuarioResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;

  public List<UsuarioResponse> findAll(String busqueda) throws Exception {
    throw new UnsupportedOperationException("No se implementara por tamano de la tabla");
  }

  public Page<UsuarioIndexResponse> paginate(String busqueda, Pageable paginacion) throws Exception {
    try {
      Page<Usuario> usuarios = busqueda != null ? usuarioRepository.busqueda(busqueda, paginacion)
          : usuarioRepository.findAll(paginacion);
      return usuarios.map(UsuarioIndexResponse::new);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public UsuarioResponse findById(Long id) throws EntityNotFoundException {
    var usuario = usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario con id " + id + " no encontrado"));
    return new UsuarioResponse(usuario);
  }

  public Usuario findEntityById(Long id) throws EntityNotFoundException {
   return usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario con id " + id + " no encontrado"));
  }

  public UsuarioResponse save(Usuario entity) throws Exception {
    return new UsuarioResponse(usuarioRepository.save(entity));
  }

  public UsuarioResponse update(Usuario entity) throws EntityNotFoundException {
    return new UsuarioResponse(usuarioRepository.save(entity));
  }

  public boolean delete(Long id) throws EntityNotFoundException {
    usuarioRepository.deleteById(id);
    return true;
  }
}
