package web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**         		用户注销
 *
 */
@WebServlet("/logoutUser")
public class LogoutUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-从session中删除user
		request.getSession().removeAttribute("user");
		
		//2-如果是自动登录时,把客户端的cookie删掉
		Cookie cook_username = new Cookie("cook_username",null);	
		Cookie cook_password = new Cookie("cook_password",null);	
		cook_username.setMaxAge(0); 
		cook_password.setMaxAge(0);	
		cook_username.setPath(request.getContextPath()+"/");   
		cook_password.setPath(request.getContextPath()+"/");
		
		response.addCookie(cook_username);
		response.addCookie(cook_password);		
		
		response.sendRedirect(request.getContextPath()+"/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
