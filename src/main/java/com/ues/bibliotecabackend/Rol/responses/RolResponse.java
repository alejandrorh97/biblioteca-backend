package com.ues.bibliotecabackend.Rol.responses;

import com.ues.bibliotecabackend.Rol.Rol;
import lombok.Data;

@Data
public class RolResponse {
  private Long id;
  private String nombre;

  public RolResponse(Rol rol) {
    this.id = rol.getId();
    this.nombre = rol.getNombre();
  }
}
