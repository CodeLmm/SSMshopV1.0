package cn.gdcp.core.mapping;

import org.apache.ibatis.annotations.Param;

import cn.gdcp.core.po.User;

public interface UserDao {

	public int register(User user);

	public User login(@Param("username") String username, @Param("password") String password);
    
}
