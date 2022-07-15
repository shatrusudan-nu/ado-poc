package com.nu.poc.ado.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String bookingDateTime;
	@Column
	private String ticketQuantity;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "travel_id")
	private Travel travel;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "passenger_id")
	private Passenger passenger;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "billing_id")
	private Billing billing;
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "shipping_id")
	private Shipping shipping;
	@Column
	private String bookingId;
	
	
}
