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

/**			  解决全局参数提交乱码的过滤器
 * 	针对get,post方式提交
 * 
 * 
 * 关于多个filter访问顺序问题： 注解配置时按FilterName首字母顺序访问
 * 
 */
@WebFilter(filterName="a",urlPatterns="/*")
public class EncodingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		 //设置响应的编码
		response.setContentType("text/html;charset=UTF-8");  
		
		//1-先升级request
		HttpServletRequest Hrequest = (HttpServletRequest) request;
		//2-设置服务器接收编码
		String method = Hrequest.getMethod();
		
		
		if(method.equalsIgnoreCase("post")){
			Hrequest.setCharacterEncoding("UTF-8");
			
			//放行
			chain.doFilter(Hrequest, response);
		}
		else if(method.equalsIgnoreCase("GET")){
			//升级request即可
			MyRequest myRequest = new MyRequest(Hrequest); //升级request
					
			//放行
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
