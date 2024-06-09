package com.ues.bibliotecabackend.Costo.responses;

import java.sql.Date;

import com.ues.bibliotecabackend.Costo.Costo;
import lombok.Data;

@Data
public class CostoResponse {
  private Long id;
  private Integer cantidad;
  private Double total;
  private Date fecha_cobro;



  public CostoResponse(Costo costo) {
    this.id = costo.getId();
    this.cantidad = costo.getCantidad();
    this.total = costo.getTotal();
    this.fecha_cobro = costo.getFecha_cobro();
   
  }
}