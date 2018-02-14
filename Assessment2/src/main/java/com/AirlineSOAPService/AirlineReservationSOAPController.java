package com.concretepage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.concretepage.soap.GetStudentRequest;
import com.concretepage.soap.GetStudentResponse;
import com.service.FlightService;
@Endpoint
public class AirlineReservationSOAPController {
	private static final String NAMESPACE_URI = ("http://airlineresevation.com/soap");
	@Autowired
	private FlightService flightService;	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFlight")
	@ResponsePayload
	public GetFlightResponse getFlight(@RequestPayload GetFlightRequest request) {
		GetFlightResponse response = new GetFlightResponse();
		response.setFlightDetails(flightService.getFlight(request.getflight_id()));
		return response;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFlight")
	@ResponsePayload
	public GetFlightResponse getFlight(@RequestPayload GetFlightRequest request) {
		GetFlightResponse response = new GetFlightResponse();
		response.setFlightDetails(flightService.getFlight(request.getflight_id()));
		return response;
	}
} 