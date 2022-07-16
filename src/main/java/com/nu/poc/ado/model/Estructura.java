package com.nu.poc.ado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estructura {
    public String tipo;
    public String estatus;
    public Integer asiento;
    public Integer columna;
    public Integer fila;
}
