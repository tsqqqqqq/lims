package lims.demo.lims_Role.Service;


import lims.demo.lims_Role.Mapper.role_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class role_Service {

    @Autowired
    private role_Mapper role_mapper;

    public List<HashMap<String,Object>> menuRole()
    {
        return role_mapper.menuRole();
    }


    public boolean  allocationRole(int[] menuList,int userId)
    {
        boolean b =false;
        List<HashMap<String,Integer>> map = new ArrayList<HashMap<String,Integer>>();
        map=role_mapper.userMenuId(userId);
        if(menuList!=null&&menuList.length>0)
        {

        if(map!=null&&map.size()>0)
        {
            for(int i =0; i<map.size();i++)
            {
                for(int j =0;j<menuList.length;j++)
                {
                    if(menuList[j]!=map.get(i).get("menu_id")&&menuList.length>map.size())
                    {
                        b=role_mapper.InsertMenuRole(map.get(i).get("role_id"),menuList[i]);
                    }
                    if(menuList[j]!=map.get(i).get("menu_id")&&menuList.length<=map.size())
                    {
                        b=role_mapper.DelectMenuRole(map.get(i).get("role_id"),map.get(i).get("menu_id"));
                        if(b)
                        {
                            b=role_mapper.InsertMenuRole(map.get(i).get("role_id"),menuList[i]);
                        }

                    }
                }
            }
        }else
        {
            int roleId = role_mapper.queryUserRole(userId);
            for(int i=0;i<menuList.length;i++)
            {
                b=role_mapper.InsertMenuRole(roleId,menuList[i]);
            }
        }

        }
        else
        {
            int roleId = role_mapper.queryUserRole(userId);
            b=role_mapper.DelectUsersRole(roleId);
            return b ;
        }



        return b;
    }
}
