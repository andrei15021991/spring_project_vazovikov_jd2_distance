package by.htp.shweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.shweb.dao.UserDAO;
import by.htp.shweb.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public User logination(String login, String password) {
		User user = userDAO.logination(login, password);

		return user;
	}

	@Transactional
	public void registration(User user) {

		userDAO.registration(user);

	}

	@Transactional
	public List<User> getUsers() {
		List<User> users = userDAO.getUsers();

		return users;
	}

	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);

	}

	@Transactional
	public User getUser(int id) {
		User user = userDAO.getUser(id);

		return user;
	}

}
