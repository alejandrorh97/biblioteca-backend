package com.ues.bibliotecabackend.Usuario.responses;

import com.ues.bibliotecabackend.Usuario.Usuario;
import java.util.Date;
import lombok.Data;

@Data
public class UsuarioResponse {
  private Long id;
  private String nombre;
  private String apellido;
  private String correo;
  private String telefono;
  private Date fechaRegistro;
  private Boolean eliminado;

  public UsuarioResponse(Usuario usuario) {
    this.id = usuario.getId();
    this.nombre = usuario.getNombre();
    this.apellido = usuario.getApellido();
    this.correo = usuario.getCorreo();
    this.telefono = usuario.getTelefono();
    this.fechaRegistro = usuario.getFechaRegistro();
    this.eliminado = usuario.getEliminado();
  }
}
