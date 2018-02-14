package com.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Flight_Details 
{
	@NotNull
    Integer id;
	Integer flight_id;
	Date flight_departure_date;
	Integer price;
	Integer available_seats;
}
