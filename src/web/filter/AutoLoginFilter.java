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
 * 		自动登录filter
 * 
 *
 */
@WebFilter(filterName="b",urlPatterns="/*")
public class AutoLoginFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//1-先把request,response升级
		HttpServletRequest requestH = (HttpServletRequest) request; 
		HttpServletResponse responseH = (HttpServletResponse)response;
		
		//2-获得请求中的cookie中的用户名和密码
		String username = null;
		String password = null;
		
		//找到存放用户名和密码的cookie
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
		
		//3-自动登录(根据帐号密码去数据库查找用户)
		if(username != null && password != null){
			UserService service = new UserServiceImpl();
			User user = service.login(username);
			
			//4-将登录成功的user对象存到session域中
			requestH.getSession().setAttribute("user", user);	
			
		}
		
		//5-放行
		chain.doFilter(requestH, responseH);
	}

	
	
    public AutoLoginFilter() {
      
    }

	
	public void destroy() {
	
	}

	
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
