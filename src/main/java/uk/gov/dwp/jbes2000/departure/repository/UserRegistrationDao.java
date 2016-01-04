package uk.gov.dwp.jbes2000.departure.repository;

import java.util.List;

import uk.gov.dwp.jbes2000.departure.model.User;

public interface UserRegistrationDao {

	User findById(long id);

	User findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(long id);

	List<User> findAllUsers();

	void deleteAllUsers();

	public boolean isUserExist(User user);

}
