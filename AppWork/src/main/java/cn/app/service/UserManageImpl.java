package cn.app.service;

import cn.app.model.User;
import java.sql.*;

public class UserManageImpl implements UserManage {

	@Override
	public boolean add(User u) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		//创建链接 Connection对象和Statement对象
		Connection conn = null;
		PreparedStatement pst =null;
		
		//调用相关方法，连接数据库及处理数据库的增
		//实现 add注册增添方法
		conn = cn.app.conn.DataConnect.getConnection();
		String sql = "insert into appuser(username,password) values(?,?)";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,u.getName());
			pst.setString(2,u.getPassword());
			int row = pst.executeUpdate();
			if(row>0) {
				flag = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cn.app.conn.DataConnect.close(pst, conn);
		}
		return flag;
	}

	@Override
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		//创建链接 Connection对象 Statement对象和ResultSet对象
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		//调用相关方法，连接数据库及处理数据库的查
		//实现 checkLogin登录验证方法
		String sql = "select * from appuser where username ='"+username+"'";
		conn = cn.app.conn.DataConnect.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			System.out.println("成功2");
			while(rs.next()) {
				if(rs.getString("password").equals(password)) {
					String a = rs.getString("password");
					System.out.println(a);
					System.out.println("成功3");
					flag = true;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cn.app.conn.DataConnect.close(rs, st,conn);
		}
		return flag;
	}
	
	@Override
	public boolean newu(User u,String username){
		// TODO Auto-generated method stub
		
		boolean flag = false;
		//创建链接 Connection对象和Statement对象
		Connection conn = null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		
		//调用相关方法，连接数据库及处理数据库的改
		//实现 修改密码方法
		conn = cn.app.conn.DataConnect.getConnection();
		String sql = "update appuser set password =? where username ='"+username+"'";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,u.getPassword());
			int row = pst.executeUpdate();
			if(row>0) {
				System.out.println("修改成功1");
				flag = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cn.app.conn.DataConnect.close(pst, conn);
		}
		return flag;
	}
}
