package cn.app.conn;

import java.sql.*;

public class DataConnect {
	static {
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("�������سɹ�");//���سɹ����
		    }catch (Exception e) {
		      System.out.print("��������ʧ��"); //����ʧ�����
		      e.printStackTrace();
		    }
	}
		//�������ݿ�����
	public static Connection getConnection(){
		Connection connect = null;
		    try {
		          connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/app","root","123456");
		           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

		      System.out.println("���ݿ����ӳɹ�");//���ӳɹ����
		    }catch (Exception e) {
		      System.out.print("���ݿ�����ʧ��!");
		      e.printStackTrace();
		      //����ʧ�����
		    }
		return connect;
	}
	
	//�ر���
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


