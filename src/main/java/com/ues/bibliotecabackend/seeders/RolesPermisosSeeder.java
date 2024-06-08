package com.ues.bibliotecabackend.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ues.bibliotecabackend.Permiso.PermisoRepository;
import com.ues.bibliotecabackend.Rol.RolEnum;
import com.ues.bibliotecabackend.Rol.RolRepository;

@Component
public class RolesPermisosSeeder {

  @Autowired
  private RolRepository rolRepository;

  @Autowired
  private PermisoRepository permisoRepository;


  public void run() throws Exception {
    var roles = rolRepository.findByNombre(RolEnum.ADMINISTRADOR.getValue());
    var permisos = permisoRepository.findAll();

    roles.setPermisos(permisos);
    rolRepository.save(roles);
  }
}
