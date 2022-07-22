package com.nu.poc.ado.controller;

import com.nu.poc.ado.model.DisponibilidadAsiento;
import com.nu.poc.ado.service.ReservationSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DisponibilidadAsientoController {

    @Autowired
    private ReservationSeatService reservationSeatService;

    @PutMapping("/disponibilidad-asiento/reservar")
    public ResponseEntity<Optional<DisponibilidadAsiento>> reserveDisponibleAsientoBySeat(@RequestParam String id , @RequestParam Integer asiento) {

        return new ResponseEntity<>(reservationSeatService.reserveSeatById(id,asiento),HttpStatus.OK);
    }


    @PutMapping("/disponibilidad-asiento/liberar")
    public ResponseEntity<Optional<DisponibilidadAsiento>> freeDisponibleAsientoBySeat(@RequestParam String id , @RequestParam Integer asiento) {
        return new ResponseEntity<>(reservationSeatService.releaseSeatById(id,asiento), HttpStatus.OK);
    }


}
