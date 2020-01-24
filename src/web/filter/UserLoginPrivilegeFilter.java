package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;

/**
 *       检测用户是否登录过滤器
 *       
 * WebFilter注解常用属性:
 *   属性                      类型                     			说明
	asyncSupported	boolean				指定Filter是否支持异步模式
	dispatcherTypes	DispatcherType[]	指定Filter对哪种方式的请求进行过滤。支持的属性：
										ASYNC、ERROR、FORWARD、INCLUDE、REQUEST；
										默认过滤所有方式的请求
	filterName	    String		        Filter名称
	initParams	 WebInitParam[]			配置一些参数
	displayName		String				Filter显示名
	servletNames	String[]			指定对哪些Servlet进行过滤
	urlPatterns/value	String[]		两个属性作用相同，指定拦截的路径

 *       
 */
@WebFilter(
		filterName="c",
		urlPatterns= {"/findAllMyDocument","/findAllShareDocument"}
		//initParams={
				//@WebInitParam(name = "login", value = "/login"),
				//@WebInitParam(name = "register", value = "/register"),		
		//}
		)
public class UserLoginPrivilegeFilter implements Filter {
	
	//配置类       --获取初始化参数
	private FilterConfig config;
	
	//初始化配置类   
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

		
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest requestH = (HttpServletRequest) request;
		HttpServletResponse responseH =  (HttpServletResponse) response;
		//System.out.println(requestH.getRequestURI()); //    /DSystem2.0/
		
		HttpSession session = requestH.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null){
			responseH.sendRedirect(requestH.getContextPath()+"/error.jsp");
		    return;
		}
	
		chain.doFilter(requestH, responseH);
	}
	

    
    public UserLoginPrivilegeFilter() {
    }

	
	public void destroy() {
		
	}

	

	
	
}
