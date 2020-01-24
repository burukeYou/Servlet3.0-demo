package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import domain.MyRequest;

/**			  ���ȫ�ֲ����ύ����Ĺ�����
 * 	���get,post��ʽ�ύ
 * 
 * 
 * ���ڶ��filter����˳�����⣺ ע������ʱ��FilterName����ĸ˳�����
 * 
 */
@WebFilter(filterName="a",urlPatterns="/*")
public class EncodingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		 //������Ӧ�ı���
		response.setContentType("text/html;charset=UTF-8");  
		
		//1-������request
		HttpServletRequest Hrequest = (HttpServletRequest) request;
		//2-���÷��������ձ���
		String method = Hrequest.getMethod();
		
		
		if(method.equalsIgnoreCase("post")){
			Hrequest.setCharacterEncoding("UTF-8");
			
			//����
			chain.doFilter(Hrequest, response);
		}
		else if(method.equalsIgnoreCase("GET")){
			//����request����
			MyRequest myRequest = new MyRequest(Hrequest); //����request
					
			//����
			chain.doFilter(myRequest, response);
		}
		
	}
	
	
	
	
    public EncodingFilter() {
       
    }

	public void destroy() {
	
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
