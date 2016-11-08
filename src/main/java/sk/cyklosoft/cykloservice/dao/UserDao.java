package sk.cyklosoft.cykloservice.dao;

import java.util.List;

import sk.cyklosoft.cykloservice.model.User;
import sk.cyklosoft.cykloservice.util.SportType;

public interface UserDao {

	void register(User user);
	
	User findUserByUsername(String username);
	
//get current sport activity	
	SportType getCurrentActivity(String username);

//set current sport activity	
	void updateUser(String username, SportType sportType);

	void delete(String username);

	List<User> findAllUsers();

}
