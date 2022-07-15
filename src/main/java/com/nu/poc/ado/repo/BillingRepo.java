package com.nu.poc.ado.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nu.poc.ado.model.Billing;

public interface BillingRepo extends JpaRepository<Billing, Long>{

}
