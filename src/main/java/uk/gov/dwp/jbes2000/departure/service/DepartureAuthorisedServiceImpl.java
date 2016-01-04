package uk.gov.dwp.jbes2000.departure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uk.gov.dwp.jbes2000.departure.model.DepartureAuthorised;
import uk.gov.dwp.jbes2000.departure.repository.DepartureAuthorisedDao;

@Service("DepartureAuthorisedService")
@Transactional
public class DepartureAuthorisedServiceImpl implements DepartureAuthorisedService{
	
	@Autowired
	DepartureAuthorisedDao departureAuthorisedDao;

	@Override
	public DepartureAuthorised findByDepartureAutorisedId(long departureAuthorisedId) {
		return departureAuthorisedDao.findByDepartureAuthorisedId(departureAuthorisedId);
	}

	@Override
	public void saveDepartureAuthorised(DepartureAuthorised departureAuthorised) {
		departureAuthorisedDao.saveDepartureAuthorised(departureAuthorised);
	}

	@Override
	public void updateDepartureAuthorised(DepartureAuthorised departureAuthorised) {
		departureAuthorisedDao.updateDepartureAuthorised(departureAuthorised);
	}

	@Override
	public void deleteDepartureAuthorisedById(long departureAuthorisedId) {
		departureAuthorisedDao.deleteDepartureAuthorisedById(departureAuthorisedId);		
	}

	@Override
	public List<DepartureAuthorised> getDepartureAuthorised() {
		return departureAuthorisedDao.getDepartureAuthorised();
	}

	@Override
	public boolean isDepartureAuthorisedExist(DepartureAuthorised departureAuthorised) {
		return departureAuthorisedDao.isDepartureAuthorisedExist(departureAuthorised);
	}


	
}
