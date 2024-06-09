package com.ues.bibliotecabackend.Inventario.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InventarioUpdate {
    private String unidades_registradas;
    private String unidades_disponibles;
}
