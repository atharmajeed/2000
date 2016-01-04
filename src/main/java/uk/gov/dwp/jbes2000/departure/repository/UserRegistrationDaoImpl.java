package uk.gov.dwp.jbes2000.departure.repository;

import uk.gov.dwp.jbes2000.departure.repository.AbstractJpaDAO;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import uk.gov.dwp.jbes2000.departure.model.User;
 
@Repository
public class UserRegistrationDaoImpl extends AbstractJpaDAO<User> implements UserRegistrationDao{

	public UserRegistrationDaoImpl() {
        super();
        setClazz(User.class);
    }
	
	@Override
	public User findById(long id) {
		return findOne(id);
	}

	@Override
	public User findByName(String name) {
		List<User> userList = findAllUsers();
		Iterator<User> userListItr = userList.iterator();
		while(userListItr.hasNext()){
			User user = userListItr.next();
			if(user.getName().equals(name)){
				return user;
			}
		}
		return null;
	}

	@Override
	public void saveUser(User user) {
		create(user);
	}

	@Override
	public void updateUser(User user) {
		update(user);
	}

	@Override
	public void deleteUserById(long id) {
		User user = findOne(id);
		delete(user);
	}

	@Override
	public List<User> findAllUsers() {
		return findAll();
	}

	@Override
	public void deleteAllUsers() {
		deleteAll("DELETE FROM User");
	}

	@Override
	public boolean isUserExist(User user) {
		if (user.getId() != null) {
			User dbUser = findOne(user.getId());
			if (dbUser != null) {
				return true;
			}
		}
		return false;
	}
	
}