package lims.demo.lims_Users.Mapper;


import lims.demo.lims_Users.Model.lims_personnel;
import lims.demo.lims_Users.Model.lims_user_message;
import lims.demo.lims_Users.Model.lims_users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@Mapper
public interface Users {


        /**
         * 登陆
         * @param users
         * @param passwords
         * @return
         */
        @Select("select * from lims_users u inner join lims_user_message m on u.users_id =m.users_id where users = #{users} and passwords = #{passwords}")
        public HashMap<String,Object> Login(String users, String passwords);


        /**
         * 查询用户权限目录
         * @param userId
         * @return
         */
        @Select(" SELECT * FROM lims_menu where menu_id in " +
                "(select menu_id from lims_menu_role inner join lims_role on lims_menu_role.role_id=lims_role.role_id where " +
                " lims_role.role_id in (select role_id from lims_user_role inner join lims_users on lims_users.users_id = " +
                " lims_user_role.user_id where lims_users.users_id =#{userId}))")
        public List<HashMap<String,Object>>  user_menu(int userId);


    /**
     * 查询某一个用户的个人信息
     * @param id
     * @return
     */
    @Select("select * from lims_user_message m where m.id = #{id}")
        public lims_user_message QueryMessage(int id);

    /**
     * 添加考勤信息
     * @param lims_personnel
     * @return
     */
        @Insert("insert into lims_personnel(lims_personnel_check,lims_personnel_status,users_id) value(now(),#{lims_personnel_status},#{users_id})")
        public boolean Insert_personnel(lims_personnel lims_personnel);

    /**
     * 校验用户是否拥有该权限
     * @param user_Id
     * @param role_Id
     * @return
     */
        @Select("select role_id from lims_role r inner join  lims_user_role ur on r.role_id = ur.role_id where ur.user_id = #{user_id} and ur.role_Id=#{role_Id}")
        public boolean checkRole(int user_Id,int role_Id);

    /**
     * 分页查询用户列表
     * @param pageSize
     * @param pageNow
     * @return
     */
        @Select("select um.* from lims_user_message um inner join lims_users u on u.users_id=um.users_id where u.parent=#{parent} limit #{pageNow},#{pageSize}")
        public List<lims_user_message> queryUsersMessageList(int parent,int pageSize,int pageNow);

    /**
     * 查询用户列表总数
     * @return
     */
        @Select("select count(id) from lims_user_message")
        public int countMessage();

        @Select("")
        public List<HashMap<String,Object>>  usersMessage(int userId);

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    @Select("SELECT m.menu_id ,r.`role_name`,r.`role_describe`,r.role_id,m.`lims_menu_name`,m.`lims_menu_describe`" +
                " FROM   `lims_user_role` ur " +
                " INNER JOIN `lims_role` r on ur.`role_id` =r.`role_id`" +
                " INNER JOIN `lims_menu_role` mr on r.`role_id` =mr.`role_id` " +
                "INNER JOIN `lims_menu`  m on mr.`menu_id` =m.`menu_id`  where ur.`user_id` =#{userId}")
        public List<HashMap<String,Object>>  usersRole(int userId);

    /**
     * 修改某一个用户的姓名
     * @param newName
     * @param userId
     * @return
     */
    @Update("update lims_user_message set lims_user_message_name = #{newName} where id = #{userId}")
    public boolean editUsersMessageName(String newName,int userId);

    /**
     * 修改用户的登陆密码
     * @param password
     * @param users_Id
     * @return
     */
    @Update(("upadate lims_users set passwords = #{password} where users_id = #{users_Id}"))
    public boolean editUsersPass(String password,int users_Id);

    /**
     * 添加用户登录信息
     * @param users
     * @return
     */
    @Insert("insert lims_users(users,passwords,parent) value(#{users},#{passwords},#{parent})")
    public boolean insertUsers(lims_users users);

    /**
     * 完善个人信息
     * @param user_message
     * @return
     */
    @Insert("insert lims_user_message(lims_user_message_name,lims_user_message_age,lims_user_message_sex,users_id) value(#{lims_user_message_name},#{lims_user_message_age},#{lims_user_message_sex},#{users_id})")
    public boolean inserUsersMessage(lims_user_message user_message);

    /**
     * 查找用户id
     * @param users
     * @param passwords
     * @return
     */
    @Select("select users_Id from lims_users where users=#{users} or passwords=#{passwords}")
    public int queryUsers_Id(String users,String passwords);
}
