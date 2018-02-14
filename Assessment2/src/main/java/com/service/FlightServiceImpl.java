package com.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Flight;
import com.repository.FlightDAO;

@Service
public class FlightServiceImpl implements FlightService
{

final static Logger logger = Logger.getLogger(FlightServiceImpl.class);
	
    AtomicInteger atomicInteger = new AtomicInteger(1);
    
    @Autowired
	private FlightDAO flightDao; 
	@Override
	public void createFlight(Flight flight) {
		flight.setFlight_id(atomicInteger.incrementAndGet());
		flightDao.create(flight);
		
	}

	@Override
	@Transactional
	public void updateFlight(Flight flight) {
		flightDao.update(flight);
	
	}

	@Override
	public Flight getFlight(Integer flight_id) {
		return flightDao.findFLightByID(flight_id);
	}

	@Override
	public boolean deleteFlight(Integer flight_id) {
		if (flightDao.findFLightByID(flight_id) != null) { 
			return flightDao.delete(flight_id);
		} else {
			return false;
		}
		
	}

}
