package uk.gov.dwp.jbes2000.departure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uk.gov.dwp.jbes2000.departure.model.DepartureHistory;
import uk.gov.dwp.jbes2000.departure.repository.DepartureHistoryDao;

@Service("DepartureHistoryService")
@Transactional
public class DepartureHistoryServiceImpl implements DepartureHistoryService{
	
	@Autowired
	DepartureHistoryDao departureHistoryDao;

	@Override
	public DepartureHistory findByDepartureHistoryId(long departureHistoryId) {
		return departureHistoryDao.findByDepartureHistoryId(departureHistoryId);
	}

	@Override
	public void saveDepartureHistory(DepartureHistory departureHistory) {
		departureHistoryDao.saveDepartureHistory(departureHistory);
	}

	@Override
	public void updateDepartureHistory(DepartureHistory departureHistory) {
		departureHistoryDao.updateDepartureHistory(departureHistory);
	}

	@Override
	public void deleteDepartureHistoryById(long departureHistoryId) {
		departureHistoryDao.deleteDepartureHistoryById(departureHistoryId);		
	}

	@Override
	public List<DepartureHistory> getDepartureHistory() {
		return departureHistoryDao.getDepartureHistory();
	}

	@Override
	public boolean isDepartureHistoryExist(DepartureHistory departureHistory) {
		return departureHistoryDao.isDepartureHistoryExist(departureHistory);
	}


	
}
