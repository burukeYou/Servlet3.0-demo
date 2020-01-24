package web.servlet.user;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.User;
import service.UserService;
import service.Impl.UserServiceImpl;

/**
 *          用户注册
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		 request.setCharacterEncoding("utf-8");
			
			Map<String, String[]> registerMap = request.getParameterMap();
			User newuser = new User();
						
			try {
				BeanUtils.populate(newuser, registerMap);  //把表单注册参数封装到实体中
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
						
			//封装uid
			newuser.setUid(UUID.randomUUID().toString());
						
			//调用service层
			UserService service = new UserServiceImpl();
			boolean isRegisterSuccess = service.register(newuser);
			
			//判断是否注册成功
			if(isRegisterSuccess == true){
				response.sendRedirect(request.getContextPath()+"/error.jsp");
			}else{
				response.sendRedirect(request.getContextPath()+"/register.jsp");
			}
			
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
