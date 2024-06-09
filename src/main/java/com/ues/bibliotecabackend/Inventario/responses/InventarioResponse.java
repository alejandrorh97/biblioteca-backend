package com.ues.bibliotecabackend.Inventario.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InventarioResponse {
    private Long id_contenido;
    private int unidades_registradas;
    private int unidades_disponibles;
}
