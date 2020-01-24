package dao;

import java.sql.SQLException;

import domain.User;

public interface UserDao {

	public boolean addUser(User user) ;

	public User findUserByName(String username);

	public User findUserByID(String u_id);

}
