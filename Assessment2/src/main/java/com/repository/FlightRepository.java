package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Flight;



public interface FlightRepository extends JpaRepository<Flight, Long>{

	Flight findFLightByID(int flight_id);
	void update(Flight flight);
    void delete(Flight flight) ;

}
