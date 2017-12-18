package cn.itcast.core.dao;

import org.springframework.stereotype.Repository;

import cn.itcast.core.pojo.User;

@Repository
public interface UserDao {
	
	void saveUser(User user);

}
