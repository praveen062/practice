package com.example.datastructures.string;

public class Minute {
	Integer hour;
    Integer minute;
    public Minute(String hour, String minute) {
		// TODO Auto-generated constructor stub
    	this.hour = Integer.parseInt(hour);
    	this.minute = Integer.parseInt(minute);
	}
	@Override
	public String toString() {
		return "Minute [hour=" + hour + ", minute=" + minute + "]";
	}
}
