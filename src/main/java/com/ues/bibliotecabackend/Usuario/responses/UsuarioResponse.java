package com.ues.bibliotecabackend.Usuario.responses;

import java.util.Date;
import com.ues.bibliotecabackend.Rol.responses.RolResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioResponse {
  private Long id;
  private String nombre;
  private String apellido;
  private String correo;
  private String telefono;
  private Date fechaRegistro;
  private Boolean eliminado;
  private RolResponse rol;
}
