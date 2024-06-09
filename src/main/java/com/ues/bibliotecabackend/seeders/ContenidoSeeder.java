package com.ues.bibliotecabackend.seeders;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ues.bibliotecabackend.Categoria.Categoria;
import com.ues.bibliotecabackend.Categoria.CategoriaRepository;
import com.ues.bibliotecabackend.Contenido.Contenido;
import com.ues.bibliotecabackend.Contenido.ContenidoRepository;
import com.ues.bibliotecabackend.Inventario.Inventario;
import com.ues.bibliotecabackend.Inventario.InventarioRepository;

@Component
public class ContenidoSeeder {

  @Autowired
  private ContenidoRepository contenidoRepository;

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Autowired
  private InventarioRepository inventarioRepository;

  public void run() throws Exception {
    List<Contenido> contenidos = getContenidos();

    for (Contenido contenido : contenidos) {
      if (!contenidoRepository.existsByTitulo(contenido.getTitulo())) {
        Contenido newContenido = contenidoRepository.save(contenido);
        Inventario inventario = new Inventario();
        inventario.setUnidadesDisponibles(10);
        inventario.setUnidadesRegistradas(10);
        inventario.setContenido(newContenido);
        inventarioRepository.save(inventario);
      }
    }

  }

  private List<Contenido> getContenidos() {
    Categoria libros = categoriaRepository.findByNombre("Libros");

    Contenido contenido1 = new Contenido();
    contenido1.setTitulo("El principito");
    contenido1.setAutor("Antoine de Saint-Exupéry");
    contenido1.setGenero("Fábula");
    contenido1.setPublicador("Reynal & Hitchcock");
    contenido1.setIsbn("978-3-16-148410-0");
    contenido1.setIdioma("Español");
    contenido1.setRutaImagen("test");
    contenido1.setPrestable(true);
    contenido1.setCategoria(libros);

    Contenido contenido2 = new Contenido();
    contenido2.setTitulo("Cien años de soledad");
    contenido2.setAutor("Gabriel García Márquez");
    contenido2.setGenero("Realismo mágico");
    contenido2.setPublicador("Sudamericana");
    contenido2.setIsbn("978-3-16-148410-1");
    contenido2.setIdioma("Español");
    contenido2.setRutaImagen("test");
    contenido2.setPrestable(true);
    contenido2.setCategoria(libros);

    return List.of(contenido1, contenido2);
  }

}
