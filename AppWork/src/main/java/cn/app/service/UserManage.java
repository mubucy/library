package cn.app.service;

import cn.app.model.User;

public interface UserManage {

	public boolean add(User u);//ע��
	public boolean checkLogin(String username,String password);//��¼
	public boolean newu(User u,String username);//�޸�����
}
