package com.cg.cropbiddinginsuranceapp.exception;

public class BidderNotFoundException extends RuntimeException {

	public BidderNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BidderNotFoundException(String message) {
		super(message);
		
	}

	public BidderNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
