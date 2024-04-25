package com.ues.bibliotecabackend.Usuario;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.ues.bibliotecabackend.Rol.Rol;
import com.ues.bibliotecabackend.Usuario.responses.UsuarioResponse;
import com.ues.bibliotecabackend.global.responses.BaseResponse;
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
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario implements UserDetails, BaseResponse<UsuarioResponse> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String apellido;
  private String correo;
  private String contrasena;
  private String telefono;
  private Date fechaRegistro = new Date();
  private Boolean eliminado = false;

  @ManyToOne
  @JoinColumn(name = "id_rol")
  private Rol rol;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO aqui va el rol y permisos
    return List.of(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public String getPassword() {
    return contrasena;
  }

  @Override
  public String getUsername() {
    return correo;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return !eliminado;
  }

  @Override
  public UsuarioResponse toResponse() {
    return UsuarioResponse.builder()
        .id(id)
        .nombre(nombre)
        .apellido(apellido)
        .correo(correo)
        .telefono(telefono)
        .fechaRegistro(fechaRegistro)
        .eliminado(eliminado)
        .rol(rol.toResponse())
        .build();
  }
}
