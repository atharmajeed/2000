package uk.gov.dwp.jbes2000.departure.service;

import java.util.List;

import uk.gov.dwp.jbes2000.departure.model.Departure;

public interface DepartureService {
	
	Departure findByDepartureId(long departureId);
	
	void saveDeparture(Departure departure);
	
	void updateDeparture(Departure departure);
	
	void deleteDepartureById(long departureId);

	List<Departure> getDeparture(); 
	
	public boolean isDepartureExist(Departure departure);
	
}
