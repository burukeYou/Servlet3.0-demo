package domain;

import java.util.Date;

/**
 *        �ĵ�
 */
public class Document {
	private String did;  //
	private Date uploadTime;  //ʱ��
	private String dname;  //�ĵ���
	private String filesize; //�ĵ���С
	

	private String dtype; //�ĵ����ͣ���׺	
	private String address;     //�ĵ���ַ
	private int isShare;   //�Ƿ��ǹ����ĵ� ,1�ǣ�0����
	private int isGarbage;   //�Ƿ��������ļ���1�ǣ�0����
	
	
	
	private String u_id;  //���
	private User user;     //�����û�

	//======================================================================
	public String getDid() {
		return did;
	}


	public void setDid(String did) {
		this.did = did;
	}


	public Date getUploadTime() {
		return uploadTime;
	}

	public String getFilesize() {
		return filesize;
	}


	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getDtype() {
		return dtype;
	}


	public void setDtype(String dtype) {
		this.dtype = dtype;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getIsShare() {
		return isShare;
	}


	public void setIsShare(int isShare) {
		this.isShare = isShare;
	}


	public int getIsGarbage() {
		return isGarbage;
	}


	public void setIsGarbage(int isGarbage) {
		this.isGarbage = isGarbage;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public String getU_id() {
		return u_id;
	}


	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	@Override
	public String toString() {
		return "Document [did=" + did + ", uploadTime=" + uploadTime + ", dname=" + dname + ", dtype=" + dtype
				+ ", address=" + address + ", isShare=" + isShare + ", isGarbage=" + isGarbage + ", user=" + user + "]";
	}
	
	
	
	

}
