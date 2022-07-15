package com.nu.poc.ado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Travel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long travelId;
	@Column
	private String passengerType;
	@Column
	private String originName;
	@Column
	private String destinationName;
	@Column
	private String seatNumber;
	@Column
	private String busBrand;
	@Column
	private String travelDateTime;
	@Column
	private String ticketAmount;
	@Column
	private String ticketTax;
	@Column
	private String totalTicketAmount;
	@Column
	private String complementaryService;
	@Column
	private String cServiceAmount;
	@Column
	private String coupon;
	
}
