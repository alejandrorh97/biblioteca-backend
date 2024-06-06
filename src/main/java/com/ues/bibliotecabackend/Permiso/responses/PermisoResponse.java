package com.ues.bibliotecabackend.Permiso.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PermisoResponse {
  private Long id;
  private String nombre;
}
