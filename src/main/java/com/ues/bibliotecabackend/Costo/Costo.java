package com.ues.bibliotecabackend.Costo;

import java.sql.Date;

import com.ues.bibliotecabackend.Servicio.Servicio;
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
@Table(name = "costos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Costo{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer cantidad;
  private Double total;
  private Date fecha_cobro;

  @ManyToOne
  @JoinColumn(name = "id_servicio")
  private Servicio Servicio;


}