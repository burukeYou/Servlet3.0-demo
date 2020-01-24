package domain;

import java.util.List;

/**
 * 	��ҳ��ѯ���ؽ��
 * 
 * 
 */
public class PageBean {
	
	//��ҳ��
	private Integer totalPageCount;
	
	//��ǰҳ
	private Integer currentPage;
	
	//ÿҳ��ʾ����
	private Integer pageSize;
	
	//�ļ��ܸ���
	private Integer totalFileCount;
	
	//��ʾ���ĵ�
	private List<Document> documentlist;
		
	//------------------------------------------------------------------
	public PageBean() {
	}
	
	public PageBean(Integer currentPage,Integer totalFileCount,Integer pageSize){
		this.currentPage = currentPage;
		this.totalFileCount = totalFileCount;
		this.pageSize = pageSize;
		
		//������ҳ��      --������ȡ��      --10 / 3 -->4ҳ
		this.totalPageCount = (totalFileCount + pageSize-1)/pageSize;
		

		//�жϵ�ǰҳ�Ƿ�Ϸ�
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
