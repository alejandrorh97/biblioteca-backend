package com.ues.bibliotecabackend.Usuario.requests;

import com.ues.bibliotecabackend.Usuario.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreate {
  @NotBlank(message = "El nombre es requerido")
  private String nombre;

  @NotBlank(message = "El apellido es requerido")
  private String apellido;

  @NotBlank(message = "El correo es requerido")
  @Email(message = "El correo debe ser válido")
  private String correo;

  @NotBlank(message = "La contraseña es requerida")
  @Pattern(
    regexp = "^(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
    message = "La contraseña debe tener al menos 8 caracteres, letras y al menos un carácter especial"
  )
  private String contrasena;

  @NotBlank(message = "El teléfono es requerido")
  @Pattern(regexp = "^[627][0-9]{3}-[0-9]{4}$", message = "El teléfono no tiene el formato correcto")
  private String telefono;

  public Usuario toUsuario() {
    Usuario usuario = new Usuario();
    usuario.setNombre(this.nombre);
    usuario.setApellido(this.apellido);
    usuario.setCorreo(this.correo);
    usuario.setContrasena(this.contrasena);
    usuario.setTelefono(this.telefono);
    return usuario;
  }
}
