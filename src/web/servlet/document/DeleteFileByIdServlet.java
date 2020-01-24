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

/**   ɾ���ĵ�(�첽����)
 * 
 */
@WebServlet("/deleteFileById")
public class DeleteFileByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-��ȡҪɾ�����ĵ���id�͵�ַ
		String did = request.getParameter("did");
		String address = request.getParameter("address"); //  /upload/��������վ.doc
		System.out.println(address);
		boolean icon = true;    //�ж�json���سɰ�
		
		//2-����service������ݿ�ɾ�����ĵ�����
		DocumentService dservice = new DocumentServiceImpl();
		boolean reult  = dservice.deleteFileById(did);
		
		if(reult == false){  //ɾ��ʧ��
			icon = false;
		}else{		
			//3-ɾ���ɹ�,�����������ļ�����ɾ�����ļ�
			File file = new File(address);
			if(!file.exists()){
				icon = false;		  
			}else if(file.isDirectory()){
				icon = false;		 
			}else{
				file.delete();  //ɾ��	
			}	
		}
		
	
		//4-���ݱ�־λ���سɰ���Ϣ
		if(icon == true){  //�ɹ�ɾ��
			response.getWriter().write("{\"failInfo\":\"true\"}");  
		}else{    //ɾ��ʧ��
			response.getWriter().write("{\"failInfo\":\"false\"}");  
		}
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
