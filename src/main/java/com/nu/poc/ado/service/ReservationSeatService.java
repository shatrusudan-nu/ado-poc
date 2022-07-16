package com.nu.poc.ado.service;

import com.nu.poc.ado.model.DisponibilidadAsiento;
import java.util.Optional;

public interface ReservationSeatService {
    public Optional<DisponibilidadAsiento> reserveSeatById(String id , Integer asiento);
    public  Optional<DisponibilidadAsiento> releaseSeatById(String id ,Integer asiento);
}
