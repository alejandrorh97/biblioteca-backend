package com.ues.bibliotecabackend.Rol;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ues.bibliotecabackend.Rol.responses.RolResponse;
import com.ues.bibliotecabackend.Usuario.Usuario;
import com.ues.bibliotecabackend.global.responses.BaseResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol implements BaseResponse<RolResponse> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;

  @JsonManagedReference
  @OneToMany(mappedBy = "rol")
  private List<Usuario> usuarios;

  @Override
  public RolResponse toResponse() {
    return RolResponse.builder()
        .id(this.id)
        .nombre(this.nombre)
        .build();
  }
}
