package com.ues.bibliotecabackend.Rol.responses;

import com.ues.bibliotecabackend.Permiso.responses.PermisoResponse;
import java.util.List;
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
  private List<PermisoResponse> permisos;
}
