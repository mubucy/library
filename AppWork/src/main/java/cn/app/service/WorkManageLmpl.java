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
		
		//�������� Connection���� Statement�����ResultSet����
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		System.out.println("�ɹ�11");
		//������ط������������ݿ⼰�������ݿ�Ĳ�
		//ʵ�� checkLogin��¼��֤����
		String sql = "select * from appwork where workname LIKE'%"+workname+"%'";
		
		conn = cn.app.conn.DataConnect.getConnection();
		System.out.println("�ɹ�12");
		try {    
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			System.out.println("�ɹ�13");
			flag = true;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cn.app.conn.DataConnect.close(rs, st,conn);
		}
		return flag;
	}
}


