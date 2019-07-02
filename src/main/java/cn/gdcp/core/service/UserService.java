package cn.gdcp.core.service;

import cn.gdcp.core.po.User;

public interface UserService {

	public boolean register(User user) throws Throwable;

	public User login(String username, String password) throws Exception;
    
}
