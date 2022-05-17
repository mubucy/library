package cn.app.test;

import java.sql.Connection;

public class TestForConn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//测试是否连接成功
		Connection conn=cn.app.conn.DataConnect.getConnection();
		if(conn!=null) {
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
		
	}

}
