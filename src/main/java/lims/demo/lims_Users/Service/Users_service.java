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




    public lims_users Login(String user,String passwords)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        lims_users limsUsers = new lims_users();

        limsUsers = users.Login(user,passwords);
        if(limsUsers!=null)
        {
            int i = Integer.parseInt(dateFormat.format(new Date()));
            lims_personnel lims_personnel = new lims_personnel();

            if(i-9>0)
            {
                lims_personnel.setLims_personnel_status(1);
            }
            else
            {
                    lims_personnel.setLims_personnel_status(0);
            }
            lims_personnel.setUser_id(limsUsers.getUsers_id());
            users.Insert_personnel(lims_personnel);
        }
        return limsUsers;

    }

    public List<HashMap<String,Object>> userMenu(int userId)
    {

        return users.user_menu(userId);
    }


    public lims_user_message QueryMessage(int user_id)
    {
        return users.QueryMessage(user_id);
    }


    public List<lims_user_message> queryMessageList(int pageSize,int pageNow)
    {
        pageNow = (pageNow-1)*pageSize;
        return users.queryUsersMessageList(pageSize,pageNow);
    }


    public int countMessage()
    {
        return users.countMessage();
    }


    public List<HashMap<String,Object>> usersRole(int userId)
    {
             System.out.print(userId);
        return users.usersRole(userId);
    }
}
