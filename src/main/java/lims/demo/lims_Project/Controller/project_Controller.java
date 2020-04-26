package lims.demo.lims_Project.Controller;

import lims.demo.Base.SysJson;
import lims.demo.lims_Project.Model.lims_project;
import lims.demo.lims_Project.Service.project_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class project_Controller {

    @Autowired
    private project_service project_service;

    private SysJson sysJson = new SysJson();

    @RequestMapping("/projectList")
    public SysJson projectList(int userId,int pageSize,int pageNow)
    {
        HashMap<String,Object> map = new HashMap<String, Object>();
        List<HashMap<String,Object>> list = new ArrayList<HashMap<String, Object>>();
            list = project_service.projectList(userId,pageSize,pageNow);
            int countList = project_service.countList(userId);
            sysJson.setStatus(true);
            sysJson.setMessage("查询成功");
            map.put("list",list);
            map.put("countList",countList);
            sysJson.setResult(map);

        if(userId==0)
        {
            sysJson.setStatus(false);
            sysJson.setMessage("查询失败");

        }
        return sysJson;
    }

    @RequestMapping("/insertProject/{userId}")
    public SysJson insertProject(lims_project limsProject,@PathVariable("userId") int userId)
    {
        boolean b=false;
        if(limsProject!=null){
             b=project_service.insertProject(limsProject);
            if(b){
                String name= limsProject.getName();
                String describe = limsProject.getProject_describe();
                b  = project_service.insertApproval(name,describe);
                int projectId = project_service.descProjectId();
                b = project_service.insertProjectUser(projectId,userId);
                sysJson.setMessage("插入成功");
            }else{
                sysJson.setMessage("插入失败");
            }

        }
        sysJson.setStatus(b);
        return sysJson;
    }
}
