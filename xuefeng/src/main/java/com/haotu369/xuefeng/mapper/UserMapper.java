package com.haotu369.xuefeng.mapper;

import com.haotu369.xuefeng.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserMapper {

	/**获取用户信息**/
	//沈健 17.5.15
	User getUser();
}
