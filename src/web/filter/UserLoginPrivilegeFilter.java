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
 *       ����û��Ƿ��¼������
 *       
 * WebFilterע�ⳣ������:
 *   ����                      ����                     			˵��
	asyncSupported	boolean				ָ��Filter�Ƿ�֧���첽ģʽ
	dispatcherTypes	DispatcherType[]	ָ��Filter�����ַ�ʽ��������й��ˡ�֧�ֵ����ԣ�
										ASYNC��ERROR��FORWARD��INCLUDE��REQUEST��
										Ĭ�Ϲ������з�ʽ������
	filterName	    String		        Filter����
	initParams	 WebInitParam[]			����һЩ����
	displayName		String				Filter��ʾ��
	servletNames	String[]			ָ������ЩServlet���й���
	urlPatterns/value	String[]		��������������ͬ��ָ�����ص�·��

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
	
	//������       --��ȡ��ʼ������
	private FilterConfig config;
	
	//��ʼ��������   
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
