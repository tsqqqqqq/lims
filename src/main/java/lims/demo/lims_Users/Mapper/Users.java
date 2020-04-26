package lims.demo.lims_Users.Mapper;


import lims.demo.lims_Users.Model.lims_personnel;
import lims.demo.lims_Users.Model.lims_user_message;
import lims.demo.lims_Users.Model.lims_users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
        @Select("select * from lims_users where users = #{users} and passwords = #{passwords}")
        public lims_users Login(String users, String passwords);


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


        @Select("select * from lims_user_message m inner join lims_users u  on u.users_id = m.user_id where m.user_id = #{user_id}")
        public lims_user_message QueryMessage(int user_id);


        @Insert("insert into lims_personnel(lims_personnel_check,lims_personnel_status,user_id) value(now(),#{lims_personnel_status},#{user_id})")
        public boolean Insert_personnel(lims_personnel lims_personnel);



        @Select("select * from lims_user_message limit #{pageNow},#{pageSize}")
        public List<lims_user_message> queryUsersMessageList(int pageSize,int pageNow);

        @Select("select count(id) from lims_user_message")
        public int countMessage();

        @Select("")
        public List<HashMap<String,Object>>  usersMessage(int userId);

        @Select("SELECT m.menu_id ,um.`lims_user_message_name`,r.`role_name`,r.`role_describe`,r.role_id,m.`lims_menu_name`,m.`lims_menu_describe`" +
                " FROM `lims_user_message` um inner JOIN  `lims_user_role` ur  on um.`user_id` =ur.`user_id`" +
                " INNER JOIN `lims_role` r on ur.`role_id` =r.`role_id`" +
                " INNER JOIN `lims_menu_role` mr on r.`role_id` =mr.`role_id` " +
                "INNER JOIN `lims_menu`  m on mr.`menu_id` =m.`menu_id`  where um.`id` =#{userId}")
        public List<HashMap<String,Object>>  usersRole(int userId);


}
