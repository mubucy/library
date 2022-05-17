package cn.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkManageLmpl implements WorkManage {

	@Override
	public boolean SearchWork(String workname) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		//创建链接 Connection对象 Statement对象和ResultSet对象
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		System.out.println("成功11");
		//调用相关方法，连接数据库及处理数据库的查
		//实现 checkLogin登录验证方法
		String sql = "select * from appwork where workname LIKE'%"+workname+"%'";
		
		conn = cn.app.conn.DataConnect.getConnection();
		System.out.println("成功12");
		try {    
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			System.out.println("成功13");
			flag = true;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cn.app.conn.DataConnect.close(rs, st,conn);
		}
		return flag;
	}
}


