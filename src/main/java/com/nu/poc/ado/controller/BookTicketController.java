package com.nu.poc.ado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nu.poc.ado.model.BookTicket;
import com.nu.poc.ado.model.Passenger;
import com.nu.poc.ado.model.TicketData;
import com.nu.poc.ado.repo.BookTicketRepo;
import com.nu.poc.ado.repo.PassengerRepo;
import com.nu.poc.service.BookTicketService;
import com.nu.poc.util.UtilityService;

@RestController
public class BookTicketController {

	@Autowired
	private PassengerRepo passengerRepo;
	@Autowired
	private BookTicketRepo bookTicketRepo;
	UtilityService utilityService = new UtilityService();
	
	
	@GetMapping(value = "/")
	public String getPage() {
		return "Welcome to ADO POC API";
	}
	
	@GetMapping(value = "/passengers")
	public List<Passenger> getPassenger() {
		Passenger p = passengerRepo.findByEmailId("sudan@gmail.com").get(0);
		System.out.println("Passenger First Name data:"+ p.getFirstName());
		return passengerRepo.findAll();
	}
	
	@PostMapping(value = "/savePassenger")
	public String savePassenger(@RequestBody Passenger passenger) {
		passengerRepo.save(passenger);
		return "Saved Successfully";
	}
	
	@GetMapping(value = "/ticket")
	public List<BookTicket> getTicket() {
		return bookTicketRepo.findAll();
	}
	
	@PostMapping(value = "/bookTicket")
	public ResponseEntity<TicketData> saveBookTicket(@RequestBody BookTicket bookTicket) {
		String bookingId = utilityService.generateBookingId(15);
		bookTicket.setBookingId(bookingId);
		bookTicketRepo.save(bookTicket);
		BookTicket ticket = bookTicketRepo.findByBookingId(bookingId).get(0);
		TicketData ticketData = TicketData.builder().bookingId(bookingId)
				.travelDateTime(ticket.getTravel().getTravelDateTime())
				.originName(ticket.getTravel().getOriginName())
				.destinationName(ticket.getTravel().getDestinationName())
				.seatNumber(ticket.getTravel().getSeatNumber())
				.busBrand(ticket.getTravel().getBusBrand())
				.totalTicketAmount(ticket.getTravel().getTicketAmount())
				.emailId(ticket.getPassenger().getEmailId())
				.message("Ticket Booked Successfully")
				.build();
		return new ResponseEntity<>(ticketData, HttpStatus.OK);
	}
	
}
