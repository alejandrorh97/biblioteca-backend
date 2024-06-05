package com.ues.bibliotecabackend.Permiso;

import com.ues.bibliotecabackend.Permiso.responses.PermisoResponse;
import com.ues.bibliotecabackend.Rol.Rol;
import com.ues.bibliotecabackend.global.responses.BaseResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permisos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permiso implements BaseResponse<PermisoResponse> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String categoria;

  @ManyToMany
  @JoinTable(
    name = "roles_permisos", joinColumns = @JoinColumn(name = "id_permiso", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id")
  )
  private List<Rol> roles;

  @Override
  public PermisoResponse toResponse() {
    return PermisoResponse.builder()
        .id(this.id)
        .nombre(this.nombre)
        .categoria(this.categoria)
        .build();
  }
}
