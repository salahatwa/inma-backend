package com.inma.itp.models.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class OrderRequest {

	@NotBlank
	private String stockSymbol;

	@NotBlank
	private String walletNumber;

	/**
	 * SPR for BUY SSL for sell
	 */
	@NotBlank
	private String orderSide;

	private int orderQty;

	/**
	 * 
	 */
	private int orderType;

	private int tifType;

	private double unitPrice;

	private double minFillQty;

}
