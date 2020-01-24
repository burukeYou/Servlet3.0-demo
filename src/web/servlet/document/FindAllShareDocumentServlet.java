package web.servlet.document;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Document;
import domain.PageBean;
import domain.QueryVo;
import domain.User;
import service.DocumentService;
import service.Impl.DocumentServiceImpl;

/**
 *        �������й����ĵ�
 */
@WebServlet("/findAllShareDocument")
public class FindAllShareDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//��װ��ѯ����
		Map<String, String[]> parameterMap = request.getParameterMap();
	
		QueryVo queryVo = new QueryVo();
		try {
			BeanUtils.populate(queryVo, parameterMap);	
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		} 
		
		System.out.println(queryVo);
		
		//2-����servie��
		DocumentService dservice = new DocumentServiceImpl();
		PageBean pageBean = dservice.findAllShareDocument(queryVo);
		
		//3-�浽��
		request.setAttribute("pageBean", pageBean);
		System.out.println(pageBean);
		
		//4-ת�����ҵ��ĵ�ҳ��
		request.getRequestDispatcher("/share.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
