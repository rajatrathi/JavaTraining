package com.service;

import com.model.Flight;

public interface FlightService 
{
	void createFlight(Flight flight);
	void updateFlight(Flight flight);
	Flight getFlight(Integer flight_id);
	boolean deleteFlight(Integer flight_id);
}
