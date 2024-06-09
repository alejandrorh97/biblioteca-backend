package com.ues.bibliotecabackend.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ues.bibliotecabackend.Categoria.Categoria;
import com.ues.bibliotecabackend.Categoria.CategoriaRepository;

@Component
public class CategoriasSeeder {
  @Autowired
  private CategoriaRepository categoriaRepository;

  public void run() throws Exception {
    Categoria categoria1 = new Categoria();
    categoria1.setNombre("Libros");
    categoria1.setDescripcion("Categoria de libros");
    this.saveCategoria(categoria1);

    Categoria categoria2 = new Categoria();
    categoria2.setNombre("Revistas");
    categoria2.setDescripcion("Categoria de revistas");
    this.saveCategoria(categoria2);

    Categoria categoria3 = new Categoria();
    categoria3.setNombre("Tesis");
    categoria3.setDescripcion("Categoria de tesis");
    this.saveCategoria(categoria3);

    Categoria categoria4 = new Categoria();
    categoria4.setNombre("Proyectos");
    categoria4.setDescripcion("Categoria de proyectos");
    this.saveCategoria(categoria4);

    Categoria categoria5 = new Categoria();
    categoria5.setNombre("Videos");
    categoria5.setDescripcion("Categoria de videos");
    this.saveCategoria(categoria5);

    Categoria categoria6 = new Categoria();
    categoria6.setNombre("Audios");
    categoria6.setDescripcion("Categoria de audios");
    this.saveCategoria(categoria6);

    Categoria categoria7 = new Categoria();
    categoria7.setNombre("Fotografias");
    categoria7.setDescripcion("Categoria de fotografias");
    this.saveCategoria(categoria7);

    Categoria categoria8 = new Categoria();
    categoria8.setNombre("Mapas");
    categoria8.setDescripcion("Categoria de mapas");
    this.saveCategoria(categoria8);
  }

  private void saveCategoria(Categoria categoria) {
    if (!categoriaRepository.existsByNombre(categoria.getNombre())) {
      categoriaRepository.save(categoria);
    }
  }
}
