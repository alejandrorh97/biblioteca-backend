package com.ues.bibliotecabackend.Ciudad.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadIndexRequest {
  @PositiveOrZero(message = "Page debe ser mayor o igual a 0")
  private int page = 0;

  @Min(message = "Size debe ser mayor o igual a 10", value = 10)
  @Max(message = "Size debe ser menor o igual a 100", value = 100)
  private int size = 10;

  private String busqueda;
}