package domain;

/**
 *    ��װǰ̨��ѯ��������
 * 
 */
public class QueryVo {
	
	private String filename;
	
	private String filetype;
	
	//��ѯ��ǰҳ          --Ĭ���ǵ�һҳ
	private Integer currentPage = 1;
	
	//ÿ��ʾ����		  --Ĭ��ÿҳ��ʾ5��
	private Integer pageSize = 5;

	//��ǰ��¼�û�
	private User user;
	
	
	//-----------------------------------------------------
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "QueryVo [filename=" + filename + ", filetype=" + filetype + ", currentPage=" + currentPage
				+ ", pageSize=" + pageSize + ", user=" + user + "]";
	}

	
	

	

	

}
