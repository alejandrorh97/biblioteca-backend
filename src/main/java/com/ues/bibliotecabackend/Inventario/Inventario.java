package com.ues.bibliotecabackend.Inventario;

import com.ues.bibliotecabackend.Contenido.Contenido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contenido;
    private int unidades_registradas;
    private int unidades_disponibles;

  @OneToOne
  @JoinColumn(name = "id_contenido")
  private Contenido contenido;
}

