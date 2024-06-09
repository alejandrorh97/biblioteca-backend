package com.ues.bibliotecabackend.Contenido;

import com.ues.bibliotecabackend.Categoria.Categoria;
import com.ues.bibliotecabackend.Inventario.Inventario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contenidos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contenido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;
  private String titulo;
  private String autor;
  private String genero;
  private String publicador;
  private Date fechaPublicacion = new Date();
  private String isbn;
  private String idioma;
  private String rutaImagen;
  private Boolean prestable = false;

  @ManyToOne
  @JoinColumn(name = "id_categoria")
  private Categoria categoria;

  @OneToOne(mappedBy = "inventario")
  private Inventario inventario;
}
