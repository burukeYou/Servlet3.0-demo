package domain;

import java.util.Date;

/**
 *    用户
 * 
 *
 */
public class User {
	private String uid;       //用户id    
    private String username;    //用户名
    private String password;    //用户密码
    private String email;      //用户邮箱
    private String birthday;      //用户出生年月
    private String sex;       //用户性别
    
    
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", birthday=" + birthday + ", sex=" + sex + "]";
	}
    
    
    
    
	
	
	

}
