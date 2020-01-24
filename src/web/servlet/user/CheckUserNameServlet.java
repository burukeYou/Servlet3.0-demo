package web.servlet.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.Impl.UserServiceImpl;

/**     adjx 注册时检查注册用户名是否已经存在
 * 
 */
@WebServlet("/checkUserName")
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-获得客户端json数据
		String username = request.getParameter("username");
		
		//2-
		UserService service = new UserServiceImpl();
		boolean rs = service.checkUsername(username);
	
		//3-把结果返回给jsp客户端
		response.getWriter().write("{\"isExist\":"+rs+"}");  //这里/表转义 {"isExits":"rs"}


		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
