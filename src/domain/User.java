package domain;

import java.util.Date;

/**
 *    �û�
 * 
 *
 */
public class User {
	private String uid;       //�û�id    
    private String username;    //�û���
    private String password;    //�û�����
    private String email;      //�û�����
    private String birthday;      //�û���������
    private String sex;       //�û��Ա�
    
    
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
