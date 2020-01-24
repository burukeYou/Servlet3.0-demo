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
 *          �û�ע��
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		 request.setCharacterEncoding("utf-8");
			
			Map<String, String[]> registerMap = request.getParameterMap();
			User newuser = new User();
						
			try {
				BeanUtils.populate(newuser, registerMap);  //�ѱ�ע�������װ��ʵ����
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
						
			//��װuid
			newuser.setUid(UUID.randomUUID().toString());
						
			//����service��
			UserService service = new UserServiceImpl();
			boolean isRegisterSuccess = service.register(newuser);
			
			//�ж��Ƿ�ע��ɹ�
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
