package com.app;

import java.util.Random;

public class GenerateOTP {
	
	private int OTP_Value = 0;
	
	public int generateOTP() {
		Random rand = new Random();
        // Generate a random number between 100000 and 999999 (6 digits)
		return rand.nextInt(900000) + 100000;  
	}
	
	
	public void set_OTP(int OTP_Value) {
		this.OTP_Value = OTP_Value;
	}
	
	public int get_OTP() {
		return this.OTP_Value;
	}
	
}