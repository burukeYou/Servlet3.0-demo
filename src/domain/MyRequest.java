package domain;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *            ��ǿRequest
 *      
 *      ʵ��������ĳЩ����µ���getParameter()�����Ƕ�get�ύ��ʽ����
 */
public class MyRequest  extends HttpServletRequestWrapper{

	private HttpServletRequest request;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;		
	}
	
	//��д����getParameter����
	public String getParameter(String name){
		String str = request.getParameter(name);
	
		try {
			/**
			 *   ԭ���������: �ͻ������ݰ�GBK����xx,���������յ���xx�� iso8859-1����,
			 *   ���:  XXX�� iso8859������ٰ�utf-8�����ԭ����
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
