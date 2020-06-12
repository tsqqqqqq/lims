package lims.demo.lims_Project.Mapper;


import lims.demo.lims_Project.Model.lims_project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface project_mapper {

    /**
     * 管理员查询所有项目列表
     * @param pageSize
     * @param pageNow
     * @return
     */
    @Select("select p.* ,u.name from lims_project p inner join lims_project_user pu on p.project_id=pu.project_id" +
            " inner join lims_user_message u on pu.user_id = u.users_id " +
            "limit #{pageNow},#{pageSize}")
    public List<HashMap<String,Object>> projectList(int pageSize,int pageNow);


    /**
     * 非管理员登陆只可看到自己得项目列表
     * @param user_id
     * @param pageSize
     * @param pageNow
     * @return
     */
    @Select("select p.* ,u.lims_user_message_name from lims_project p inner join lims_project_user pu on p.project_id=pu.project_id" +
            " inner join lims_user_message u on pu.user_id = u.users_id " +
            "   where u.users_id = #{user_id} limit #{pageNow},#{pageSize}" )
    public List<HashMap<String,Object>> projectUsersList(int user_id, int pageSize, int pageNow);

    @Select("select p.* ,u.lims_user_message_name from lims_project p inner join lims_project_user pu on p.project_id=pu.project_id" +
            " inner join lims_user_message u on pu.user_id = u.users_id " +
            "  limit #{pageNow},#{pageSize}" )
    public List<HashMap<String,Object>> adminProjetList(int pageSize, int pageNow);

    @Select("select count(p.project_id) from lims_project p inner join lims_project_user pu on p.project_id=pu.project_id" +
            " inner join lims_user_message u on pu.user_id = u.users_id " +
            " where u.users_id = #{user_id}" )
    public int countProject(int userId);


    @Select("select count(p.project_id) from lims_project p inner join lims_project_user pu on p.project_id=pu.project_id" +
            " inner join lims_user_message u on pu.user_id = u.users_id ")
    public int adminCountProject();

    @Insert("insert into lims_project(name,project_describe,project_status,audit_status,create_date) value(#{name},#{project_describe},0" +
            ",0, now())")
    public boolean insertProject(lims_project project);


    @Insert("insert into lims_approval(approvalName,status,approvalDate,approvalDescribe) value(#{name},'0',now(),#{describe});")
    public boolean insertApproval(String name,String describe);


    @Insert("insert into lims_project_user(project_id,user_id) value(#{projectId},#{userId})")
    public boolean insertProjectUser(int projectId,int userId);

    @Select("select project_id from lims_project order by project_id desc limit 0,1")
    public int descProjectId();
}
