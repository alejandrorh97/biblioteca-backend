package com.ues.bibliotecabackend.Departamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "departamentos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Departamento{
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String pais;
  
  //@ManyToMany
  //@JoinColumn(name = "id_rol")
  //private Rol rol;
  
}
