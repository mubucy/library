package cn.app.test;

import java.sql.Connection;

public class TestForConn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�����Ƿ����ӳɹ�
		Connection conn=cn.app.conn.DataConnect.getConnection();
		if(conn!=null) {
			System.out.println("�ɹ�");
		}else {
			System.out.println("ʧ��");
		}
		
	}

}
