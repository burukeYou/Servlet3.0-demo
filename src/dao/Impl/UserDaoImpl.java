package dao.Impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.UserDao;
import domain.User;
import utils.MyDataSourceUtils;

public class UserDaoImpl implements UserDao {

	//添加用户
	public boolean addUser(User user){
		//给dbutil工具注入数据源
		QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
		String sql = "insert into User values(?,?,?,?,?,?)";
		int res = 1;
		try {
			res = runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
					user.getEmail(),new SimpleDateFormat("yyyy-MM-dd").parse(user.getBirthday()),user.getSex());   //返回负数代表注册失败
		} catch (Exception e) {
			res = -1;
			e.printStackTrace();
		}
		
		return res > 0 ? true: false;  
	}

	//根据用户名查找用户
	public User findUserByName(String username) {
		QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
		String sql = "select* from User where username=?";
		User user = null;
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	//根据ID查找用户
	public User findUserByID(String u_id) {
		QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
		String sql = "select* from User where uid=?";
		User user = null;
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class), u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	
	
	
	
}
