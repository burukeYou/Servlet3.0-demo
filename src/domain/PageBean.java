package domain;

import java.util.List;

/**
 * 	分页查询返回结果
 * 
 * 
 */
public class PageBean {
	
	//总页数
	private Integer totalPageCount;
	
	//当前页
	private Integer currentPage;
	
	//每页显示数量
	private Integer pageSize;
	
	//文件总个数
	private Integer totalFileCount;
	
	//显示的文档
	private List<Document> documentlist;
		
	//------------------------------------------------------------------
	public PageBean() {
	}
	
	public PageBean(Integer currentPage,Integer totalFileCount,Integer pageSize){
		this.currentPage = currentPage;
		this.totalFileCount = totalFileCount;
		this.pageSize = pageSize;
		
		//计算总页数      --需向上取整      --10 / 3 -->4页
		this.totalPageCount = (totalFileCount + pageSize-1)/pageSize;
		

		//判断当前页是否合法
		if(this.currentPage<1){
			this.currentPage = 1;
		}else if(this.currentPage > this.totalPageCount){
			this.currentPage = this.totalPageCount;
		}
	}

	
	
	
	




	//===================================================================
	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
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

	public Integer getTotalFileCount() {
		return totalFileCount;
	}

	public void setTotalFileCount(Integer totalFileCount) {
		this.totalFileCount = totalFileCount;
	}

	public List<Document> getDocumentlist() {
		return documentlist;
	}

	public void setDocumentlist(List<Document> documentlist) {
		this.documentlist = documentlist;
	}

	@Override
	public String toString() {
		return "PageBean [totalPageCount=" + totalPageCount + ", currentPage=" + currentPage + ", pageSize=" + pageSize
				+ ", totalFileCount=" + totalFileCount + ", documentlist=" + documentlist + "]";
	}
	

}
