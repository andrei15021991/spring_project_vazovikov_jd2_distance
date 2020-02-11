package by.htp.shweb.dao;

import java.util.List;

import by.htp.shweb.entity.User;

public interface UserDAO {
	
	public User logination(String login, String password);
	public void registration(User user);
	public List<User> getUsers();
	public void deleteUser(int id);
	public User getUser(int id);
	

}
