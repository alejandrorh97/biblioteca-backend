package com.ues.bibliotecabackend.Ciudad.requests;

import com.ues.bibliotecabackend.Ciudad.Ciudad;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadCreate {
  @NotBlank(message = "El nombre es requerido")
  private String nombre;

  @NotBlank(message = "El codigo de ciudad es requerido")
  private String codigo_ciudad;

 

  public Ciudad toDepartamento() {
    Ciudad ciudad = new Ciudad();
    ciudad.setNombre(this.nombre);
    ciudad.setCodigo_ciudad(this.codigo_ciudad);
    
    return ciudad;
  }
}