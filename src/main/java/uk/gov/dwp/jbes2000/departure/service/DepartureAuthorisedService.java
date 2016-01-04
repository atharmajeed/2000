package uk.gov.dwp.jbes2000.departure.service;

import java.util.List;

import uk.gov.dwp.jbes2000.departure.model.DepartureAuthorised;

public interface DepartureAuthorisedService {
	
	DepartureAuthorised findByDepartureAutorisedId(long departureAuthorisedId);
	
	void saveDepartureAuthorised(DepartureAuthorised departureAuthorised);
	
	void updateDepartureAuthorised(DepartureAuthorised departureAuthorised);
	
	void deleteDepartureAuthorisedById(long departureAuthorisedId);

	List<DepartureAuthorised> getDepartureAuthorised(); 
	
	public boolean isDepartureAuthorisedExist(DepartureAuthorised departureAuthorised);
	
}
