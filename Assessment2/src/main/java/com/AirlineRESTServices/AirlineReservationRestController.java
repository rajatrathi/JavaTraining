package com.AirlineRESTServices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Flight;
import com.model.Flight_Details;
import com.repository.FlightRepository;
import com.service.FlightService;

@EnableAutoConfiguration
@RestController
@RequestMapping("/flight")
public class AirlineReservationRestController {

	FlightService flightservice;

	ModelMap model = new ModelMap();
	ModelMap model2 = new ModelMap();

	@RequestMapping(params = "json", value = "/airline/{number}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getFlightJSON(@PathVariable("number") int number, @RequestParam boolean json)
			throws JsonProcessingException, JSONException {

		Flight f = flightservice.getFlight(number);
		if (f == null) {
			model.clear();
			model2.clear();
			model.addAttribute("BadRequest", model2);
			model2.addAttribute("code", "404");
			String st = "Flight with Number " + number + " does not exist";
			model2.addAttribute("msg", st);
		} else {

			JSONObject json = new JSONObject(f.getFullJson().toString());

			return ResponseEntity.ok(json);
		}

	}

	@RequestMapping(value = "/flight/{flightNumber}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> createFlight(@PathVariable("flight_id") Integer flight_id,
			@RequestParam(value = "airlineId", required = true) int airlineId,
			@RequestParam(value = "airlineName", required = true) String airlineName,
			@RequestParam(value = "from_location", required = true) String from_location,
			@RequestParam(value = "to_location", required = true) String to_location,
			@RequestParam(value = "departure_time", required = true) String departure_time,
			@RequestParam(value = "arrival_time", required = true) String arrival_time,
			@RequestParam(value = "duration", required = true) int duration,
			@RequestParam(value = "total_seats", required = true) int total_seats,
			@RequestParam(value = "price", required = true) int price,
			@RequestParam(value = "available_seats", required = true) int available_seats) 
	{

		Flight newFlight;
		Flight_Details flightDetails;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH");
		Date dDate = df.parse(departure_time);
		Date aTime = df.parse(arrival_time);

		newFlight.setFlight_id(flight_id);
		newFlight.setAirline_id(airlineId);
		newFlight.setAirline_name(airlineName);
		newFlight.setFrom_location(from_location);
		newFlight.setTo_location(to_location);
		newFlight.setDeparture_time(departure_time);
		newFlight.setArrival_time(arrival_time);
		flightDetails.setPrice(price);
		flightDetails.setAvailable_seats(available_seats);
		newFlight.setFlightDetails(flightDetails);
		flightservice.createFlight(newFlight);
		}

}


	@RequestMapping(value = "/flight/{flight_id}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> UpdateFlight(@PathVariable("flight_id") Integer flight_id,
			@RequestParam(value = "airlineId", required = true) int airlineId,
			@RequestParam(value = "airlineName", required = true) String airlineName,
			@RequestParam(value = "from_location", required = true) String from_location,
			@RequestParam(value = "to_location", required = true) String to_location,
			@RequestParam(value = "departure_time", required = true) String departure_time,
			@RequestParam(value = "arrival_time", required = true) String arrival_time,
			@RequestParam(value = "duration", required = true) int duration,
			@RequestParam(value = "total_seats", required = true) int total_seats,
			@RequestParam(value = "price", required = true) int price,
			@RequestParam(value = "available_seats", required = true) int available_seats) {

		Flight newFlight;
		Flight_Details flightDetails;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH");
		Date dDate = df.parse(departure_time);
		Date aTime = df.parse(arrival_time);
		if (flightservice.getFlight(flight_id) != null) {
			newFlight.setFlight_id(flight_id);
			newFlight.setAirline_id(airlineId);
			newFlight.setAirline_name(airlineName);
			newFlight.setFrom_location(from_location);
			newFlight.setTo_location(to_location);
			newFlight.setDeparture_time(departure_time);
			newFlight.setArrival_time(arrival_time);
			newFlight.setTotal_seats(total_seats);
			flightDetails.setPrice(price);
			flightDetails.setAvailable_seats(available_seats);
			newFlight.setFlightDetails(flightDetails);
			flightservice.createFlight(newFlight);
		}			
		}

	@RequestMapping(value = "/flight/{number}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteFlight(@PathVariable("number") int flight_id) throws JSONException {

		Flight f = flightservice.getFlight(flight_id);

		if (f == null) {
			model.clear();
			model2.clear();
			model.addAttribute("BadRequest", model2);
			model2.addAttribute("code", "404");
			model2.addAttribute("msg", "Flight with Number " + flight_id + " does not exist");

			JSONObject json_result = new JSONObject(model);
			flightservice.deleteFlight(flight_id);

			return new ResponseEntity(json_result, HttpStatus.OK);
		} else {

			model.clear();
			model2.clear();
			model.addAttribute("Response", model2);
			model2.addAttribute("code", "200");
			model2.addAttribute("msg", "Flight with flight_id " + flight_id + " is deleted successfully");

			JSONObject json_result = new JSONObject(model);
			flightservice.deleteFlight(flight_id);

			return new ResponseEntity(json_result, HttpStatus.OK);
		}

	}
}