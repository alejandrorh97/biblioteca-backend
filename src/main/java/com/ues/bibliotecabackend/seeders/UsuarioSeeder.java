package com.ues.bibliotecabackend.seeders;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.ues.bibliotecabackend.Rol.Rol;
import com.ues.bibliotecabackend.Rol.RolEnum;
import com.ues.bibliotecabackend.Rol.RolRepository;
import com.ues.bibliotecabackend.Usuario.Usuario;
import com.ues.bibliotecabackend.Usuario.UsuarioRepository;

@Component
public class UsuarioSeeder {
  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private RolRepository rolRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void run() throws Exception {
    List<Usuario> usuarios = getUsuarios();

    for (Usuario usuario : usuarios) {
      if (!usuarioRepository.existsByCorreo(usuario.getCorreo())) {
        usuarioRepository.save(usuario);
      }
    }
  }

  private List<Usuario> getUsuarios() {
    Rol administrador = rolRepository.findByNombre(RolEnum.ADMINISTRADOR.getValue());
    String contrasena = passwordEncoder.encode("contrasena");
    Usuario usuario1 = new Usuario();
    usuario1.setNombre("Alejandro");
    usuario1.setApellido("Rivas");
    usuario1.setContrasena(contrasena);
    usuario1.setCorreo("AR_admin@mail.com");
    usuario1.setTelefono("7777-7777");
    usuario1.setEliminado(false);
    usuario1.setRol(administrador);

    Usuario usuario2 = new Usuario();
    usuario2.setNombre("Cristina");
    usuario2.setApellido("Moran");
    usuario2.setContrasena(contrasena);
    usuario2.setCorreo("CM_admin@mail.com");
    usuario2.setTelefono("7777-8888");
    usuario2.setEliminado(false);
    usuario2.setRol(administrador);

    Usuario usuario3 = new Usuario();
    usuario3.setNombre("Melissa");
    usuario3.setApellido("Pleitez");
    usuario3.setContrasena(contrasena);
    usuario3.setCorreo("MP_admin@mail.com");
    usuario3.setTelefono("7777-9999");
    usuario3.setEliminado(false);
    usuario3.setRol(administrador);

    return List.of(usuario1, usuario2, usuario3);
  }
}
