package uk.gov.dwp.jbes2000.departure.service;

import java.util.List;

import uk.gov.dwp.jbes2000.departure.model.DepartureHistory;

public interface DepartureHistoryService {
	
	DepartureHistory findByDepartureHistoryId(long departureHistoryId);
	
	void saveDepartureHistory(DepartureHistory departureHistory);
	
	void updateDepartureHistory(DepartureHistory departureHistory);
	
	void deleteDepartureHistoryById(long departureHistoryId);

	List<DepartureHistory> getDepartureHistory(); 
	
	public boolean isDepartureHistoryExist(DepartureHistory departureHistory);
	
}
