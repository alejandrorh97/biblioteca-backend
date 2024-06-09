package com.ues.bibliotecabackend.Contenido;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ues.bibliotecabackend.Categoria.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "contenidos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private int id_categoria;
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

  @JsonManagedReference
  @OneToOne(mappedBy = "id_contenido")
  private List<Contenido> contenidos;
}
