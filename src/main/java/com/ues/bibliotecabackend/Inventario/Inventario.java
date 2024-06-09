package com.ues.bibliotecabackend.Inventario;

import com.ues.bibliotecabackend.Contenido.Contenido;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
  int unidadesRegistradas;
  int unidadesDisponibles;

  @OneToOne
  @JoinColumn(name = "id_contenido")
  private Contenido contenido;
}
