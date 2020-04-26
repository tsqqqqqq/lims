package lims.demo.approval.controller;

import lims.demo.Base.SysJson;
import lims.demo.approval.lims_approval;
import lims.demo.approval.service.approval_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class approval_controller {

        @Autowired
        private approval_service approval_service;

        private SysJson sysJson=new SysJson();

        @RequestMapping("/approvalList")
        public SysJson list(int pageSize,int pageNow){
            HashMap<String,Object> map = new HashMap<String, Object>();
            List<lims_approval> list = new ArrayList<lims_approval>();
            list = approval_service.list(pageSize,pageNow);
            if(list!=null&&list.size()>0){
                sysJson.setStatus(true);
                sysJson.setMessage("查询成功");
                map.put("list",list);
                map.put("countList",list.size());
                sysJson.setResult(map);
            }
            else {
                sysJson.setStatus(false);
                sysJson.setMessage("查询失败");
            }
            return sysJson;
        }

        @RequestMapping("/updateApproval")
        public SysJson updateApproval(lims_approval limsApproval){

            boolean b = approval_service.updateApproval(limsApproval);
            if(b){
                sysJson.setStatus(b);
                sysJson.setMessage("编辑成功");
            }
            return sysJson;
        }

        @RequestMapping("/queryApproval")
        public SysJson queryApproval(int approvalId){
            if(approvalId!=0){
                lims_approval limsApproval = approval_service.queryApproval(approvalId);
                if(limsApproval!=null){
                    sysJson.setStatus(true);
                    sysJson.setMessage("查询成功");
                    sysJson.setResult(limsApproval);
                }else{
                    sysJson.setStatus(false);
                    sysJson.setMessage("查询失败");
                }
            }else{
                sysJson.setStatus(false);
                sysJson.setMessage("查询失败");
            }
            return sysJson;
        }
}
