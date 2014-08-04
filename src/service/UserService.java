package service;

import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

import vo.User;

public class UserService {
	@Autowired
	private UserMapper userMapper;	
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public User getUser() {
		return userMapper.getUser("u1");
	}
}
