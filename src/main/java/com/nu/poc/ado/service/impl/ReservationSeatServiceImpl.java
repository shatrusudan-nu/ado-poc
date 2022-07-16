package com.nu.poc.ado.service.impl;

import com.nu.poc.ado.model.DisponibilidadAsiento;
import com.nu.poc.ado.model.Estructura;
import com.nu.poc.ado.repo.DisponibilidadAsientoRepo;
import com.nu.poc.ado.service.ReservationSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationSeatServiceImpl implements ReservationSeatService {

    @Autowired
    private DisponibilidadAsientoRepo repo;

    public Optional<DisponibilidadAsiento> reserveSeatById(String id , Integer asiento) {
        Optional<DisponibilidadAsiento> seat=repo.findAll().stream()
                .filter(disponibilidadAsiento -> disponibilidadAsiento.getId().equals(id)).findAny();

        seat.get().getContenido().setAsientosLibre(seat.get().getContenido().getAsientosLibre()-1);
        return this.setFlagToSeat(seat,"OC",asiento);
    }
    public Optional<DisponibilidadAsiento> releaseSeatById(String id ,Integer asiento) {
        Optional<DisponibilidadAsiento> seat=repo.findAll().stream()
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
        repo.save(disponibilidadAsientoResult.get());

        return disponibilidadAsientoResult;
    }

}
