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
 *  �ļ��ϴ�������
 *		
 */
public class FileLoadUtil {
	
	//�ϴ��ļ�����Ĵ���·��
	public static  String filePaths;
	
	 //���ÿ���ϴ�������key-�ļ���(����׺)��value-�ļ���С
	public static TreeMap<String, String> fileMap = new TreeMap<>();
	
	static {
		try {
			//1-����setting�����ļ������ϴ��ļ�·��
			 Properties pro = new Properties();
			 pro.load(FileLoadUtil.class.getClassLoader().getResourceAsStream("setting.properties"));
			
			 filePaths = (String) pro.get("path");	
			 System.out.println(filePaths);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	
	//���ܱ�����
	private FileLoadUtil(){}
	
	
	
	//ִ���ϴ�   ���� pathΪ�洢Ŀ¼��randNameʵ�ʴ洢��
	public static void upload(HttpServletRequest request,HttpServletResponse response,String path,String randName) throws Exception, IOException, ServletException{
		//ÿ���ϴ�����map
		fileMap.clear(); 
		
        //1-��ȡ�ϴ����ļ�����
        Collection<Part> parts = request.getParts();
        
        //2-ѭ�������ϴ����ļ�
        for (Part part : parts) {
            //��ȡ����ͷ��content-disposition����ͷ�ĸ�ʽ��form-data; name="file"; filename="snmp4j--api.zip"
            String header = part.getHeader("content-disposition");
            //��ȡ�ļ���
            String fileName = FileLoadUtil.getFileName(header);       
            if(fileName == null){
            	return;
            }
              	
            fileMap.put(fileName, part.getSize()/1000000.0+"M");
            
            //���ļ�д��ָ��·��
            String suffix  =  fileName.substring(fileName.lastIndexOf("."),fileName.length()); //��׺
            part.write(path+File.separator+randName+suffix);
       }   
        
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
	}

	private static String getFileName(String header) {
		   /**
         * String[] tempArr1 = header.split(";");����ִ����֮���ڲ�ͬ��������£�tempArr1���������������������
          * �������google������£�tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
         * IE������£�tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
          */
        String[] tempArr1 = header.split(";");
        /**
         *�������google������£�tempArr2={filename,"snmp4j--api.zip"}
          *IE������£�tempArr2={filename,"E:\snmp4j--api.zip"}
          */
          if(tempArr1.length <3){
        	  return null;
          }
          String[] tempArr2 = tempArr1[2].split("=");
		    		    	      
         //��ȡ�ļ��������ݸ����������д��	
         String fileName= tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
         return fileName;
		
	}
	

	
	
	


}
