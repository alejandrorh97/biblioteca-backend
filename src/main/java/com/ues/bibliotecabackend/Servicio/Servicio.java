package com.ues.bibliotecabackend.Servicio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "servicios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Servicio{
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private Double precio_unitario;
  
  //@ManyToMany
  //@JoinColumn(name = "id_rol")
  //private Rol rol;
  
}
