package lims.demo.lims_Users.Controller;

import lims.demo.Base.SysJson;
import lims.demo.lims_Users.Model.lims_user_message;
import lims.demo.lims_Users.Service.Users_service;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import lims.demo.lims_Users.Model.lims_users;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
       HashMap<String,Object> map = new HashMap<String, Object>();
            map=users_service.Login(users,passwords);
            if(map!=null) {
                sysJson.setMessage("登陆成功");
                sysJson.setStatus(true);
                sysJson.setResult(map);

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
     * @param id
     * @return
     */
    @RequestMapping("/QueryMessage/{id}")
    public SysJson QueryMessage(@PathVariable("id") int id)
    {
        SysJson sysJson = new SysJson();
        sysJson.setResult(users_service.QueryMessage(id));
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
    @RequestMapping("/queryMessageList/{parent}")
    public SysJson queryMessageList(@PathVariable("parent") int parent, int pageSize,int pageNow)
    {
        SysJson sysJson = new SysJson();
        HashMap<String,Object> map = new HashMap<String,Object>();
        int countList=users_service.countMessage();
        if(countList>0) {
            List<lims_user_message> list = new ArrayList<lims_user_message>();
            list= users_service.queryMessageList(parent,pageSize,pageNow);
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
    @RequestMapping("/userRole/{userId}")
    public SysJson userRole(@PathVariable("userId") int userId)
    {
        SysJson sysJson = new SysJson();
        if(userId==0)
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

    @RequestMapping("/editUsersMessageName/{userId}")
    public SysJson editUsersMessageName(@PathVariable("userId") int userId,String newName){
        SysJson sysJson = new SysJson();
        boolean b = users_service.editUsersMessageName(newName, userId);
        if(b){
            sysJson.setStatus(true);
            sysJson.setMessage("修改成功");
        }else{
            sysJson.setStatus(false);
            sysJson.setMessage("修改失败");
        }

        return sysJson;
    }

    @RequestMapping("/insertUsers")
    public SysJson insertUsers(@RequestBody Object params){
        SysJson sysJson = new SysJson();
        String msg = "insertUsers fun use success";
        System.err.println(msg);
        JSONObject obj = JSONObject.fromObject(params);
        //获取参数
        String users = (String) obj.get("users");
        String passwords = (String)obj.get("passwords");
        String name = (String)obj.get("lims_user_message_name");
        String sex =(String) obj.get("lims_user_message_sex");
        String age = (String)obj.get("lims_user_message_age");
        int parentId = obj.getInt("parent");

        System.err.println(users+passwords+name+sex+age);

        msg="用户名或密码为空";
        //判断结果
        boolean userB = false;
        if(!passwords.equals("")&&passwords!=null&&!users.equals("")&&users!=null){
            lims_users users1 = new lims_users();
            users1.setUsers(users);
            users1.setPasswords(passwords);
            users1.setParent(parentId);
            userB=users_service.insertUsers(users1);
        }
        //添加用户资料
        boolean messageB=false;
        if(userB){
            msg="登录信息添加成功";
            int users_Id = users_service.queryUsers_Id(users,passwords);
            lims_user_message message = new lims_user_message();
            message.setLims_user_message_name(name);
            message.setLims_user_message_age(Integer.parseInt(age));
            message.setLims_user_message_sex(sex);
            message.setUsers_id(users_Id);
            messageB=users_service.insertMessage(message);
        }

        if(userB&&messageB){
            sysJson.setStatus(true);
            sysJson.setMessage(msg);
        }else {
            sysJson.setStatus(false);
            sysJson.setMessage("添加失败："+msg);
        }

        return sysJson;
    }



}
