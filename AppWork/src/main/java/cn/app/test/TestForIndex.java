package cn.app.test;

import cn.app.model.User;
import cn.app.service.*;

public class TestForIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�������ע��
		
		UserManage um = new UserManageImpl();
		User u = new User();
		u.setName("�Ŷ�");
		u.setPassword("123456");
		boolean flag = um.add(u);
		if(flag) {
			System.out.println("�ɹ�1");
		}else {
			System.out.println("ʧ��1");
		}
	}

}
