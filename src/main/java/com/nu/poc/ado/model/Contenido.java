package com.nu.poc.ado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contenido {
    public Integer tipoVenta;
    public Integer cantAsientos;
    public Integer asientosLibre;
    public String indExcepcionIVA;
    public Autobus autobus;
    public Boletos boletos;

}
