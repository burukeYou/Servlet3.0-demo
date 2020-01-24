package web.servlet.document;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.FileLoadUtil;

/**         �����ļ�
 * 	
 * 
 */

@WebServlet("/downloadDocument")
public class DownloadDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-��ȡҪ�����ļ���(get��ʽ�ύ����)
		String downPath = request.getParameter("downloadPath");  //�Ҵ����ǵ�ַ 
		String downname = downPath.substring(downPath.lastIndexOf("/")+1, downPath.length()); //��ȡ�����ļ���
		
		//2-Ҫ���ص�����ļ�������    --�ͻ���ͨ��MIMEȥʶ���ļ�������
		response.setContentType(this.getServletContext().getMimeType(downname));  //���ļ���ת���ɶ�Ӧ��MIME����
		
		//3-���߿ͻ��˸��ļ�����ֱ�ӽ��Ͷ����Ը�����ʽ��(����)
		response.setHeader("Content-Disposition","attachment;filename="+downname);
		
		//4-���Ҫ�����ļ��ڷ������ľ���·��
		String path = FileLoadUtil.filePaths+"/" + downname;
		
		//5-��ø��ļ���������
		InputStream is = new FileInputStream(path);
		
		//6-����ļ��������      --ͨ��response�����ͻ��˵������
		ServletOutputStream out = response.getOutputStream();
		
		//7-��ʼ����
		int len = 0;
		byte[] buffer = new byte[1024];
		
		while((len = is.read(buffer)) > 0){
			out.write(buffer,0,len);
		}
		
		is.close();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
