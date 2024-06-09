package com.ues.bibliotecabackend.Categoria;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ues.bibliotecabackend.Contenido.Contenido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "categorias_contenido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private String descripcion;

  @JsonManagedReference
  @OneToMany(mappedBy = "contenido")
  private List<Contenido> contenidos;
}
