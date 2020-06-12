package lims.demo.lims_EAM.Controller;

import lims.demo.Base.SysJson;
import lims.demo.lims_EAM.Model.lims_EAM;
import lims.demo.lims_EAM.Model.lims_EAM_menu;
import lims.demo.lims_EAM.Service.EAM_service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class EAM_Controller {

        @Autowired
        private EAM_service eam_service;

        private SysJson sysJson = new SysJson();

    /**
     * 查询设备资产库存
     * @return
     */
    @RequestMapping("/QueryInventory")
        public SysJson QueryInventory()
        {
            sysJson.setResult(eam_service.Query_EAM_menu_inventory());
            return sysJson;
        }

    /**
     * 查询资产列表
     * @return
     */
    @RequestMapping("/QueryEAM")
    public SysJson QueryEAM(int pageSize,int pageNow)
    {
        HashMap<String,Object> map = new HashMap<String, Object>();
        List<HashMap<String,Object>> list = eam_service.QueryEAM(pageSize,pageNow);
        int count =0;
        if(list==null&&list.size()<=0)
        {
            sysJson.setStatus(false);
            sysJson.setMessage("查询失败");
        }
        else{
            sysJson.setStatus(true);
            sysJson.setMessage("查询成功");
            count=eam_service.countEAM();
            map.put("list",list);
            map.put("countList",count);
            sysJson.setResult(map);
        }


        return sysJson;
    }




    /**
     * 增加设备类目
     * @param lims_eam_menu
     * @return
     */
    @RequestMapping("/Insert_EAM_menu")
        public SysJson Insert_EAM_menu(lims_EAM_menu lims_eam_menu)
        {
            boolean b = false;
            b = eam_service.Insert_EAM_menu(lims_eam_menu);
            sysJson.setStatus(b);
            if(b)
            {
                sysJson.setMessage("Insert lims_EAM_menu success");
            }
            else
            {
                sysJson.setMessage("Insert lims_EAM_menu error");
            }
            return sysJson;
        }

        @RequestMapping("/Insert_EAM")
        public SysJson Insert_EAM(lims_EAM lims_eam)
        {
            System.err.print(lims_eam.getLims_EAM_name());
            boolean b = false;
            b=eam_service.Insert_EAM(lims_eam);
            if(b)
            {
                sysJson.setMessage("添加设备成功");
                int inventory = eam_service.QueryInventoryEam(lims_eam.getEAM_menu_id());
                b = eam_service.updateInventory(lims_eam.getEAM_menu_id(),inventory);
            }else {
                sysJson.setMessage("添加设备失败");
            }
            sysJson.setStatus(b);
            return sysJson;

        }


        @RequestMapping("/updateEam/{eam_Id}")
        public SysJson updateEam(@PathVariable("eam_Id") int Id,String eamEdit_lims_EAM_name,String eamEdit_lims_EAM_status){
            SysJson sysJson = new SysJson();
            String msg ="updateEam function use success";
            System.err.println(msg);
            boolean b =false;
            b = eam_service.updateEam(eamEdit_lims_EAM_name,eamEdit_lims_EAM_status,Id);
            if(b){
                msg="修改成功";
                sysJson.setStatus(true);
                sysJson.setMessage(msg);
            }else{
                sysJson.setStatus(false);
                sysJson.setMessage("修改失败");
            }
            return sysJson;
        }


        @RequestMapping("/deleteEam/{id}")
        public SysJson deleteEam(@PathVariable("id") int id){
            SysJson sysJson = new SysJson();
            String msg ="deleteEam function use success";
            System.err.println(msg);
            boolean b =false;
            b = eam_service.deleteEam(id);
            if(b){
                msg="删除成功";
                sysJson.setStatus(true);
                sysJson.setMessage(msg);
            }else{
                sysJson.setStatus(false);
                sysJson.setMessage("删除失败");
            }

            return sysJson;
        }
}
