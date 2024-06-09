package com.ues.bibliotecabackend.Ciudad.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadUpdate {
  private String nombre;
  private String codigo_ciudad;
}