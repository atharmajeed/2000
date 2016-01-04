package uk.gov.dwp.jbes2000.departure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uk.gov.dwp.jbes2000.departure.model.Departure;
import uk.gov.dwp.jbes2000.departure.repository.DepartureDao;

@Service("DepartureService")
@Transactional
public class DepartureServiceImpl implements DepartureService{
	
	@Autowired
	DepartureDao departureDao;

	@Override
	public Departure findByDepartureId(long DepartureId) {
		return departureDao.findByDepartureId(DepartureId);
	}

	@Override
	public void saveDeparture(Departure Departure) {
		departureDao.saveDeparture(Departure);
	}

	@Override
	public void updateDeparture(Departure Departure) {
		departureDao.updateDeparture(Departure);
	}

	@Override
	public void deleteDepartureById(long DepartureId) {
		departureDao.deleteDepartureById(DepartureId);		
	}

	@Override
	public List<Departure> getDeparture() {
		return departureDao.getDeparture();
	}

	@Override
	public boolean isDepartureExist(Departure Departure) {
		return departureDao.isDepartureExist(Departure);
	}


	
}
