package com.ues.bibliotecabackend.Contenido.responses;

import com.ues.bibliotecabackend.Contenido.Contenido;
import lombok.Data;

@Data
public class ContenidoIndexResponse {
  private long Id;
  private String imagen;
  private String titulo;
  private String autor;
  private String genero;
  private String categoria;
  private int unidadesDisponibles;
  private boolean prestable;

  public ContenidoIndexResponse(Contenido contenido) {
    this.Id = contenido.getId();
    this.imagen = contenido.getRutaImagen();
    this.titulo = contenido.getTitulo();
    this.autor = contenido.getAutor();
    this.genero = contenido.getGenero();
    this.categoria = contenido.getCategoria().getNombre();
    this.unidadesDisponibles = contenido.getInventario().getUnidadesDisponibles();
    this.prestable = contenido.getPrestable();
  }
}
