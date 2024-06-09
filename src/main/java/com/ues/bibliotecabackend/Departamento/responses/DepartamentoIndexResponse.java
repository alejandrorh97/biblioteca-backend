package com.ues.bibliotecabackend.Departamento.responses;

import com.ues.bibliotecabackend.Departamento.Departamento;
import lombok.Data;

@Data
public class DepartamentoIndexResponse {
  private Long id;
  private String nombre;
  private String pais;

  public DepartamentoIndexResponse(Departamento departamento) {
    this.id = departamento.getId();
    this.nombre = departamento.getNombre();
    this.pais = departamento.getPais();

  }
}