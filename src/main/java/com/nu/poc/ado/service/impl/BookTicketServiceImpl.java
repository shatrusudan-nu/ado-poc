package com.nu.poc.ado.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nu.poc.ado.model.BookTicket;
import com.nu.poc.ado.model.TicketData;
import com.nu.poc.ado.repo.BookTicketRepo;
import com.nu.poc.ado.service.BookTicketService;
import com.nu.poc.ado.util.UtilityService;

@Service
public class BookTicketServiceImpl implements BookTicketService{

	private static final Logger LOG = LoggerFactory.getLogger(BookTicketServiceImpl.class);
	@Autowired
	private BookTicketRepo bookTicketRepo;
	UtilityService utilityService = new UtilityService();
	
	@Override
	public TicketData getBookTicket(BookTicket bookTicket) throws JsonParseException {
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
		LOG.info("Ticket Booked");
		return ticketData;
	}

	@Override
	public List<BookTicket> getTicket() {
		LOG.info("Get All ticket..");
		return bookTicketRepo.findAll();
	}

}
