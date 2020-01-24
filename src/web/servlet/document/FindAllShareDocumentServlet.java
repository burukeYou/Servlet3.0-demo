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
 *        查找所有共享文档
 */
@WebServlet("/findAllShareDocument")
public class FindAllShareDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//封装查询条件
		Map<String, String[]> parameterMap = request.getParameterMap();
	
		QueryVo queryVo = new QueryVo();
		try {
			BeanUtils.populate(queryVo, parameterMap);	
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		} 
		
		System.out.println(queryVo);
		
		//2-调用servie层
		DocumentService dservice = new DocumentServiceImpl();
		PageBean pageBean = dservice.findAllShareDocument(queryVo);
		
		//3-存到域
		request.setAttribute("pageBean", pageBean);
		System.out.println(pageBean);
		
		//4-转发到我的文档页面
		request.getRequestDispatcher("/share.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
