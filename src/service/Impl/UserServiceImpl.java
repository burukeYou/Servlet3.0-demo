package service.Impl;

import dao.UserDao;
import dao.Impl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao uDao = new UserDaoImpl();
	
	//�û���¼
	public User login(String username) {	
		return uDao.findUserByName(username);	
	}

	//�û�ע��
	public boolean register(User user) {
		boolean res = uDao.addUser(user);	
		return res;
	}

	

	//����û����Ƿ��Ѿ�����
	public boolean checkUsername(String username) {
		User user = uDao.findUserByName(username);
		if(user == null){
			return false;  //������
		}else{
			return true;  //�Ѵ���
		}
		
		
	}

}
