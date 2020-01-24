package domain;

import java.util.Date;

/**
 *        文档
 */
public class Document {
	private String did;  //
	private Date uploadTime;  //时间
	private String dname;  //文档名
	private String filesize; //文档大小
	

	private String dtype; //文档类型，后缀	
	private String address;     //文档地址
	private int isShare;   //是否是共享文档 ,1是，0不是
	private int isGarbage;   //是否是垃圾文件，1是，0不是
	
	
	
	private String u_id;  //外键
	private User user;     //所属用户

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
