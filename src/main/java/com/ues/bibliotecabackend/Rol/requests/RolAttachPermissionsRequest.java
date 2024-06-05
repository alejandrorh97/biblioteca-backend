package com.ues.bibliotecabackend.Rol.requests;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolAttachPermissionsRequest {
  @NotEmpty(message = "La lista de permisos no puede estar vacía")
  private List<Long> permisos;
}
