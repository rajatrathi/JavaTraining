package com.repository;

import com.model.Flight;

public interface FlightDAO 
{

	void create(Flight flight);
	Flight findFLightByID(int flight_id);
	void update(Flight flight);
	boolean delete(int flight_id);
	
}
