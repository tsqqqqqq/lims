package lims.demo.lims_Role.Controller;


import lims.demo.Base.SysJson;
import lims.demo.lims_Role.Service.role_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class role_Controller {

    @Autowired
    private role_Service role_service;

    private SysJson sysJson = new SysJson();

    /**
     * 查询所有的权限目录
     * @return
     */
    @RequestMapping("/menuRole")
    public SysJson menuRole()
    {

        List<HashMap<String,Object>> list = new ArrayList<HashMap<String, Object>>();
        list=role_service.menuRole();
        if(list!=null||list.size()>0)
        {
            sysJson.setStatus(true);
            sysJson.setMessage("查询成功");
            sysJson.setResult(list);
        }
        else
        {
            sysJson.setStatus(false);
            sysJson.setMessage("查询失败");
        }
        return sysJson;
    }

    /**
     * 分配权限
     * @param menuList
     * @param userId
     * @return
     */
    @RequestMapping("/allocationRole")
    public SysJson allocationRole(@RequestParam(value="menuList[]",required = false)int[] menuList, int userId)
    {
        boolean b=false;
        String msg = "allocationRole  fun use success";
        System.err.println(msg);
        if(menuList==null){
            b = role_service.deleteRole(userId);
            msg="用户权限清空成功。";
        }else {
            b = role_service.allocationRole(menuList, userId);
            msg="用户权限分配成功。";
        }
        if (b) {
            sysJson.setStatus(b);
        } else {
            sysJson.setStatus(b);
        }
        sysJson.setMessage(msg);
        return sysJson;
    }
}
