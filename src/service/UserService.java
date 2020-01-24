package service;

import domain.User;

public interface UserService {
	
	public User login(String username); //µÇÂ¼
	
	public boolean register(User user);	//×¢²á
	

	public boolean checkUsername(String username);
}
