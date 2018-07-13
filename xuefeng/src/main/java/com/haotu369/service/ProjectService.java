package com.haotu369.service;

import java.util.List;

import com.haotu369.model.Project;

public interface ProjectService {

	/**获取项目**/
	//沈健6.2
	List<Project> getProjectByPageNumSize(int pageNum);	
	
	/**查询详细的项目内容**/
	//沈健6.2
	Project getProject(int id);

	/**添加项目**/
	//沈健6.2
	void addProject(Project project);
	
	/**删除项目**/
	//沈健6.2
	void deleteProject(int id);

	/**更新项目**/
	//沈健6.2
	void updateProject(Project project);
}
