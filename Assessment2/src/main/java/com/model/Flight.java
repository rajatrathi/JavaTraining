package com.model;

import lombok.Data;

@Data
public class Flight {

	Integer flight_id;
	Integer airline_id;
	String airline_name;
	String from_location;
	String to_location;
	String departure_time;
	String arrival_time;
	Integer duration;
	Integer total_seats;
	Flight_Details flightDetails;
}
