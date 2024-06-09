package com.ues.bibliotecabackend.Direccion.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionUpdate {
  private String linea1;
  private String linea2;
  private String casa;
  private String referencia;
  private String codigo_postal;
}