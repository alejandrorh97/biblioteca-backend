package com.ues.bibliotecabackend.Direccion;

import com.ues.bibliotecabackend.Ciudad.Ciudad;
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
@Table(name = "direcciones")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Direccion{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String linea1;
  private String linea2;
  private String casa;
  private String referencia;
  private String codigo_postal;

  @ManyToOne
  @JoinColumn(name = "id_ciudad")
  private Ciudad ciudad;


}