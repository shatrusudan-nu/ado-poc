package com.nu.poc.ado.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nu.poc.ado.model.BookTicket;
import com.nu.poc.ado.model.Passenger;
import com.nu.poc.ado.model.TicketData;
import com.nu.poc.ado.repo.PassengerRepo;
import com.nu.poc.ado.service.BookTicketService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookTicketController {

	@Autowired
	private PassengerRepo passengerRepo;
	@Autowired
	private BookTicketService bookTicketService;
	private static final Logger LOG = LoggerFactory.getLogger(BookTicketController.class);
	
	
	@GetMapping(value = "/")
	public String getPage() {
		return "Welcome to ADO POC API";
	}
	
	@GetMapping(value = "/passengers")
	public List<Passenger> getPassenger() {
		Passenger p = passengerRepo.findByEmailId("sudan@gmail.com").get(0);
		LOG.info("Passenger First Name data:"+ p.getFirstName());
		return passengerRepo.findAll();
	}
	
	@PostMapping(value = "/savePassenger")
	public String savePassenger(@RequestBody Passenger passenger) {
		passengerRepo.save(passenger);
		return "Saved Successfully";
	}
	
	@GetMapping(value = "/ticket")
	public List<BookTicket> getTicket() {
		return bookTicketService.getTicket();
	}
	
	@PostMapping(value = "/bookTicket")
	public ResponseEntity<TicketData> saveBookTicket(@RequestBody BookTicket bookTicket) {
		LOG.info("BookTicket Controller called");
		TicketData ticketData = bookTicketService.getBookTicket(bookTicket);
		return new ResponseEntity<>(ticketData, HttpStatus.OK);
	}
	
	@GetMapping(value = "/deleteAllTicket")
	public String deleteTicket() {
		bookTicketService.deleteAllTicket();
		return "All ticket Deleted";
	}
	
}
