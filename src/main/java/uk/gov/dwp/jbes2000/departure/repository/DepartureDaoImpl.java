package uk.gov.dwp.jbes2000.departure.repository;

import uk.gov.dwp.jbes2000.departure.repository.AbstractJpaDAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import uk.gov.dwp.jbes2000.departure.model.Departure;
 
@Repository
public class DepartureDaoImpl extends AbstractJpaDAO<Departure> implements DepartureDao{

	public DepartureDaoImpl() {
        super();
        setClazz(Departure.class);
    }

	@Override
	public Departure findByDepartureId(long DepartureId) {
		return findOne(DepartureId);
	}

	@Override
	public void saveDeparture(Departure Departure) {
		create(Departure);
	}

	@Override
	public void updateDeparture(Departure Departure) {
		update(Departure);
	}

	@Override
	public void deleteDepartureById(long DepartureId) {
		Departure Departure = findOne(DepartureId);
		delete(Departure);
	}

	@Override
	public List<Departure> getDeparture() {
		return findAll();
	}

	@Override
	public boolean isDepartureExist(Departure departure) {

		if (departure.getDepartureId() != null) {
			Departure dbDeparture = findOne(departure.getDepartureId());
			if (dbDeparture != null) {
				return true;
			}
		}
		return false;
	
	}
	
}