package web.servlet.document;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DocumentService;
import service.Impl.DocumentServiceImpl;

/**   删除文档(异步访问)
 * 
 */
@WebServlet("/deleteFileById")
public class DeleteFileByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-获取要删除的文档的id和地址
		String did = request.getParameter("did");
		String address = request.getParameter("address"); //  /upload/服务器建站.doc
		System.out.println(address);
		boolean icon = true;    //判断json返回成败
		
		//2-调用service层从数据库删除该文档数据
		DocumentService dservice = new DocumentServiceImpl();
		boolean reult  = dservice.deleteFileById(did);
		
		if(reult == false){  //删除失败
			icon = false;
		}else{		
			//3-删除成功,继续从物理文件夹中删除该文件
			File file = new File(address);
			if(!file.exists()){
				icon = false;		  
			}else if(file.isDirectory()){
				icon = false;		 
			}else{
				file.delete();  //删除	
			}	
		}
		
	
		//4-根据标志位返回成败信息
		if(icon == true){  //成功删除
			response.getWriter().write("{\"failInfo\":\"true\"}");  
		}else{    //删除失败
			response.getWriter().write("{\"failInfo\":\"false\"}");  
		}
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
