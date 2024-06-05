package com.ues.bibliotecabackend.Rol.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolIndexRequest {
  @PositiveOrZero(message = "La página debe ser mayor o igual a 0")
  private int page = 0;
  @Min(value = 10, message = "El tamaño mínimo de la página es 5")
  @Max(value = 50, message = "El tamaño máximo de la página es 100")
  private int size = 10;

  private String busqueda;

}
