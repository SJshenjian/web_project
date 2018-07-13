package com.haotu369.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.haotu369.model.Project;
import com.haotu369.service.ProjectService;
import com.haotu369.util.file.FileUtil;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	/**获取项目列表(客户端)**/
	//沈健6.2
	@RequestMapping("/project")
	public String project(@RequestParam(value="pageNum",defaultValue="1") int pageNum,Model model){
		List<Project> projects=projectService.getProjectByPageNumSize(pageNum);
		model.addAttribute("projects",projects);
		return "project";
	}
	
	/**查询详细的项目内容（客户端）**/
	//沈健6.2
	@RequestMapping("/detail")
	public String getProject(int id,Model model){
		Project project=projectService.getProject(id);
		model.addAttribute("project",project);
		return "project_detail";
	}
	
	/**添加项目视图获取**/
	//沈健6.2
	@RequestMapping("/add")
	public String addProject(){
		return "project_add";
	}	
	
	/**保存项目**/
	//沈健6.3
	@RequestMapping("/save")
	public String saveProject(Project project,@RequestParam("imgFile")MultipartFile imgFile,HttpServletRequest request){
		String img=FileUtil.saveFile(request, imgFile, "项目背景");
        project.setImg(img);
        
		projectService.addProject(project);
		return "redirect:/project/list";
	}
	
	/**获取项目列表(管理端)**/
	//沈健6.2
	@RequestMapping("/list")
	public String getProjectList(@RequestParam(value="pageNum",defaultValue="1") int pageNum,Model model){
		List<Project> projects=projectService.getProjectByPageNumSize(pageNum);
		model.addAttribute("projects",projects);
		return "project_list";
	}
	
	/**删除项目**/
	//沈健6.2
	@RequestMapping("/delete")
	public String deleteProject(int id){
		projectService.deleteProject(id);
		return "redirect:/project/list";
	}
	
	/**修改项目**/
	//沈健6.2
	@RequestMapping("/modify")
	public String modifyProject(int id,Model model){
		Project project=projectService.getProject(id);
		model.addAttribute("project",project);
		return "project_modify";
	}
	
	/**更新项目**/
	//沈健6.2
	@RequestMapping("/update")
	public String updateProject(Project project,Model model){
		projectService.updateProject(project);
		return "redirect:/project/list";
	}
}
