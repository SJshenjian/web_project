package online.shenjian.xuefeng.mapper;

import online.shenjian.xuefeng.model.Visitor;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorMapper {
    
	//写入访客联系信息
	void addContactMeInfo(Visitor visitor);
}
