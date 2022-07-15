package com.nu.poc.ado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TicketData {

	private String bookingId;
	private String travelDateTime;
	private String originName;
	private String destinationName;
	private String seatNumber;
	private String busBrand;
	private String totalTicketAmount;
	private String emailId;
	private String message;
	
}
