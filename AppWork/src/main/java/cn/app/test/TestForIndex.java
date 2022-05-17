package cn.app.test;

import cn.app.model.User;
import cn.app.service.*;

public class TestForIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//测试添加注册
		
		UserManage um = new UserManageImpl();
		User u = new User();
		u.setName("张二");
		u.setPassword("123456");
		boolean flag = um.add(u);
		if(flag) {
			System.out.println("成功1");
		}else {
			System.out.println("失败1");
		}
	}

}
