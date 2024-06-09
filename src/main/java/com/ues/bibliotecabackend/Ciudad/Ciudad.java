package com.ues.bibliotecabackend.Ciudad;

import com.ues.bibliotecabackend.Departamento.Departamento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ciudades")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ciudad{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String codigo_ciudad;

  @ManyToOne
  @JoinColumn(name = "id_departamento")
  private Departamento departamento;


}