package com.ues.bibliotecabackend.Auth.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
  @NotBlank(message = "El correo es requerido")
  @Email(message = "El correo debe ser válido")
  private String correo;
  @NotBlank(message = "La contraseña es requerida")
  private String contrasena;
}
