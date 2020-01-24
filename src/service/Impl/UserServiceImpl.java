package service.Impl;

import dao.UserDao;
import dao.Impl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao uDao = new UserDaoImpl();
	
	//用户登录
	public User login(String username) {	
		return uDao.findUserByName(username);	
	}

	//用户注册
	public boolean register(User user) {
		boolean res = uDao.addUser(user);	
		return res;
	}

	

	//检查用户名是否已经存在
	public boolean checkUsername(String username) {
		User user = uDao.findUserByName(username);
		if(user == null){
			return false;  //不存在
		}else{
			return true;  //已存在
		}
		
		
	}

}
