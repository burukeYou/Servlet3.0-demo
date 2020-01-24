package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *  文件上传工具类
 *		
 */
public class FileLoadUtil {
	
	//上传文件保存的磁盘路径
	public static  String filePaths;
	
	 //存放每次上传的完整key-文件名(带后缀)和value-文件大小
	public static TreeMap<String, String> fileMap = new TreeMap<>();
	
	static {
		try {
			//1-加载setting配置文件设置上传文件路径
			 Properties pro = new Properties();
			 pro.load(FileLoadUtil.class.getClassLoader().getResourceAsStream("setting.properties"));
			
			 filePaths = (String) pro.get("path");	
			 System.out.println(filePaths);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	
	//不能被创建
	private FileLoadUtil(){}
	
	
	
	//执行上传   参数 path为存储目录，randName实际存储名
	public static void upload(HttpServletRequest request,HttpServletResponse response,String path,String randName) throws Exception, IOException, ServletException{
		//每次上传重置map
		fileMap.clear(); 
		
        //1-获取上传的文件集合
        Collection<Part> parts = request.getParts();
        
        //2-循环处理上传的文件
        for (Part part : parts) {
            //获取请求头，content-disposition请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
            String header = part.getHeader("content-disposition");
            //获取文件名
            String fileName = FileLoadUtil.getFileName(header);       
            if(fileName == null){
            	return;
            }
              	
            fileMap.put(fileName, part.getSize()/1000000.0+"M");
            
            //把文件写到指定路径
            String suffix  =  fileName.substring(fileName.lastIndexOf("."),fileName.length()); //后缀
            part.write(path+File.separator+randName+suffix);
       }   
        
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
	}

	private static String getFileName(String header) {
		   /**
         * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
          * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
         * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
          */
        String[] tempArr1 = header.split(";");
        /**
         *火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
          *IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
          */
          if(tempArr1.length <3){
        	  return null;
          }
          String[] tempArr2 = tempArr1[2].split("=");
		    		    	      
         //获取文件名，兼容各种浏览器的写法	
         String fileName= tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
         return fileName;
		
	}
	

	
	
	


}
