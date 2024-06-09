package com.ues.bibliotecabackend.Servicio.responses;

import com.ues.bibliotecabackend.Servicio.Servicio;
import lombok.Data;

@Data
public class ServicioIndexResponse {
  private Long id;
  private String nombre;
  private Double precio_unitario;

  public ServicioIndexResponse(Servicio servicio) {
    this.id = servicio.getId();
    this.nombre = servicio.getNombre();
    this.precio_unitario = servicio.getPrecio_unitario();

  }
}