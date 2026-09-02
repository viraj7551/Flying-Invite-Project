package com.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDate {

	private String current_date = null;

	private void date_implementation() {
		LocalDateTime ld = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
		this.current_date = dtf.format(ld);
	}
	
	public String current_date() {
		return current_date;
	}
	
	
}
