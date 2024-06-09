package com.ues.bibliotecabackend.Inventario.requests;

import com.ues.bibliotecabackend.Inventario.Inventario;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InventarioCreate {
    
  @NotBlank(message = "Unidades Registradas Requeridas")
  private int unidades_registradas;

  @NotBlank(message = "Unidades Disponibles Requeridas")
  private int unidades_disponibles;

  public Inventario toInventario() {
    Inventario inventario = new Inventario();
    inventario.setUnidades_registradas(this.unidades_registradas);
    inventario.setUnidades_disponibles(this.unidades_disponibles);
    return inventario;
  }

}
