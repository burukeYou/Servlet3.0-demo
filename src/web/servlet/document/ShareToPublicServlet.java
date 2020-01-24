package web.servlet.document;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DocumentService;
import service.Impl.DocumentServiceImpl;

/**     共享给所有用户
 *
 */
@WebServlet("/ShareToPublic")
public class ShareToPublicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-获取要共享的文档id
		String did = request.getParameter("did");
		
		//2-调用service层
		DocumentService dservice = new DocumentServiceImpl();
		dservice.updateShareState(did,1);
		
		//3-转发到我的文档页面
		request.getRequestDispatcher("/findAllShareDocument").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
