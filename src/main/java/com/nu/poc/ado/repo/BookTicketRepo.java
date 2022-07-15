package com.nu.poc.ado.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nu.poc.ado.model.BookTicket;

public interface BookTicketRepo extends JpaRepository<BookTicket, Long>{

	List<BookTicket> findByBookingId(String bookingId);
}
