package dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.DocumentDao;
import domain.Document;
import domain.QueryVo;
import domain.User;
import utils.MyDataSourceUtils;


public class DocumentDaoImpl implements DocumentDao {

	//上传文件
	public void addDocument(List<Document> documentlist){
		QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
		String sql = "insert into document values(?,?,?,?,?,?,?,?,?)";
		
		try {			
				 for(Document document : documentlist) {
					 	runner.update(sql,document.getDid(),document.getDname(),document.getUploadTime(),
							document.getDtype(),document.getAddress(),document.getIsShare(),
							document.getIsGarbage(),document.getUser().getUid(),document.getFilesize());
				 }
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	//查找某个用户的某一个文档	
	public List<Document> findAllMyDocument(User user) {
		QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
		String sql = "select* from document where u_id=?";
		List<Document> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Document>(Document.class),user.getUid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}

	//根据id删除文档
	public boolean deleteFileById(String did) {
		QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
		String sql = "delete from document where did=?";
		try {
			runner.update(sql,did);
			return true;    //删除成功
		} catch (SQLException e) {          
			return false;    //s删除失败
		}
	}

	
	//根据id更改文件名
	public void updateFilename(String did, String newname) {
		QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
		String sql = "update document set dname=? where did=?";
		try {
			runner.update(sql,newname,did);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//改变文档的状态
	public void updateShareState(String did,int state) {
		QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
		String sql = "update document set isShare=? where did=?";
		try {
			runner.update(sql,state,did);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//查找所有共享文档
	public List<Document> findAllShareDocument() {
		QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
		String sql = "select* from document where isShare=?";
		List<Document> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Document>(Document.class), 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}

	//根据文件名，文件类型模糊搜索
	public List<Document> findDocumentByCondition(User user, String filename, String filetype) {
		 QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
		 String sql = "select* from document where u_id = ?";
		 List<String> arr = new ArrayList<String>(); //犹豫搜索的参数不确定
		 arr.add(user.getUid()); //先把第一个参数添加进去
		
		 if(filename!= null && !filename.trim().equals("")){
			 //给sql拼接条件
			 sql += " and dname like ?"; //注意and前面拼接时要有空格
			 arr.add("%"+filename+"%");
		 }
		 if(filetype!= null && !filetype.trim().equals("")){
			 sql += " and dtype = ?";	
			 arr.add(filetype.trim());			
		 }
		
		 
		List<Document> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Document>(Document.class),arr.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;	
	}

	//
	public Integer getTotalCount(QueryVo queryVo) {
		String filename = queryVo.getFilename();
		String filetype = queryVo.getFiletype();
		String u_id = queryVo.getUser().getUid();  
		
		try {
			 QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
			 String sql = "select count(*) from document where u_id = ?";
			 
			 List arr = new ArrayList(); //犹豫搜索的参数不确定
			 arr.add(u_id); //先把第一个参数添加进去
			
			 if(filename!= null && !filename.trim().equals("")){
				 //给sql拼接条件
				 sql += " and dname like ?"; //注意and前面拼接时要有空格
				 arr.add("%"+filename+"%");
			 }
			 if(filetype!= null && !filetype.trim().equals("")){
				 sql += " and dtype = ?";	
				 arr.add(filetype.trim());			
			 }
			 
		 		 
			 Long count = (Long)runner.query(sql, new ScalarHandler(),arr.toArray());
			 return count.intValue();
			 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}

	//分页条件查询： 我的文档
	public List<Document> findFileList(QueryVo queryVo) {
		String u_id = queryVo.getUser().getUid();   //当前用户id
		int StartRow = (queryVo.getCurrentPage()-1)*queryVo.getPageSize(); //limit查询起始索引
		Integer pageSize = queryVo.getPageSize(); 
		String filename = queryVo.getFilename();
		String filetype = queryVo.getFiletype();
				
		try {
			 	QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
			 	String sql = "select * from document where u_id=? ";
			 	
			 	//
			 	List arr = new ArrayList(); //犹豫搜索的参数不确定
				 arr.add(u_id); //先把第一个参数添加进去
				
				 if(filename!= null && !filename.trim().equals("")){
					 //给sql拼接条件
					 sql += " and dname like ?"; //注意and前面拼接时要有空格
					 arr.add("%"+filename+"%");
				 }
				 if(filetype!= null && !filetype.trim().equals("")){
					 sql += " and dtype = ?";	
					 arr.add(filetype.trim());			
				 }
				 
			 	
				 //
				 sql += " limit ?,? ";
				 arr.add(StartRow);
				 arr.add(pageSize);
				 
				 System.out.println(sql);
				 System.out.println(arr);
			 	
				List<Document> list = runner.query(sql, 
						new BeanListHandler<Document>(Document.class),arr.toArray());
				return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

	   
	
	   //分页条件查询： share文档
		public Integer getShareTotalCount(QueryVo queryVo) {
			String filename = queryVo.getFilename();
			String filetype = queryVo.getFiletype();
				
			try {
				 QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
				 String sql = "select count(*) from document where isShare = 1";
				 
				 List arr = new ArrayList(); //犹豫搜索的参数不确定
				
				 if(filename!= null && !filename.trim().equals("")){
					 //给sql拼接条件
					 sql += " and dname like ?"; //注意and前面拼接时要有空格
					 arr.add("%"+filename+"%");
				 }
				 if(filetype!= null && !filetype.trim().equals("")){
					 sql += " and dtype = ?";	
					 arr.add(filetype.trim());			
				 }
				 
			 		 
				 Long count = (Long)runner.query(sql, new ScalarHandler(),arr.toArray());
				 return count.intValue();
				 
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}		
		}

		public List<Document> findShareFileList(QueryVo queryVo) {
			int StartRow = (queryVo.getCurrentPage()-1)*queryVo.getPageSize(); //limit查询起始索引
			Integer pageSize = queryVo.getPageSize(); 
			String filename = queryVo.getFilename();
			String filetype = queryVo.getFiletype();
					
			try {
				 	QueryRunner runner = new QueryRunner(MyDataSourceUtils.getDataSource());
				 	String sql = "select * from document where isShare=1 ";
				 	
				 	//
				 	List arr = new ArrayList(); //犹豫搜索的参数不确定
					
					 if(filename!= null && !filename.trim().equals("")){
						 //给sql拼接条件
						 sql += " and dname like ?"; //注意and前面拼接时要有空格
						 arr.add("%"+filename+"%");
					 }
					 if(filetype!= null && !filetype.trim().equals("")){
						 sql += " and dtype = ?";	
						 arr.add(filetype.trim());			
					 }
					 
				 	
					 //
					 sql += " limit ?,? ";
					 arr.add(StartRow);
					 arr.add(pageSize);
					 
					 System.out.println(sql);
					 System.out.println(arr);
				 	
					List<Document> list = runner.query(sql, 
							new BeanListHandler<Document>(Document.class),arr.toArray());
					return list;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}	
		}


		
		
	
	
}
