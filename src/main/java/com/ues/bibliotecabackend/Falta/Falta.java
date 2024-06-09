package com.ues.bibliotecabackend.Falta;


import com.ues.bibliotecabackend.Usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "faltas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Falta {
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // @ManyToOne tipo_falta
}
