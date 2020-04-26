package lims.demo.lims_Project.Service;

import lims.demo.lims_Project.Mapper.project_mapper;
import lims.demo.lims_Project.Model.lims_project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class project_service {

    @Autowired
    private project_mapper project_mapper;


    public List<HashMap<String,Object>> projectList(int user_Id,int pageSize,int pageNow)
    {
        pageNow = (pageNow-1)*pageSize;

        List<HashMap<String,Object>> map = user_Id!=-1? project_mapper.projectUsersList(user_Id,pageSize,pageNow):project_mapper.adminProjetList(pageSize, pageNow);
        return map;
    }

    public  int countList(int user_Id)
    {
        return user_Id==-1? project_mapper.adminCountProject():project_mapper.countProject(user_Id);
    }

    public boolean insertProject(lims_project project)
    {
        boolean b =false;
        b=project_mapper.insertProject(project);
        return b;
    }

    public boolean insertApproval(String name,String descirbe)
    {
        boolean b =false;
        b=project_mapper.insertApproval(name, descirbe);
        return b;
    }

    public boolean insertProjectUser(int projectId,int userId){
        return project_mapper.insertProjectUser(projectId, userId);
    }

    public int descProjectId()
    {
        return project_mapper.descProjectId();
    }

}
