package online.shenjian.xuefeng.service.impl;

import online.shenjian.xuefeng.model.User;
import online.shenjian.xuefeng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.shenjian.xuefeng.service.UserService;

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
