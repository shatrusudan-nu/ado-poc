package com.nu.poc.ado.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nu.poc.ado.model.Travel;

public interface TravelRepo extends JpaRepository<Travel, Long>{

}
