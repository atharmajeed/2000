package uk.gov.dwp.jbes2000.departure.repository;

import java.util.List;

import uk.gov.dwp.jbes2000.departure.model.DepartureAuthorised;


public interface DepartureAuthorisedDao {
	
	DepartureAuthorised findByDepartureAuthorisedId(long departureAuthorisedId);
	
	void saveDepartureAuthorised(DepartureAuthorised departureAuthorised);
	
	void updateDepartureAuthorised(DepartureAuthorised departureAuthorised);
	
	void deleteDepartureAuthorisedById(long departureAuthorisedId);

	List<DepartureAuthorised> getDepartureAuthorised(); 
	
	public boolean isDepartureAuthorisedExist(DepartureAuthorised departureAuthorised);

}
