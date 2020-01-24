package web.servlet.document;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DocumentService;
import service.Impl.DocumentServiceImpl;

/**     ����������û�
 *
 */
@WebServlet("/ShareToPublic")
public class ShareToPublicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-��ȡҪ������ĵ�id
		String did = request.getParameter("did");
		
		//2-����service��
		DocumentService dservice = new DocumentServiceImpl();
		dservice.updateShareState(did,1);
		
		//3-ת�����ҵ��ĵ�ҳ��
		request.getRequestDispatcher("/findAllShareDocument").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
