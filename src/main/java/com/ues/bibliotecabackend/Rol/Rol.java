package com.ues.bibliotecabackend.Rol;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ues.bibliotecabackend.Permiso.Permiso;
import com.ues.bibliotecabackend.Rol.responses.RolResponse;
import com.ues.bibliotecabackend.Usuario.Usuario;
import com.ues.bibliotecabackend.global.responses.BaseResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
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

  @ManyToMany
  @JoinTable(
    name = "roles_permisos", joinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "id_permiso", referencedColumnName = "id")
  )
  private List<Permiso> permisos;

  @Override
  public RolResponse toResponse() {
    return RolResponse.builder()
        .id(this.id)
        .nombre(this.nombre)
        .permisos(
          this.permisos != null
            ? permisos.stream().map(Permiso::toResponse).toList()
            : null
        )
        .build();
  }

  public List<String> getPermisosAsList() {
    return this.permisos != null
      ? permisos.stream().map(Permiso::getNombre).toList()
      : new ArrayList<>();
  }
}
