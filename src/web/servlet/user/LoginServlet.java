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
 * 		�û���¼
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//1
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				//2-����service������û�
				UserService service = new UserServiceImpl();
				User user = service.login(username);
				if(user == null){
					//��¼ʧ��
					request.setAttribute("loginError", "���û���������!");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else if(!user.getPassword().equals(password)){
					//��¼ʧ��
					request.setAttribute("loginError", "�������!");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else{
					//��¼�ɹ�
					/**  
					 *       �û��Ƿ�ѡ�Զ���¼
					 */
					
					String autoLogin = request.getParameter("autoLogin");
					if(autoLogin!= null){
						//�Ѹ��û�����������浽cookie��
						Cookie cook_username = new Cookie("cook_username", user.getUsername());
						Cookie cook_password = new Cookie("cook_password",user.getPassword());
						
						//����cookie�־û�ʱ��(����һСʱ)
						cook_username.setMaxAge(60*60);   
						cook_password.setMaxAge(60*60);
						
						//����cookie����Ч·������ô������ڷ��ʡ�·�����µ�web��Դʱ�������cookie
						cook_username.setPath(request.getContextPath()+"/");   
						cook_password.setPath(request.getContextPath()+"/");
						
						//���ͻ������cookie,
						response.addCookie(cook_username);
						response.addCookie(cook_password);				
					}
					
				
					request.getSession().setAttribute("user", user);  //��session�����û�			
					response.sendRedirect(request.getContextPath()+"/");	
				}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
