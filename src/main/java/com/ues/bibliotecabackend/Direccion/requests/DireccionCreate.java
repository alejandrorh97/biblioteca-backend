package com.ues.bibliotecabackend.Direccion.requests;

import com.ues.bibliotecabackend.Direccion.Direccion;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionCreate {
  @NotBlank(message = "Es requerida la primera linea de direccion")
  private String linea1;

  @NotBlank(message = "Es requerida la segunda linea de direccion")
  private String linea2;

  @NotBlank(message = "El numero de casa es requerido")
  private String casa;

  @NotBlank(message = "La referencia es requerida")
  private String referencia;

  @NotBlank(message = "El codigo postal es requerido")
  private String codigo_postal;

 

  public Direccion toCiudad() {
    Direccion direccion = new Direccion();
    direccion.setLinea1(this.linea1);
    direccion.setLinea2(this.linea2);
    direccion.setCasa(this.casa);
    direccion.setReferencia(this.referencia);
    direccion.setCodigo_postal(this.codigo_postal);
    
    return direccion;
  }
}