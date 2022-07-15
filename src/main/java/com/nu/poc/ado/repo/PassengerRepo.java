package com.nu.poc.ado.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nu.poc.ado.model.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger, Long>{

	List<Passenger> findByEmailId(String emailId);
}
