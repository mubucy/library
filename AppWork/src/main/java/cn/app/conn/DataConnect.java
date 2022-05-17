package cn.app.conn;

import java.sql.*;

public class DataConnect {
	static {
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("驱动加载成功");//加载成功输出
		    }catch (Exception e) {
		      System.out.print("驱动加载失败"); //加载失败输出
		      e.printStackTrace();
		    }
	}
		//创建数据库链接
	public static Connection getConnection(){
		Connection connect = null;
		    try {
		          connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/app","root","123456");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

		      System.out.println("数据库链接成功");//链接成功输出
		    }catch (Exception e) {
		      System.out.print("数据库连接失败!");
		      e.printStackTrace();
		      //链接失败输出
		    }
		return connect;
	}
	
	//关闭流
	public static void close(ResultSet rs,Statement st,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(st!=null) {
				st.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pst,Connection conn) {
		close(null,pst,conn);
	}
}


