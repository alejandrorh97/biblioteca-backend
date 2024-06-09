package com.ues.bibliotecabackend.Ciudad.responses;

import com.ues.bibliotecabackend.Ciudad.Ciudad;
import lombok.Data;

@Data
public class CiudadIndexResponse {
  private Long id;
  private String nombre;
  private String codigo_pais;

  public CiudadIndexResponse(Ciudad ciudad) {
    this.id = ciudad.getId();
    this.nombre = ciudad.getNombre();
    this.codigo_pais = ciudad.getCodigo_ciudad();

  }
}