package com.ues.bibliotecabackend.Ciudad.responses;

import com.ues.bibliotecabackend.Ciudad.Ciudad;
import lombok.Data;

@Data
public class CiudadResponse {
  private Long id;
  private String nombre;
  private String codigo_ciudad;


  public CiudadResponse(Ciudad ciudad) {
    this.id = ciudad.getId();
    this.nombre = ciudad.getNombre();
    this.codigo_ciudad = ciudad.getCodigo_ciudad();
  }
}