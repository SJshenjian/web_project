package com.haotu369.xuefeng.service.impl;

import com.haotu369.xuefeng.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haotu369.xuefeng.mapper.UserMapper;
import com.haotu369.xuefeng.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Cacheable("userCache")
	public User getUser() {
		return userMapper.getUser();
	}

}
