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

    /**
     * 分配权限
     * @param menuList
     * @param userId
     * @return
     */
    public boolean  allocationRole(int[] menuList,int userId)
    {
            boolean b =false;
            List<Integer> oldUserRole= new ArrayList<Integer>();
            oldUserRole=role_mapper.queryUserList(userId);

            //记录当前新的权限编码，避免newArray数组越界
            int newRole = 0;

            //如果不存在旧的权限则直接添加
            if(oldUserRole.size()>0){

                //记录新旧权限的数组
                int[] oldArray = new int[oldUserRole.size()];
                int[] newArray = new int[menuList.length];

                for(int i =0;i<oldUserRole.size();i++){
                for(int j =0; j<menuList.length;j++){
                    if(oldUserRole.size()==menuList.length){
                        //两边数组长度相等的情况下 只做修改操作。
                        role_mapper.updataUsersRole(oldUserRole.get(i),menuList[j],userId);
                    }else{
                        //如果新的权限与旧的权限不相等，存储到数组中，再做增删操作。
                        if(oldUserRole.get(i)!=menuList[j]){
                            oldArray[i]=oldUserRole.get(i);
                            if(newRole!=menuList[j]) {
                                newArray[j] = menuList[j];
                                newRole = menuList[j];
                            }
                        }else{
                            continue;
                        }
                    }
                }
            }
                for(int i =0;i<oldArray.length;i++){
                    if(oldArray[i]!=0){
                        //做删除操作
                        role_mapper.deleteUserRole(userId,oldArray[i]);
                    }

                }

                for(int i=0; i<newArray.length;i++){
                    if(newArray[i]!=0&&role_mapper.queryUserRole(userId,newArray[i])==null){
                        //做增加操作\
                        role_mapper.InsertUserRole(newArray[i],userId);
                    }

                }

            }else{
                for(int i=0;i<menuList.length;i++){
                    role_mapper.InsertUserRole(menuList[i],userId);
                }
            }

            return b ;
    }

    /**
     * 清空用户权限
     * @param userId
     * @return
     */
    public boolean deleteRole(int userId){
        return role_mapper.deleteRole(userId);
    }
}
