package com.nu.poc.ado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pasajero {
    public Integer id;
    public String nombre;
    public String descripcion;
    public String descripcionAlerta;
    public List<Precio> precios = null;
}
