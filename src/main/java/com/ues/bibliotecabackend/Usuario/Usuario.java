package com.ues.bibliotecabackend.Usuario;

import com.ues.bibliotecabackend.Rol.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String apellido;
  @Column(unique = true)
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
    var permisos = rol.getPermisos();

    if (permisos == null) {
      return List.of();
    }

    return permisos.stream()
        .map(permiso -> new SimpleGrantedAuthority(permiso.getNombre()))
        .toList();
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
}
