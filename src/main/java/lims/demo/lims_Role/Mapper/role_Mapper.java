package lims.demo.lims_Role.Mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@Mapper
public interface role_Mapper {


    @Select("select menu_id,lims_menu_name from lims_menu")
    public List<HashMap<String,Object>> menuRole();


    @Insert("insert into lims_menu_role(role_Id,menu_Id) value(#{roleId},#{menuId});")
    public boolean InsertMenuRole(int roleId,int menuId);

    @Delete("delete from lims_menu_role where role_Id = #{roleId} and menu_Id = #{menuId}")
    public boolean DelectMenuRole(int roleId,int menuId);

    @Delete("delete from lims_menu_role where role_Id = #{roleId}")
    public boolean DelectUsersRole(int roleId);

    @Select("SELECT mr.`menu_id`,mr.role_id  FROM `lims_menu` m INNER JOIN `lims_menu_role` mr on m.`menu_id` =mr.`menu_id` INNER JOIN `lims_user_role` u on u.`role_id` =mr.`role_id` \n" +
            "where u.`user_id` = #{usersId} ")
    public List<HashMap<String,Integer>> userMenuId(int usersId);

    @Select("select role_id from lims_user_role where user_id=#{usersId}")
    public int queryUserRole(int usersId);

}
