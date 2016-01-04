package uk.gov.dwp.jbes2000.departure.repository;

import java.util.List;

import uk.gov.dwp.jbes2000.departure.model.DepartureHistory;

public interface DepartureHistoryDao {
	
	DepartureHistory findByDepartureHistoryId(long departureHistoryId);
	
	void saveDepartureHistory(DepartureHistory departureHistory);
	
	void updateDepartureHistory(DepartureHistory departureHistory);
	
	void deleteDepartureHistoryById(long departureHistoryId);

	List<DepartureHistory> getDepartureHistory(); 
	
	public boolean isDepartureHistoryExist(DepartureHistory departureHistory);

}
