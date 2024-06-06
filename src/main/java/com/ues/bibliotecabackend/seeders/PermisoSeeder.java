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
    permisos.add(new Permiso("INDEX"));
    permisos.add(new Permiso("CREATE"));
    permisos.add(new Permiso("SHOW"));
    permisos.add(new Permiso("UPDATE"));
    permisos.add(new Permiso("DELETE"));
    permisos.add(new Permiso("SELF"));
    permisos.add(new Permiso("ALL"));
    return permisos;
  }

}
