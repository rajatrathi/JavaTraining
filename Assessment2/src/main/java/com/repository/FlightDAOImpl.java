package com.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.model.Flight;




@Repository
public class FlightDAOImpl implements FlightDAO{

	final static Logger logger = Logger.getLogger(FlightDAOImpl.class);
	public Map<Integer, Flight> flightMap = new HashMap<>();
	@Override
	public void create(Flight flight) {
		logger.debug(flight);
		flightMap.put(flight.getFlight_id(), flight);
		
	}

	@Override
	public Flight findFLightByID(int flight_id) {
		for (Map.Entry<Integer, Flight> flightEntry : flightMap.entrySet()) {
			if (flightEntry.getValue().getFlight_id().equals(flight_id)) {
				return flightEntry.getValue();
			}
		}
		return null;
	}

	@Override
	public void update(Flight flight) {
		for (Map.Entry<Integer, Flight> flightEntry : flightMap.entrySet()) {
			if (flightEntry.getValue().getFlight_id().equals(flight.getFlight_id())) {
				flightEntry.setValue(flight);
			}
		}
		
	}

	@Override
	public boolean delete(int flight_id) {
		for (Map.Entry<Integer, Flight> flightEntry : flightMap.entrySet()) {
			if (flightEntry.getValue().getFlight_id().equals(flight_id)) {
				 return flightMap.remove(flight_id) != null;
			}
		}
		return false;
		
	}

}
