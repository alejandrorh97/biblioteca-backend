package com.ues.bibliotecabackend.Servicio.requests;

import com.ues.bibliotecabackend.Departamento.Departamento;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoCreate {
  @NotBlank(message = "El nombre es requerido")
  private String nombre;

  @NotBlank(message = "El pais es requerido")
  private String pais;

 

  public Departamento toDepartamento() {
    Departamento departamento = new Departamento();
    departamento.setNombre(this.nombre);
    departamento.setPais(this.pais);
    
    return departamento;
  }
}