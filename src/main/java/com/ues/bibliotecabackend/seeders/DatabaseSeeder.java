package com.ues.bibliotecabackend.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  @Autowired
  private RolSeeder rolSeeder;
  @Autowired
  private UsuarioSeeder usuarioSeeder;
  @Autowired
  private PermisoSeeder permisoSeeder;
  @Autowired
  private RolesPermisosSeeder rolesPermisosSeeder;
  @Autowired
  private CategoriasSeeder categoriasSeeder;
  @Autowired
  private ContenidoSeeder contenidoSeeder;

  @Override
  public void run(String... args) throws Exception {
    rolSeeder.run();
    usuarioSeeder.run();
    permisoSeeder.run();
    rolesPermisosSeeder.run();
    categoriasSeeder.run();
    contenidoSeeder.run();
  }

}
