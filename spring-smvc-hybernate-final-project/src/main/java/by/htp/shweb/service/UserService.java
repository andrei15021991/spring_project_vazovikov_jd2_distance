package by.htp.shweb.service;

import java.util.List;

import by.htp.shweb.entity.User;

public interface UserService {
	
	public User logination(String login, String password);
	public void registration(User user);
	public List<User> getUsers();
	public void deleteUser(int id);
	public User getUser(int id);

}
