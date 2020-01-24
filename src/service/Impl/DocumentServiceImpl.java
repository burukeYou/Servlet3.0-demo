package service.Impl;

import java.util.List;

import dao.DocumentDao;
import dao.UserDao;
import dao.Impl.DocumentDaoImpl;
import dao.Impl.UserDaoImpl;
import domain.Document;
import domain.PageBean;
import domain.QueryVo;
import domain.User;
import service.DocumentService;

public class DocumentServiceImpl implements DocumentService {
	//文档操作dao层
	private DocumentDao ddao =  new DocumentDaoImpl();
	private UserDao udao = new UserDaoImpl();
	
	//上传文档
	public void addDocument(List<Document> documentlist) {
		ddao.addDocument(documentlist);
	}

	//查找我的所有文档
	public List<Document> findAllMyDocument(User user) {
		 List<Document> list = ddao.findAllMyDocument(user); 
		 
		 //在每个Document里另外封装User对象
		 for (Document document : list) {
			 document.setUser(user);
		 }	 
		return list;
	}

	//根据id删除文档 
	public boolean deleteFileById(String did) {
		return ddao.deleteFileById(did);
		
	}

	//根据id更改文件名
	public void updateFilename(String did, String newname) {
		ddao.updateFilename(did,newname);
		
	}

	//共享给所有用户
	public void updateShareState(String did,int state) {
		ddao.updateShareState(did,state);	
	}

	//查找所有共享文档
	public PageBean findAllShareDocument(QueryVo queryVo) {
		//1-查询文档总个数      --带条件
		Integer totalFileCount =ddao.getShareTotalCount(queryVo);
	
		//2-查找分页显示的文档	
		List<Document> list = ddao.findShareFileList(queryVo);
		
		//3-
		PageBean pageBean = new PageBean(queryVo.getCurrentPage(), totalFileCount, queryVo.getPageSize());
		pageBean.setDocumentlist(list);
		
		//遍历每个文档的u_id去查找该用户的详细信息
		for (Document document : list) {		 
			User user = udao.findUserByID(document.getU_id());
			document.setUser(user);
		}
		
		return pageBean;
	}


	//查找我的所有文档（带条件）
	public PageBean getPageBean(QueryVo queryVo) {
		//1-查询文档总个数      --带条件
		Integer totalFileCount =ddao.getTotalCount(queryVo);
		//2-查找分页显示的文档	
		List<Document> list = ddao.findFileList(queryVo);
		
		//3-
		PageBean pageBean = new PageBean(queryVo.getCurrentPage(),totalFileCount , queryVo.getPageSize());
		pageBean.setDocumentlist(list);
		
		//4-多表查询获得每个文档上传的用户
		for(Document d : pageBean.getDocumentlist()){
			User user = udao.findUserByID(d.getU_id());
			d.setUser(user);
		}
		
		
		return pageBean;
	}

	
	
	
	
	
}
