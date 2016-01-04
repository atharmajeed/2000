package uk.gov.dwp.jbes2000.departure.repository;

import uk.gov.dwp.jbes2000.departure.repository.AbstractJpaDAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import uk.gov.dwp.jbes2000.departure.model.DepartureAuthorised;
 
@Repository
public class DepartureAuthorisedDaoImpl extends AbstractJpaDAO<DepartureAuthorised> implements DepartureAuthorisedDao{

	public DepartureAuthorisedDaoImpl() {
        super();
        setClazz(DepartureAuthorised.class);
    }

	@Override
	public DepartureAuthorised findByDepartureAuthorisedId(long departureAuthorisedId) {
		return findOne(departureAuthorisedId);
	}

	@Override
	public void saveDepartureAuthorised(DepartureAuthorised departureAuthorised) {
		create(departureAuthorised);
	}

	@Override
	public void updateDepartureAuthorised(DepartureAuthorised departureAuthorised) {
		update(departureAuthorised);
	}

	@Override
	public void deleteDepartureAuthorisedById(long departureAuthorisedId) {
		DepartureAuthorised departureAuthorised = findOne(departureAuthorisedId);
		delete(departureAuthorised);
	}

	@Override
	public List<DepartureAuthorised> getDepartureAuthorised() {
		return findAll();
	}

	@Override
	public boolean isDepartureAuthorisedExist(DepartureAuthorised departureAuthorised) {
		DepartureAuthorised dbDepartureAuthorised = findOne(departureAuthorised.getDepartureAuthId());
		if (dbDepartureAuthorised != null) {
			return true;
		}
		return false;

	}
	
}