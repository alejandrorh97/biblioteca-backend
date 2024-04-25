package com.ues.bibliotecabackend.seeders;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ues.bibliotecabackend.Rol.Rol;
import com.ues.bibliotecabackend.Rol.RolEnum;
import com.ues.bibliotecabackend.Rol.RolRepository;

@Component
public class RolSeeder {

  @Autowired
  private RolRepository rolRepository;

  public void run() throws Exception {
    List<Rol> roles = getRoles();
    for (Rol rol : roles) {
      if (!rolRepository.existsByNombre(rol.getNombre())) {
        rolRepository.save(rol);
      }
    }
  }

  private List<Rol> getRoles() {
    List<Rol> roles = new ArrayList<>();
    for (RolEnum rolEnum : RolEnum.values()) {
      Rol rol = new Rol();
      rol.setNombre(rolEnum.getValue());
      roles.add(rol);
    }
    return roles;
  }

}
