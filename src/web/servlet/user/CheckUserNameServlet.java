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

/**     adjx ע��ʱ���ע���û����Ƿ��Ѿ�����
 * 
 */
@WebServlet("/checkUserName")
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-��ÿͻ���json����
		String username = request.getParameter("username");
		
		//2-
		UserService service = new UserServiceImpl();
		boolean rs = service.checkUsername(username);
	
		//3-�ѽ�����ظ�jsp�ͻ���
		response.getWriter().write("{\"isExist\":"+rs+"}");  //����/��ת�� {"isExits":"rs"}


		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
