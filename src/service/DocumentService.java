package service;

import java.util.List;

import domain.Document;
import domain.PageBean;
import domain.QueryVo;
import domain.User;

public interface DocumentService {

	void addDocument(List<Document> documentlist);

	List<Document> findAllMyDocument(User user);

	boolean deleteFileById(String did);

	void updateFilename(String did, String newname);

	void updateShareState(String did,int state);

	PageBean findAllShareDocument(QueryVo queryVo);  

	PageBean getPageBean(QueryVo queryVo);     //查找我的文档

	
}
