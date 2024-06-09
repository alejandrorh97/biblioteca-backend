package com.ues.bibliotecabackend.Categoria;

import com.ues.bibliotecabackend.Categoria.responses.CategoriaIndex;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriasController {

  private final CategoriaRepository categoriaRepository;

  @GetMapping("/all")
  public List<CategoriaIndex> all() {
    ArrayList<CategoriaIndex> categorias = new ArrayList<>();
    categoriaRepository.findAll().forEach(categoria -> categorias.add(new CategoriaIndex(categoria)));
    return categorias;
  }

}
