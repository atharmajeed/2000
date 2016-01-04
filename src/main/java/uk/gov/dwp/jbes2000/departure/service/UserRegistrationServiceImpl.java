package uk.gov.dwp.jbes2000.departure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uk.gov.dwp.jbes2000.departure.model.User;
import uk.gov.dwp.jbes2000.departure.repository.UserRegistrationDao;

@Service("UserRegistrationService")
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService{
	
	private List<User> users;
	
	@Autowired
	UserRegistrationDao userRegistrationDao;

	public List<User> findAllUsers() {
		users = userRegistrationDao.findAllUsers();
		return users;
	}
	
	public User findById(long id) {
		return userRegistrationDao.findById(id);
	}
	
	public User findByName(String name) {
		return userRegistrationDao.findByName(name);
	}
	
	public void saveUser(User user) {
		userRegistrationDao.saveUser(user);
	}

	public void updateUser(User user) {
		userRegistrationDao.updateUser(user);
	}

	public void deleteUserById(long id) {
		userRegistrationDao.deleteUserById(id);
	}

	public boolean isUserExist(User user) {
		return userRegistrationDao.isUserExist(user);
	}
	
	public void deleteAllUsers(){
		userRegistrationDao.deleteAllUsers();
	}

	public boolean equals(Object arg0) {
		return userRegistrationDao.equals(arg0);
	}

	public int hashCode() {
		return userRegistrationDao.hashCode();
	}

	public String toString() {
		return userRegistrationDao.toString();
	}
	
}
