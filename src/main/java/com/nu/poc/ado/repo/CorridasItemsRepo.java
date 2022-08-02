package com.nu.poc.ado.repo;


import com.nu.poc.ado.model.corrida.CorridasItems;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CorridasItemsRepo extends MongoRepository<CorridasItems, Integer> {
}
