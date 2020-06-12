package lims.demo.lims_Users.Service;

import lims.demo.lims_Users.Mapper.Users;
import lims.demo.lims_Users.Model.lims_personnel;
import lims.demo.lims_Users.Model.lims_user_message;
import lims.demo.lims_Users.Model.lims_users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class Users_service {

    @Autowired
    private Users users;

    /**
     * 登陆
     * @param user
     * @param passwords
     * @return
     */
    public HashMap<String,Object> Login(String user,String passwords)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        HashMap<String,Object> map = new HashMap<String, Object>();

        map = users.Login(user,passwords);
        if(map!=null)
        {
            int i = Integer.parseInt(dateFormat.format(new Date()));
            lims_personnel lims_personnel = new lims_personnel();

            /**
             * 考勤
             */
            if(i-9>0)
            {
                lims_personnel.setLims_personnel_status(1);
            }
            else
            {
                    lims_personnel.setLims_personnel_status(0);
            }
            lims_personnel.setUsers_id(Integer.parseInt(map.get("users_id").toString()));
            users.Insert_personnel(lims_personnel);
        }
        return map;

    }

    /**
     * 查询用户目录
     * @param userId
     * @return
     */
    public List<HashMap<String,Object>> userMenu(int userId)
    {

        return users.user_menu(userId);
    }

    /**
     * 查询用户信息
     * @param user_id
     * @return
     */

    public lims_user_message QueryMessage(int user_id)
    {
        return users.QueryMessage(user_id);
    }

    /**
     * 校验用户权限
     * @param userId
     * @param roleId
     * @return
     */
    public boolean checkRole(int userId,int roleId){
        return users.checkRole(userId,roleId);
    }

    /**
     * 查询用户信息列表
     * @param pageSize
     * @param pageNow
     * @return
     */
    public List<lims_user_message> queryMessageList(int parent,int pageSize,int pageNow)
    {
        pageNow = (pageNow-1)*pageSize;
        return users.queryUsersMessageList(parent,pageSize,pageNow);
    }


    /**
     * 统计总数
     * @return
     */
    public int countMessage()
    {
        return users.countMessage();
    }

    /**
     * 查询用户权限列表
     * @param userId
     * @return
     */
    public List<HashMap<String,Object>> usersRole(int userId)
    {
             System.out.print(userId);
        return users.usersRole(userId);
    }

    /**
     * 修改用户姓名
     * @param newName
     * @param userId  lims_users_message表中的id
     * @return
     */
    public boolean editUsersMessageName(String newName,int userId){
        return users.editUsersMessageName(newName, userId);
    }

    /**
     * 修改用户密码
     * @param password
     * @param users_id   lims_users 表中的users_id
     * @return
     */
    public boolean editUsersPass(String password,int users_id){
        return users.editUsersPass(password, users_id);
    }

    /**
     * 添加用户登录信息
     * @param user
     * @return
     */
    public boolean insertUsers(lims_users user){
        return users.insertUsers(user);
    }

    /**
     * 完善个人信息
     * @param user_message
     * @param
     * @return
     */
    public boolean insertMessage(lims_user_message user_message){
        return users.inserUsersMessage(user_message);
    }

    public int queryUsers_Id(String user,String passwords){
        return users.queryUsers_Id(user,passwords);
    }
}
