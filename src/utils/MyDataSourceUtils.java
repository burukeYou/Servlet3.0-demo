package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**  CP30���ӳ�
 *           
 */
public class MyDataSourceUtils {
	/**  
	 *      �������ӳ�
	 * �����ⲿCP30���������ӳأ��ٸ���CP30.xml�����ļ���������
	 * 
	 * */
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	
	/**  ����ThreadLocal 
	 *  �����ǣ�keyĬ��Ϊ��ǰ�߳����ֵ�Map����
	 *         �����Ǵ������(value)��ȥMap��,�������߳�(key)��һ�������õ�ConnectionҲ��һ����
	 * 
	 * */    
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();  
	
	
	// ֱ�ӿ��Ի�ȡһ�����ӳ�
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	
   
    //�����ӳ��л������
    public static Connection getConnection() throws SQLException{
    	Connection conn = tl.get(); //key�Զ���Ĭ�ϵģ� //��ThreadLocal��õ�ǰ������
    	
    	//��ThreadLocal��û��ֵ,����µ����Ӳ��浽ThreadLocal��
    	if(conn == null){
    		conn = dataSource.getConnection();
    		tl.set(conn);
    	} 	
    	return conn;
    }
    
    
    
    //1-��������
    public static void startTransaction() throws SQLException{
    	Connection conn = getConnection();
		if (conn != null) {
			conn.setAutoCommit(false);
		}
    }

    //2-�ع�����
    public static void rollback() throws SQLException{
    	Connection con = getConnection();
		if (con != null) {
			con.rollback();
		}
    }

    //3-�ύ���� ,�ر���Դ����ThreadLocall���ͷ�
    public static void commit() throws SQLException{
    	Connection conn = getConnection();
    	if(conn != null){
        	conn.commit();   // �����ύ
        	conn.close();    // �ر���Դ
        	tl.remove();   // ���̰߳����Ƴ�      	
    	}		
    }
    
 // �ر���Դ����
 	public static void closeConnection() throws SQLException {
 		Connection con = getConnection();
 		if (con != null) {
 			con.close();
 		}
 	}

 	public static void closeStatement(Statement st) throws SQLException {
 		if (st != null) {
 			st.close();
 		}
 	}

 	public static void closeResultSet(ResultSet rs) throws SQLException {
 		if (rs != null) {
 			rs.close();
 		}
 	}
    
    
    
    
    
    
    
    
    
    
    
}
