package com.ues.bibliotecabackend.Contenido.responses;

import java.util.Date;

import com.ues.bibliotecabackend.Contenido.Contenido;

import lombok.Data;

@Data
public class ContenidoIndexResponse {
  private long Id;
  private String titulo;
  private String autor;
  private String genero;
  private String publicador;
  private Date fechaPublicacion = new Date();
  private String isbn;
  private String idioma;
  private String rutaImagen;
  private boolean prestable = false;
  private String categoria;

  public ContenidoIndexResponse(Contenido contenido) {
    this.Id = contenido.getId();
    this.titulo = contenido.getTitulo();
    this.autor = contenido.getAutor();
    this.genero = contenido.getGenero();
    this.publicador = contenido.getPublicador();
    this.fechaPublicacion = contenido.getFechaPublicacion();
    this.isbn = contenido.getIsbn();
    this.idioma = contenido.getIdioma();
    this.rutaImagen = contenido.getRutaImagen();
    this.prestable = contenido.getPrestable();
    this.categoria = contenido.getCategoria().getNombre();
  }
}
