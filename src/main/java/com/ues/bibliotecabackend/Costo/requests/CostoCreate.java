package com.ues.bibliotecabackend.Costo.requests;

import java.sql.Date;

import com.ues.bibliotecabackend.Costo.Costo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostoCreate {
  @NotBlank(message = "Es requerida la cantidad")
  private Integer cantidad;

  @NotBlank(message = "Es requerido el total")
  private Double total;

  @NotBlank(message = "La fecha de cobro es requerida")
  private Date fecha_cobro;



  public Costo toCosto() {
    Costo costo = new Costo();
    costo.setCantidad(this.cantidad);
    costo.setTotal(this.total);
    costo.setFecha_cobro(this.fecha_cobro);

    
    return costo;
  }
}