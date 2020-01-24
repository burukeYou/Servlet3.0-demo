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
	//�ĵ�����dao��
	private DocumentDao ddao =  new DocumentDaoImpl();
	private UserDao udao = new UserDaoImpl();
	
	//�ϴ��ĵ�
	public void addDocument(List<Document> documentlist) {
		ddao.addDocument(documentlist);
	}

	//�����ҵ������ĵ�
	public List<Document> findAllMyDocument(User user) {
		 List<Document> list = ddao.findAllMyDocument(user); 
		 
		 //��ÿ��Document�������װUser����
		 for (Document document : list) {
			 document.setUser(user);
		 }	 
		return list;
	}

	//����idɾ���ĵ� 
	public boolean deleteFileById(String did) {
		return ddao.deleteFileById(did);
		
	}

	//����id�����ļ���
	public void updateFilename(String did, String newname) {
		ddao.updateFilename(did,newname);
		
	}

	//����������û�
	public void updateShareState(String did,int state) {
		ddao.updateShareState(did,state);	
	}

	//�������й����ĵ�
	public PageBean findAllShareDocument(QueryVo queryVo) {
		//1-��ѯ�ĵ��ܸ���      --������
		Integer totalFileCount =ddao.getShareTotalCount(queryVo);
	
		//2-���ҷ�ҳ��ʾ���ĵ�	
		List<Document> list = ddao.findShareFileList(queryVo);
		
		//3-
		PageBean pageBean = new PageBean(queryVo.getCurrentPage(), totalFileCount, queryVo.getPageSize());
		pageBean.setDocumentlist(list);
		
		//����ÿ���ĵ���u_idȥ���Ҹ��û�����ϸ��Ϣ
		for (Document document : list) {		 
			User user = udao.findUserByID(document.getU_id());
			document.setUser(user);
		}
		
		return pageBean;
	}


	//�����ҵ������ĵ�����������
	public PageBean getPageBean(QueryVo queryVo) {
		//1-��ѯ�ĵ��ܸ���      --������
		Integer totalFileCount =ddao.getTotalCount(queryVo);
		//2-���ҷ�ҳ��ʾ���ĵ�	
		List<Document> list = ddao.findFileList(queryVo);
		
		//3-
		PageBean pageBean = new PageBean(queryVo.getCurrentPage(),totalFileCount , queryVo.getPageSize());
		pageBean.setDocumentlist(list);
		
		//4-����ѯ���ÿ���ĵ��ϴ����û�
		for(Document d : pageBean.getDocumentlist()){
			User user = udao.findUserByID(d.getU_id());
			d.setUser(user);
		}
		
		
		return pageBean;
	}

	
	
	
	
	
}
