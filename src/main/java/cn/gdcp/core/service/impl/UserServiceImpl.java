package cn.gdcp.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gdcp.core.mapping.UserDao;
import cn.gdcp.core.po.User;
import cn.gdcp.core.service.UserService;
import util.Md5Util;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDao userDao;
	@Override
	public boolean register(User user) throws Throwable {
		String passwordMd5= Md5Util.encodeByMd5(user.getPassword());
		user.setPassword(passwordMd5);
		int num = this.userDao.register(user);
		return num>0?true:false;
	}
	@Override
	public User login(String username, String passwordBase) throws Exception {
		String password= Md5Util.encodeByMd5(passwordBase);
		System.out.println(username+password);
		User user = this.userDao.login(username, password);
		return user;
	}

}
