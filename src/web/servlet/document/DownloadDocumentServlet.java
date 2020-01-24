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

/**         下载文件
 * 	
 * 
 */

@WebServlet("/downloadDocument")
public class DownloadDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-获取要下载文件名(get方式提交参数)
		String downPath = request.getParameter("downloadPath");  //我传的是地址 
		String downname = downPath.substring(downPath.lastIndexOf("/")+1, downPath.length()); //截取完整文件名
		
		//2-要下载的这个文件的类型    --客户端通过MIME去识别文件的类型
		response.setContentType(this.getServletContext().getMimeType(downname));  //将文件名转换成对应的MIME类型
		
		//3-告诉客户端该文件不是直接解释而是以附件形式打开(下载)
		response.setHeader("Content-Disposition","attachment;filename="+downname);
		
		//4-获得要下载文件在服务器的绝对路径
		String path = FileLoadUtil.filePaths+"/" + downname;
		
		//5-获得该文件的输入流
		InputStream is = new FileInputStream(path);
		
		//6-获得文件的输出流      --通过response获得向客户端的输出流
		ServletOutputStream out = response.getOutputStream();
		
		//7-开始下载
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
