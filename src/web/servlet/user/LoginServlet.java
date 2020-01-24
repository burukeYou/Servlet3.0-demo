package web.servlet.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;
import service.Impl.UserServiceImpl;



/**
 * 		用户登录
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//1
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				//2-调用service层查找用户
				UserService service = new UserServiceImpl();
				User user = service.login(username);
				if(user == null){
					//登录失败
					request.setAttribute("loginError", "该用户名不存在!");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else if(!user.getPassword().equals(password)){
					//登录失败
					request.setAttribute("loginError", "密码错误!");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else{
					//登录成功
					/**  
					 *       用户是否勾选自动登录
					 */
					
					String autoLogin = request.getParameter("autoLogin");
					if(autoLogin!= null){
						//把该用户的名字密码存到cookie中
						Cookie cook_username = new Cookie("cook_username", user.getUsername());
						Cookie cook_password = new Cookie("cook_password",user.getPassword());
						
						//设置cookie持久化时间(这里一小时)
						cook_username.setMaxAge(60*60);   
						cook_password.setMaxAge(60*60);
						
						//设置cookie的有效路径，那么浏览器在访问“路径”下的web资源时都会带上cookie
						cook_username.setPath(request.getContextPath()+"/");   
						cook_password.setPath(request.getContextPath()+"/");
						
						//给客户端添加cookie,
						response.addCookie(cook_username);
						response.addCookie(cook_password);				
					}
					
				
					request.getSession().setAttribute("user", user);  //在session域存放用户			
					response.sendRedirect(request.getContextPath()+"/");	
				}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
