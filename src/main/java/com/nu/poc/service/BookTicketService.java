package com.nu.poc.service;

import org.springframework.boot.json.JsonParseException;

import com.nu.poc.ado.model.BookTicket;
import com.nu.poc.ado.model.TicketData;

public interface BookTicketService {

	public TicketData getBookTicket(BookTicket bookTicket) throws JsonParseException;
	
}
