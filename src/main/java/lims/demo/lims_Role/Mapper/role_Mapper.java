package lims.demo.lims_Role.Mapper;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@Mapper
public interface role_Mapper {


    @Select("select menu_id,lims_menu_name from lims_menu")
    public List<HashMap<String,Object>> menuRole();


    @Insert("insert into lims_user_role(role_Id,user_Id) value(#{roleId},#{userId});")
    public boolean InsertUserRole(int roleId,int userId);

    @Delete("delete from lims_menu_role where role_Id = #{roleId} and menu_Id = #{menuId}")
    public boolean DelectMenuRole(int roleId,int menuId);

    @Delete("delete from lims_menu_role where role_Id = #{roleId}")
    public boolean DelectUsersRole(int roleId);

    /**
     * 获取当前用户的目录idy以及权限Id
     * @param usersId
     * @return
     */
    @Select("SELECT mr.`menu_id`,mr.role_id  FROM `lims_menu` m INNER JOIN `lims_menu_role` mr on m.`menu_id` =mr.`menu_id` INNER JOIN `lims_user_role` u on u.`role_id` =mr.`role_id` \n" +
            "where u.`user_id` = #{usersId} ")
    public List<HashMap<String,Integer>> userMenuId(int usersId);

    /**
     * 根据用户Id 权限Id 查找权限是否存在。
     * @param usersId
     * @return
     */
    @Select("select role_id from lims_user_role where user_id=#{usersId} and role_Id =#{roleId}")
    public Integer queryUserRole(int usersId,int roleId);

    @Select(("select role_Id from lims_user_role where user_id=#{usersId}"))
    public List<Integer> queryUserList(int usersId);

    /**
     *删除用户权限
     * @param userId
     * @return
     */
    @Delete("delete from lims_user_role where user_id=#{userId} and role_id = #{roleId}")
    public boolean deleteUserRole(int userId,int roleId);

    /**
     *清空用户权限
     * @param userId
     * @return
     */
    @Delete("delete from lims_user_role where user_id=#{userId} and role_id = #{roleId}")
    public boolean deleteRole(int userId);

    /**
     * 根据菜单id 查询权限Id
     * @param menuId
     * @return
     */
    @Select("select role_id from lims_menu_role where menu_id = #{menuId}")
    public int queryMenuRole(int menuId);


    @Update("Update lims_user_role set role_Id = #{newRole} where user_Id  =#{userId} and role_Id = #{oldRole}")
    public boolean updataUsersRole(int oldRole,int newRole,int userId);
}
