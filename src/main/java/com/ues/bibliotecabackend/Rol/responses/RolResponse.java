package com.ues.bibliotecabackend.Rol.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RolResponse {
  private Long id;
  private String nombre;
  //TODO add lista de permisos
}
