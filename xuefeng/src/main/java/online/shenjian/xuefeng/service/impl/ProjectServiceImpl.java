package online.shenjian.xuefeng.service.impl;

import java.util.List;

import online.shenjian.xuefeng.mapper.ProjectMapper;
import online.shenjian.xuefeng.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.shenjian.xuefeng.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
    ProjectMapper projectMapper;
	
	/**获取项目**/
	//沈健6.2
	@Override
	@Cacheable("projectCache")
	public List<Project> getProjectByPageNumSize(int pageNum){
		int pageSize=10;//设置页的大小10
		int totalNum=this.getTotalProjectSize();
		
		if(totalNum == 0){
			return null;
		}
		
		int totalPage=(totalNum / pageSize)+1;
		
		List<Project> project=projectMapper.getProjectByPageNumSize(pageNum, pageSize);
		
		project.get(0).setTotalPage(totalPage);
		
		return  project;
	}
			
	/**查询详细的项目内容**/
	//沈健6.2
	@Override
	public Project getProject(int id){
		projectMapper.updateCount(id);//后续需要优化
		return projectMapper.getProject(id);
	}
	
	/**添加项目**/
	//沈健6.2
	@Override
	@Caching(evict={ 
			@CacheEvict(value="projectCache",allEntries=true),
			@CacheEvict("totalProjectSizeCache")					
	})
	public void addProject(Project project){
		projectMapper.addProject(project);
	}
	
	/**删除项目**/
	//沈健6.2
	@Override
	@Caching(evict={ 
			@CacheEvict(value="projectCache",allEntries=true),
			@CacheEvict("totalProjectSizeCache")					
	})
	public void deleteProject(int id){
		projectMapper.deleteProject(id);
	}

	/**更新项目**/
	//沈健6.2
	@Override
	@CacheEvict(value="projectCache",allEntries=true)
	public void updateProject(Project project){
		projectMapper.updateProject(project);
	}
	
	@Cacheable("totalProjectSizeCache")
	public int getTotalProjectSize(){
		return projectMapper.getTotalProjectSize();
	}
}
