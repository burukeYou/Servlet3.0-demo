package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**  CP30连接池
 *           
 */
public class MyDataSourceUtils {
	/**  
	 *      创建连接池
	 * 根据外部CP30包创建连接池，再根据CP30.xml配置文件进行配置
	 * 
	 * */
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	
	/**  创建ThreadLocal 
	 *  类似是：key默认为当前线程名字的Map集合
	 *         当我们存进连接(value)进去Map后,所以若线程(key)是一样的则获得的Connection也是一样的
	 * 
	 * */    
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();  
	
	
	// 直接可以获取一个连接池
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	
   
    //从连接池中获得连接
    public static Connection getConnection() throws SQLException{
    	Connection conn = tl.get(); //key自动的默认的， //从ThreadLocal获得当前的连接
    	
    	//若ThreadLocal中没有值,获得新的连接并存到ThreadLocal中
    	if(conn == null){
    		conn = dataSource.getConnection();
    		tl.set(conn);
    	} 	
    	return conn;
    }
    
    
    
    //1-开启事务
    public static void startTransaction() throws SQLException{
    	Connection conn = getConnection();
		if (conn != null) {
			conn.setAutoCommit(false);
		}
    }

    //2-回滚事务
    public static void rollback() throws SQLException{
    	Connection con = getConnection();
		if (con != null) {
			con.rollback();
		}
    }

    //3-提交事务 ,关闭资源及从ThreadLocall中释放
    public static void commit() throws SQLException{
    	Connection conn = getConnection();
    	if(conn != null){
        	conn.commit();   // 事务提交
        	conn.close();    // 关闭资源
        	tl.remove();   // 从线程绑定中移除      	
    	}		
    }
    
 // 关闭资源方法
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
