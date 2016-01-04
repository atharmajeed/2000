package uk.gov.dwp.jbes2000.departure.repository;

import java.util.List;

import uk.gov.dwp.jbes2000.departure.model.Departure;

public interface DepartureDao {
	
	Departure findByDepartureId(long DepartureId);
	
	void saveDeparture(Departure Departure);
	
	void updateDeparture(Departure Departure);
	
	void deleteDepartureById(long DepartureId);

	List<Departure> getDeparture(); 
	
	public boolean isDepartureExist(Departure Departure);

}
