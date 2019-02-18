package online.shenjian.xuefeng.mapper;

import java.util.List;

import online.shenjian.xuefeng.model.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMapper {
    
	/**获取项目**/
	List<Project> getProjectByPageNumSize(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
		
	/**查询项目总共数量**/
	int getTotalProjectSize();
	
	/**查询详细的项目内容**/
	Project getProject(int id);
	
	/**更新项目浏览量, pv(浏览1次加1次) 非 uv(单一用户即使浏览10次也只加1)**/
	void updateCount(int id);

	/**添加项目**/
	void addProject(Project project);
	
	/**删除项目**/
	void deleteProject(int id);

	/**更新项目**/
	void updateProject(Project project);
	
}
