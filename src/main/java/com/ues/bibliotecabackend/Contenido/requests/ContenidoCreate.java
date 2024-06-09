package com.ues.bibliotecabackend.Contenido.requests;

//import java.util.Date;

import com.ues.bibliotecabackend.Contenido.Contenido;

import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContenidoCreate {
    @NotBlank(message = "El titulo es requerido")
    private String titulo;
  
    @NotBlank(message = "El autor es requerido")
    private String autor;
  
    @NotBlank(message = "El genero es requerido")
    private String genero;
    
    @NotBlank(message = "El publicador es requerido")
    private String publicador;

    //@NotBlank(message = "La fecha de publicacion es requerida")
    //private Date fechaPublicacion = new Date();

    @NotBlank(message = "El ISBN es requerido")
    private String isbn;

    @NotBlank(message = "El idioma es requerido")
    private String idioma;
  
    public Contenido toContenido() {
        Contenido contenido = new Contenido();
        contenido.setTitulo(this.titulo);
        contenido.setAutor(this.autor);
        contenido.setGenero(this.genero);
        contenido.setPublicador(this.publicador);
        //contenido.setfechaPublicacion(this.fechaPublicacion);
        contenido.setIsbn(this.isbn);
        contenido.setIdioma(this.idioma);
        return contenido;
    }
}
