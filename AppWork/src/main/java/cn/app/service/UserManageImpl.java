package cn.app.service;

import cn.app.model.User;
import java.sql.*;

public class UserManageImpl implements UserManage {

	@Override
	public boolean add(User u) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		//�������� Connection�����Statement����
		Connection conn = null;
		PreparedStatement pst =null;
		
		//������ط������������ݿ⼰�������ݿ����
		//ʵ�� addע��������
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
		//�������� Connection���� Statement�����ResultSet����
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		//������ط������������ݿ⼰�������ݿ�Ĳ�
		//ʵ�� checkLogin��¼��֤����
		String sql = "select * from appuser where username ='"+username+"'";
		conn = cn.app.conn.DataConnect.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			System.out.println("�ɹ�2");
			while(rs.next()) {
				if(rs.getString("password").equals(password)) {
					String a = rs.getString("password");
					System.out.println(a);
					System.out.println("�ɹ�3");
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
		//�������� Connection�����Statement����
		Connection conn = null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		
		//������ط������������ݿ⼰�������ݿ�ĸ�
		//ʵ�� �޸����뷽��
		conn = cn.app.conn.DataConnect.getConnection();
		String sql = "update appuser set password =? where username ='"+username+"'";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,u.getPassword());
			int row = pst.executeUpdate();
			if(row>0) {
				System.out.println("�޸ĳɹ�1");
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
