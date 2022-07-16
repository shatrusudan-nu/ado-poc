package com.nu.poc.ado.repo;

import com.nu.poc.ado.model.DisponibilidadAsiento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DisponibilidadAsientoRepo extends MongoRepository<DisponibilidadAsiento, Integer> {
    @Query("{ 'idCorrida' : ?0 }")
    public List<DisponibilidadAsiento> findByIdCorrida(String idCorrida);
}
