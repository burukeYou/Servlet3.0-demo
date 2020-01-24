package dao;

import java.util.List;

import domain.Document;
import domain.QueryVo;
import domain.User;

public interface DocumentDao {

	void addDocument(List<Document> documentlist);

	List<Document> findAllMyDocument(User user);

	boolean deleteFileById(String did);

	void updateFilename(String did, String newname);

	void updateShareState(String did,int state);

	List<Document> findAllShareDocument();

	Integer getTotalCount(QueryVo queryVo);

	List<Document> findFileList(QueryVo queryVo);

	Integer getShareTotalCount(QueryVo queryVo);

	List<Document> findShareFileList(QueryVo queryVo);

}
