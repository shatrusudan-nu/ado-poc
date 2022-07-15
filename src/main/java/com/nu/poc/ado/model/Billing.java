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
public class Billing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long billingId;
	@Column
	private String paymentType;
	@Column
	private String currencyCode;
	@Column
	private String cardType;
	@Column
	private String creditCardNumber;
	@Column
	private String creditCardExpireMonth;
	@Column
	private String creditCardExpireYear;
	@Column
	private String billingEmailAddress;
	@Column
	private String billingPhoneNumber;
	@Column
	private String billingAmount;
	@Column
	private String promotionCode;
	@Column
	private String promotionAmount;
}
