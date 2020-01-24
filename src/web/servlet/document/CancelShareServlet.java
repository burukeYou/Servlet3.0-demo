package web.servlet.document;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.DocumentService;
import service.Impl.DocumentServiceImpl;

/**
 *     取消分享
 */
@WebServlet("/CancelShare")
public class CancelShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String did = request.getParameter("did");
		String sharename = request.getParameter("sharename");
		
		//1-判断当前登录用户和共享的用户名是否相同
		User user = (User) request.getSession().getAttribute("user");
		if(user != null&&user.getUsername().equals(sharename)){		
				//2-调用service层去数据库改变该文档的共享状态
				DocumentService dservice = new DocumentServiceImpl();
				dservice.updateShareState(did, 0);
				response.getWriter().write("{\"failInfo\":\"true\"}");  
			
		}else{
			response.getWriter().write("{\"failInfo\":\"false\"}");  
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
