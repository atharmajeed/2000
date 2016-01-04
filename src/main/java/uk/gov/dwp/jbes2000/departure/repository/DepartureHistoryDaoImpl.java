package uk.gov.dwp.jbes2000.departure.repository;

import uk.gov.dwp.jbes2000.departure.repository.AbstractJpaDAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import uk.gov.dwp.jbes2000.departure.model.DepartureHistory;
 
@Repository
public class DepartureHistoryDaoImpl extends AbstractJpaDAO<DepartureHistory> implements DepartureHistoryDao{

	public DepartureHistoryDaoImpl() {
        super();
        setClazz(DepartureHistory.class);
    }

	@Override
	public DepartureHistory findByDepartureHistoryId(long departureHistoryId) {
		return findOne(departureHistoryId);
	}

	@Override
	public void saveDepartureHistory(DepartureHistory departureHistory) {
		create(departureHistory);
	}

	@Override
	public void updateDepartureHistory(DepartureHistory departureHistory) {
		update(departureHistory);
	}

	@Override
	public void deleteDepartureHistoryById(long departureHistoryId) {
		DepartureHistory departureHistory = findOne(departureHistoryId);
		delete(departureHistory);
	}

	@Override
	public List<DepartureHistory> getDepartureHistory() {
		return findAll();
	}

	@Override
	public boolean isDepartureHistoryExist(DepartureHistory departureHistory) {

		if (departureHistory.getHistoryId() != null) {
			DepartureHistory dbDepartureHistory = findOne(departureHistory.getHistoryId());
			if (dbDepartureHistory != null) {
				return true;
			}
		}
		return false;
	
	}
	
}