package com.ues.bibliotecabackend.Usuario.responses;

import com.ues.bibliotecabackend.Usuario.Usuario;
import lombok.Data;

@Data
public class UsuarioIndexResponse {
  private Long id;
  private String nombre;
  private String apellido;
  private String correo;
  private String telefono;
  private String rol;
  private Boolean eliminado;

  public UsuarioIndexResponse(Usuario usuario) {
    this.id = usuario.getId();
    this.nombre = usuario.getNombre();
    this.apellido = usuario.getApellido();
    this.correo = usuario.getCorreo();
    this.telefono = usuario.getTelefono();
    this.rol = usuario.getRol().getNombre();
    this.eliminado = usuario.getEliminado();
  }
}
