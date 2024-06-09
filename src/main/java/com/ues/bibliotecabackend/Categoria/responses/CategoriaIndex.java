package com.ues.bibliotecabackend.Categoria.responses;

import com.ues.bibliotecabackend.Categoria.Categoria;

import lombok.Data;

@Data
public class CategoriaIndex {
  private Long id;
  private String nombre;

  public CategoriaIndex(Categoria categoria) {
    this.id = categoria.getId();
    this.nombre = categoria.getNombre();
  }
}
