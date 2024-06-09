package com.ues.bibliotecabackend.Costo.responses;

import java.sql.Date;

import com.ues.bibliotecabackend.Costo.Costo;
import lombok.Data;

@Data
public class CostoIndexResponse {
  private Long id;
  private Integer cantidad;
  private Double total;
  private Date fecha_cobro;

  public CostoIndexResponse(Costo costo) {
    this.id = costo.getId();
    this.cantidad = costo.getCantidad();
    this.total = costo.getTotal();

  }
}