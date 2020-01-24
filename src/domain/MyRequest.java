package domain;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *            加强Request
 *      
 *      实现让它在某些情况下调用getParameter()方法是对get提交方式处理
 */
public class MyRequest  extends HttpServletRequestWrapper{

	private HttpServletRequest request;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;		
	}
	
	//重写方法getParameter方法
	public String getParameter(String name){
		String str = request.getParameter(name);
	
		try {
			/**
			 *   原来传输过程: 客户端数据按GBK编码xx,服务器接收到后xx查 iso8859-1解码,
			 *   解决:  XXX按 iso8859编码成再按utf-8解码成原数据
			 *   
			 */
			if(str != null)
			str = new String(str.getBytes("iso8859-1"), "UTF-8"); 
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		
		return str;
		
	}
	
	
	
	
	

}
