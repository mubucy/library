package cn.app.service;

import cn.app.model.User;

public interface UserManage {

	public boolean add(User u);//×¢²á
	public boolean checkLogin(String username,String password);//µÇÂ¼
	public boolean newu(User u,String username);//ĞŞ¸ÄÃÜÂë
}
