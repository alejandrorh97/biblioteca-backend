package com.ues.bibliotecabackend.global.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaginationRequest {
  @PositiveOrZero(message = "page debe ser mayor o igual a 0")
  private final int page;

  @Min(message = "size debe ser mayor o igual a 5", value = 5)
  @Max(message = "size debe ser menor o igual a 100", value = 100)
  private final int size;
}
