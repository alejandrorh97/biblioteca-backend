package com.ues.bibliotecabackend.Rol.requests;

import com.ues.bibliotecabackend.Rol.Rol;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolCreateRequest {
  @NotBlank(message = "El nombre es requerido")
  private String nombre;

  public Rol toEntity() {
    Rol rol = new Rol();
    rol.setNombre(this.nombre);
    return rol;
  }
}
