package service;

import domain.User;

public interface UserService {
	
	public User login(String username); //��¼
	
	public boolean register(User user);	//ע��
	

	public boolean checkUsername(String username);
}
