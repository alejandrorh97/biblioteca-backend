package com.ues.bibliotecabackend.Usuario;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ues.bibliotecabackend.Usuario.responses.UsuarioResponse;
import com.ues.bibliotecabackend.global.BasicService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements BasicService<Usuario, UsuarioResponse> {
  private final UsuarioRepository usuarioRepository;

  @Override
  public List<UsuarioResponse> findAll(String busqueda) throws Exception {
    throw new UnsupportedOperationException("No se implementara por tamano de la tabla");
  }

  @Override
  public Page<UsuarioResponse> paginate(String busqueda, Pageable paginacion) throws Exception {
    try {
      Page<Usuario> usuarios = busqueda != null ? usuarioRepository.busqueda(busqueda, paginacion)
          : usuarioRepository.findAll(paginacion);
      return usuarios.map(usuario -> usuario.toResponse());
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public UsuarioResponse findById(Long id) throws EntityNotFoundException {
    return usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario con id " + id + " no encontrado"))
        .toResponse();
  }

  @Override
  public Usuario findEntityById(Long id) throws EntityNotFoundException {
    return usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario con id " + id + " no encontrado"));
  }

  @Override
  public UsuarioResponse save(Usuario entity) throws Exception {
    return usuarioRepository.save(entity).toResponse();
  }

  @Override
  public UsuarioResponse update(Usuario entity) throws EntityNotFoundException {
    return usuarioRepository.save(entity).toResponse();
  }

  @Override
  public boolean delete(Long id) throws EntityNotFoundException {
    usuarioRepository.deleteById(id);
    return true;
  }
}
