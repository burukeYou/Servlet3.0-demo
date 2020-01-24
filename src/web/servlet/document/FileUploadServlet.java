package web.servlet.document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;

import domain.Document;
import domain.User;
import service.DocumentService;
import service.Impl.DocumentServiceImpl;
import utils.FileLoadUtil;

/**           文件上传
 * MultipartConfig注解可以带有以下属性，这些全部是可选的：
        maxFileSize：表示最多可上传的文件容量。超过设定值的文件将会遭到拒绝。
					 maxFileSize 的默认值为-1，表示不受限制。
        maxRequestSize：表示允许多部分http请求的最大容量。它的默认值为-1，表示它是不受限制的。
        location：将上传的文件保存到磁盘中的指定位置，调用Part 中的write 方法将用到它。
        fileSizeThreshold：设定一个溢出尺寸，超过这个值之后，上传的文件将被写入磁盘。

        在一个由多部分组成的请求中，每一个表单域，包括非文本域，都会被转换成一个Part。

注意： 1)文件上传后的路径是在Tomcat下所以ecplise没有所以同步到tomcat时会清空
	  2) 上传前先判断用户是否登录否则无法上传
	  3)鉴于所有文件存放在一个文件夹下实际存储地址名随机产生
	  

 */
@WebServlet("/fileUpload")
@MultipartConfig()   
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
           //2-传入文件上传路径开始上传,并封装该文档对象保存到数据库   	
		   String path = FileLoadUtil.filePaths;
           List<Document> documentlist = new ArrayList<>();  //存储所有的上传文档
			try {
				String randName = UUID.randomUUID().toString(); //随机生成的文件名
				FileLoadUtil.upload(request, response, path,randName);
					 
			   for(Entry<String, String> e: FileLoadUtil.fileMap.entrySet()){
				      String filename = e.getKey();
				      String filesize = e.getValue();
				    
				       //根据每个文件名获取后缀					
					   String prefix = filename.substring(0,filename.lastIndexOf("."));  //获取文件名前缀
					   String suffix = filename.substring(filename.lastIndexOf("."),filename.length());	//获取文件名后缀		
					  
					   Document document = new Document();
					   document.setDname(prefix);
					   document.setDtype(suffix);
					   document.setFilesize(filesize);
					   document.setAddress(path+"/"+randName+suffix); //保存文件存放路径
					   document.setDid(UUID.randomUUID().toString());
					   document.setIsShare(0);
					   document.setIsGarbage(0);
					   document.setUploadTime(new Date());  
					   document.setUser((User)request.getSession().getAttribute("user")); //上传用户
					   documentlist.add(document);
					 			    
			   }
			} catch (Exception e1) {	
				e1.printStackTrace();
			} 
				
			//3-调用service层处理
			DocumentService dservice = new DocumentServiceImpl();
			dservice.addDocument(documentlist);
		
			
			//4-
			//response.sendRedirect(request.getContextPath()+"/admin/mydocument/list.jsp");
			response.getWriter().write("xx"); 						
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
