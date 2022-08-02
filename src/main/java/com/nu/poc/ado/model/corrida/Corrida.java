package com.nu.poc.ado.model.corrida;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Corrida {

    public Integer asientosLibre;
    public String descDestinoTerminal;
    public String tipoServicio;
    public String fecHorSal;
    public Integer idOrigenTerminal;
    public String descOrigenTerminal;
    public Integer idDestinoTerminal;
    public String indExcepcionIVA;
    public String fecHorLlegada;
    public String idCorrida;
    public String fechaCorrida;
    public List<Precio> precio = null;
    public List<Disponibilidad> disponibilidad = null;
    public String horaCorrida;
    public Integer idClaseServicio;
    public String duracion;
    public Integer idMarca;
    public String nombrePromocion;
    public Integer idTipoServicio;

}