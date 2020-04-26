package lims.demo.lims_Users.Controller;

import lims.demo.Base.SysJson;
import lims.demo.lims_Users.Model.lims_user_message;
import lims.demo.lims_Users.Service.Users_service;
import org.springframework.beans.factory.annotation.Autowired;
import lims.demo.lims_Users.Model.lims_users;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class Login {


    @Autowired
    private Users_service users_service;

    /**
     * 登陆
     * @param users
     * @param passwords
     * @return
     */
    @RequestMapping("/login")
    public SysJson Login(String users , String passwords)
    {
            SysJson sysJson = new SysJson();

            boolean b =false;
            if(users==null||users=="")
            {
                sysJson.setMessage("用户名为空 无法登录");
                sysJson.setStatus(b);
            }else if(passwords==null||passwords==null)
            {
                sysJson.setMessage("密码为空 无法登陆");
                sysJson.setStatus(b);
            }
        lims_users lims_users =new lims_users();
            lims_users=users_service.Login(users,passwords);
            if(lims_users!=null) {
                sysJson.setMessage("登陆成功");
                sysJson.setStatus(true);
                sysJson.setResult(lims_users);

            }else
            {
                sysJson.setMessage("登录失败 请验证账号密码是否正确");
                sysJson.setStatus(b);

            }



            return sysJson;
    }

    /**
     * 查询用户权限目录
     * @param userId
     * @return
     */
    @RequestMapping("/userMenu")
    public SysJson user_menu(int userId)
    {

        SysJson sysJson = new SysJson();
        List<HashMap<String,Object>> map = new ArrayList<HashMap<String, Object>>();

        if(userId==0)
        {
            sysJson.setMessage("参数为传入失败");
        }else
        {
            map=users_service.userMenu(userId);
        }
        if(map!=null|map.size()>0)
        {
            sysJson.setResult(map);
            sysJson.setStatus(true);
        }
        else
        {
            sysJson.setMessage("菜单目录获取失败 请重新登录");
        }

        return  sysJson;
    }

    /**
     * 查询某一用户信息
     * @param user_id
     * @return
     */
    @RequestMapping("/QueryMessage")
    public SysJson QueryMessage(int user_id)
    {
        SysJson sysJson = new SysJson();
        sysJson.setResult(users_service.QueryMessage(user_id));
        if(sysJson.getResult()!=null)
        {
            sysJson.setStatus(true);
            sysJson.setMessage("Query Success");
        }
        else
        {
            sysJson.setStatus(true);
            sysJson.setMessage("Query Error ");
        }
        return  sysJson;
    }

    /**
     * 查询用户列表
     * @param pageSize
     * @param pageNow
     * @return
     */
    @RequestMapping("/queryMessageList")
    public SysJson queryMessageList(int pageSize,int pageNow)
    {
        SysJson sysJson = new SysJson();
        HashMap<String,Object> map = new HashMap<String,Object>();
        int countList=users_service.countMessage();
        if(countList>0) {
            List<lims_user_message> list = new ArrayList<lims_user_message>();
            list= users_service.queryMessageList(pageSize,pageNow);
            if(list!=null||list.size()>0)
            {
                sysJson.setStatus(true);
                sysJson.setMessage("query success");
                map.put("countList",countList);
                map.put("list",list);
                sysJson.setResult(map);
            }
            else
            {
                sysJson.setResult(false);
                sysJson.setMessage("查询失败");
            }
        }else
        {
            sysJson.setStatus(false);
            sysJson.setMessage("暂无数据");
        }



        return sysJson;
    }

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    @RequestMapping("/userRole")
    public SysJson userRole(int userId)
    {
        SysJson sysJson = new SysJson();
        if(userId<0)
        {
            sysJson.setStatus(false);
            sysJson.setMessage("查询失败 userId不存在或为空");
        }
        else{
            sysJson.setStatus(true);
            sysJson.setMessage("查询成功");
            sysJson.setResult(users_service.usersRole(userId));
        }
        return sysJson;
    }
}
