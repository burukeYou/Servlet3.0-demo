package domain;

/**
 *    封装前台查询条件参数
 * 
 */
public class QueryVo {
	
	private String filename;
	
	private String filetype;
	
	//查询当前页          --默认是第一页
	private Integer currentPage = 1;
	
	//每显示个数		  --默认每页显示5条
	private Integer pageSize = 5;

	//当前登录用户
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
