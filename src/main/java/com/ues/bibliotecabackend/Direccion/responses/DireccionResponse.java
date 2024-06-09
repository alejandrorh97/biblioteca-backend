package com.ues.bibliotecabackend.Direccion.responses;

import com.ues.bibliotecabackend.Direccion.Direccion;
import lombok.Data;

@Data
public class DireccionResponse {
  private Long id;
  private String linea1;
  private String linea2;
  private String casa;
  private String referencia;
  private String codigo_postal;


  public DireccionResponse(Direccion direccion) {
    this.id = direccion.getId();
    this.linea1 = direccion.getLinea1();
    this.linea2 = direccion.getLinea2();
    this.casa = direccion.getCasa();
    this.referencia = direccion.getReferencia();
    this.codigo_postal = direccion.getCodigo_postal();
  }
}