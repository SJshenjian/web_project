package online.shenjian.xuefeng.mapper;

import online.shenjian.xuefeng.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserMapper {

	/**获取用户信息**/
	//沈健 17.5.15
	User getUser();
}
