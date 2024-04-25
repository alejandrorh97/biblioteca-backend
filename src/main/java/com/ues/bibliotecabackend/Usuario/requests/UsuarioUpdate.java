package com.ues.bibliotecabackend.Usuario.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioUpdate {
  private String nombre;
  private String apellido;
  @Email(message = "El correo debe ser válido")
  private String correo;
  @Pattern(regexp = "^[627][0-9]{3}-[0-9]{4}$", message = "El teléfono no tiene el formato correcto")
  private String telefono;
}
