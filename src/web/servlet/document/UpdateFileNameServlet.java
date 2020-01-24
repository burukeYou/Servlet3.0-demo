package web.servlet.document;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.DocumentService;
import service.Impl.DocumentServiceImpl;

/**		������
 * 
 */
@WebServlet("/updateFileName")
public class UpdateFileNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-��ȡ���������ĵ���id���µ�����
		String did = request.getParameter("did");
		String newname = request.getParameter("newname");
		
		boolean res = true;
		
		if(newname == null){
			return;
		}
		
		
		//3-�����ݿ��ϸ���
		if(res == true){
			DocumentService dservice = new DocumentServiceImpl();
			dservice.updateFilename(did,newname);	
		}

		response.sendRedirect(request.getContextPath()+"/findAllMyDocument");
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
