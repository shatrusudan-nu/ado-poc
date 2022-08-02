package com.nu.poc.ado.service.impl;

import com.nu.poc.ado.model.DisponibilidadAsiento;
import com.nu.poc.ado.model.Estructura;
import com.nu.poc.ado.model.corrida.Contenido;
import com.nu.poc.ado.model.corrida.Corrida;
import com.nu.poc.ado.model.corrida.CorridasItems;
import com.nu.poc.ado.repo.CorridasItemsRepo;
import com.nu.poc.ado.repo.DisponibilidadAsientoRepo;
import com.nu.poc.ado.service.ReservationSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationSeatServiceImpl implements ReservationSeatService {

    @Autowired
    private DisponibilidadAsientoRepo disponibilidadAsientoRepo;

    @Autowired
    private CorridasItemsRepo CorridasRepo;

    public Optional<DisponibilidadAsiento> reserveSeatById(String id , Integer asiento) {
        Optional<DisponibilidadAsiento> seat= disponibilidadAsientoRepo.findAll().stream()
                .filter(disponibilidadAsiento -> disponibilidadAsiento.getId().equals(id)).findAny();

        seat.get().getContenido().setAsientosLibre(seat.get().getContenido().getAsientosLibre()-1);
        return this.setFlagToSeat(seat,"OC",asiento);
    }
    public Optional<DisponibilidadAsiento> releaseSeatById(String id ,Integer asiento) {
        Optional<DisponibilidadAsiento> seat= disponibilidadAsientoRepo.findAll().stream()
                .filter(disponibilidadAsiento -> disponibilidadAsiento.getId().equals(id)).findAny();

        seat.get().getContenido().setAsientosLibre(seat.get().getContenido().getAsientosLibre()+1);
        return this.setFlagToSeat(seat,"DP",asiento);
    }

    private Optional<DisponibilidadAsiento> setFlagToSeat(Optional<DisponibilidadAsiento> disponibilidadAsientoResult,
                                                          String flag,Integer asiento){
        List<Estructura> estructuraResult = disponibilidadAsientoResult.orElse(null)
                .getContenido().getAutobus()
                .getEstructura().stream()
                .filter(estructura -> Objects.nonNull(estructura.asiento))
                .collect(Collectors.toList()).stream()
                .map(estructura -> {
                    if(estructura.getAsiento().equals(asiento)){
                        estructura.setEstatus(flag);
                    }
                    return estructura;
                })
                .collect(Collectors.toList());
        disponibilidadAsientoResult.get().getContenido().getAutobus().setEstructura(estructuraResult);

        Integer asientosLibre= disponibilidadAsientoResult.get()
                .getContenido()
                .getAutobus()
                .getEstructura()
                .stream()
                .filter(estructura -> estructura.getEstatus().equals("DP"))
                .collect(Collectors.toList()).size();

        disponibilidadAsientoResult.get().getContenido().setAsientosLibre(asientosLibre);
        disponibilidadAsientoRepo.save(disponibilidadAsientoResult.get());

        saveCorridasSeatdisponibility(disponibilidadAsientoResult.get().getIdCorrida(),asientosLibre);

        return disponibilidadAsientoResult;
    }

    private void saveCorridasSeatdisponibility(String idCorrida,Integer asientosLibre){

        CorridasItems corridasItems=CorridasRepo.findAll().get(0);

        corridasItems.getContenido().getSalida().getCorridas().stream().filter(corrida -> corrida.idCorrida.equals(idCorrida))
                .findAny().get().setAsientosLibre(asientosLibre);

        List<Corrida> CorridasRegreso= new ArrayList<>();
        corridasItems.getContenido().setRegreso(CorridasRegreso);

        CorridasRepo.save(corridasItems);
    }
}
