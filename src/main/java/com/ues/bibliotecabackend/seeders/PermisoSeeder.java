package com.ues.bibliotecabackend.seeders;

import com.ues.bibliotecabackend.Permiso.Permiso;
import com.ues.bibliotecabackend.Permiso.PermisoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermisoSeeder {

  @Autowired
  private PermisoRepository permisoRepository;

  public void run() throws Exception {
    List<Permiso> permisos = getPermisos();
    for (Permiso permiso : permisos) {
      if (!permisoRepository.existsByNombre(permiso.getNombre())) {
        permisoRepository.save(permiso);
      }
    }
  }

  private List<Permiso> getPermisos() {
    List<Permiso> permisos = new ArrayList<>();
    permisos.add(new Permiso("usuarios_index"));
    permisos.add(new Permiso("usuarios_show"));
    permisos.add(new Permiso("usuarios_update"));
    permisos.add(new Permiso("usuarios_delete"));
    permisos.add(new Permiso("roles_all"));
    permisos.add(new Permiso("contenidos_index"));
    permisos.add(new Permiso("contenidos_show"));
    permisos.add(new Permiso("contenidos_update"));
    permisos.add(new Permiso("contenidos_delete"));
    return permisos;
  }

}
