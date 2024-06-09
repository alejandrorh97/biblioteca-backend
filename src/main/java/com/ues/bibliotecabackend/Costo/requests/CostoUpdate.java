package com.ues.bibliotecabackend.Costo.requests;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostoUpdate {
  private Integer cantidad;
  private Double total;
  private Date fecha_cobro;
  
}