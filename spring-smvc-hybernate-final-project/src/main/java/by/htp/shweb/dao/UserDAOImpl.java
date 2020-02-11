package by.htp.shweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.shweb.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public User logination(String login, String password) {

		User user = null;

		Session session = sessionFactory.getCurrentSession();

		Query<User> query = session.createQuery("from User where login = :login and password = :password", User.class);
		query.setParameter("login", login);
		query.setParameter("password", password);

		if (!query.getResultList().isEmpty()) {
			user = query.getSingleResult();
		}

		return user;
	}

	public void registration(User user) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(user);

	}

	public List<User> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<User> theQuery = currentSession.createQuery("from User", User.class);

		List<User> users = theQuery.getResultList();

		return users;
	}

	public void deleteUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from User where id=:userId");
		theQuery.setParameter("userId", id);

		theQuery.executeUpdate();

	}

	public User getUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		User user = currentSession.get(User.class, id);

		return user;
	}

}
