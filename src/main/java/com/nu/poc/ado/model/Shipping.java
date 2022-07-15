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
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shippingId;
	@Column
	private String shippingFirstName;
	@Column
	private String shippingLastName;
	@Column
	private String shippingEmailAddress;
	@Column
	private String shippingAddress;
	@Column
	private String shippingAddress2;
	@Column
	private String shippingPhoneNumber;
	@Column
	private String shippingCity;
	@Column
	private String shippingState;
	@Column
	private String shippingCountry;
	
}
