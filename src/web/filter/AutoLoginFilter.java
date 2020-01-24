package web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;
import service.Impl.UserServiceImpl;

/**
 * 		�Զ���¼filter
 * 
 *
 */
@WebFilter(filterName="b",urlPatterns="/*")
public class AutoLoginFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//1-�Ȱ�request,response����
		HttpServletRequest requestH = (HttpServletRequest) request; 
		HttpServletResponse responseH = (HttpServletResponse)response;
		
		//2-��������е�cookie�е��û���������
		String username = null;
		String password = null;
		
		//�ҵ�����û����������cookie
		Cookie[] cookies = requestH.getCookies();
		if(cookies != null){
			for(Cookie e : cookies){
				if(e.getName().equals("cook_username")){
					username = e.getValue();
				}
			    if(e.getName().equals("cook_password")){
			    	password = e.getValue();
			    }
			}
		}
		
		//3-�Զ���¼(�����ʺ�����ȥ���ݿ�����û�)
		if(username != null && password != null){
			UserService service = new UserServiceImpl();
			User user = service.login(username);
			
			//4-����¼�ɹ���user����浽session����
			requestH.getSession().setAttribute("user", user);	
			
		}
		
		//5-����
		chain.doFilter(requestH, responseH);
	}

	
	
    public AutoLoginFilter() {
      
    }

	
	public void destroy() {
	
	}

	
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
