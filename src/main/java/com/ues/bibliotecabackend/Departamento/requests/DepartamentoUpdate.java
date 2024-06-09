package com.ues.bibliotecabackend.Departamento.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoUpdate {
  private String nombre;
  private String pais;
}