package lims.demo.lims_notice.Controller;


import lims.demo.Base.SysJson;
import lims.demo.lims_notice.Model.lims_notice;
import lims.demo.lims_notice.Model.lims_notice_type;
import lims.demo.lims_notice.Service.Notice_type_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class lims_notice_Controller {

    @Autowired
    private Notice_type_service notice_type_service;

    private SysJson sysJson=new SysJson();

    /**
     * 查询通知类型列表
     * @return
     */
    @RequestMapping("/QueryNoticeType")
    public SysJson QueryNotice_type() {
        sysJson.setMessage("Query success");
       
        sysJson.setResult(notice_type_service.QueryNoticeType());
        if (sysJson.getResult() != null)
        {
            sysJson.setStatus(true);

        }
        else
        {
            sysJson.setStatus(false);
            sysJson.setMessage("Query error");
        }
        return sysJson;
    }

    /**
     * 查询某一类型的所有通知
     * @param
     * @param pageSize
     * @param pageNow
     * @return
     */
    @RequestMapping("/noticeTypeList")
    public SysJson noticeTypeList(int pageSize,int pageNow){
        HashMap<String,Object> map = new HashMap<String, Object>();
        List<lims_notice> list = new ArrayList<lims_notice>();
        list=notice_type_service.QueryNoticeTypeList(pageSize,pageNow);
        if(list.size()>0){
            sysJson.setStatus(true);
            sysJson.setMessage("查询成功");
            map.put("countList",notice_type_service.count());
            map.put("list",list);
            sysJson.setResult(map);
        }else{
            sysJson.setStatus(false);
            sysJson.setMessage("查询失败");
        }
        return sysJson;
    }

    /**
     * 查询所有通知
     * @return
     */
    @RequestMapping("/QueryNotice")
    public SysJson QueryNotice() {
        sysJson.setMessage("Query success");

        sysJson.setResult(notice_type_service.QueryNotice());
        if (sysJson.getResult() != null)
        {
            sysJson.setStatus(true);
        }
        else
        {
            sysJson.setStatus(false);
            sysJson.setMessage("Query error");
        }
        return sysJson;
    }

    /**
     * 添加通知类型
     * @param notice_type
     * @return
     */
    @RequestMapping("/CreateNoticeType")
    public SysJson CreateNoticeType(lims_notice_type notice_type)
    {
        sysJson.setStatus(notice_type_service.CreateNoticeType(notice_type));
        if(sysJson.isStatus())
        {
            sysJson.setMessage("Create success");
        }
        else
        {
            sysJson.setMessage("Create error");
        }

        return sysJson;
    }

    /**
     * 修改通知类型
     * @param notice_type
     * @return
     */
    @RequestMapping("/UpdateNoticeType")
    public SysJson UpdateNoticeType(lims_notice_type notice_type)
    {
        sysJson.setStatus(notice_type_service.UpdateNoticeType(notice_type));
        if(sysJson.isStatus())
        {
            sysJson.setMessage("Update success");
        }
        else
        {
            sysJson.setMessage("Update error");
        }

        return sysJson;
    }

    /**
     * 添加通知
     * @param notice
     * @return
     */
    @RequestMapping("/CreateNotice")
    public SysJson CreateNotice(lims_notice notice)
    {
        sysJson.setStatus(notice_type_service.CreateNotice(notice));
        if(sysJson.isStatus())
        {
            sysJson.setMessage("Create success");
        }
        else
        {
            sysJson.setMessage("Create error");
         }
        return sysJson;
    }

    /**
     *查询通知详情
     * @param noticeId
     * @return
     */
    @RequestMapping("/queryNoticeId")
    public SysJson queryNoticeId(int noticeId){
        if(noticeId!=0){
            lims_notice notice = notice_type_service.queryNoticeId(noticeId);
            if(notice!=null){
                sysJson.setStatus(true);
                sysJson.setMessage("查询成功");
                sysJson.setResult(notice);
            }else {
                sysJson.setStatus(false);
                sysJson.setMessage("查询失败");

            }
        }
        return sysJson;
    }

    /**
     * 修改通知信息
     * @param noticeId
     * @param notice
     * @return
     */
    @RequestMapping("/noticeUpdate/{noticeId}")
    public SysJson noticeUpdate(@PathVariable("noticeId") int noticeId , lims_notice notice){
            notice.setNotice_id(noticeId);
            if(notice_type_service.update(notice)){
                sysJson.setStatus(true);
                sysJson.setMessage("修改成功");
            }else{
                sysJson.setStatus(false);
                sysJson.setMessage("修改失败");
            }

        return sysJson;
    }

    @RequestMapping("/noticeDelete")
    public SysJson noticeDelete(int noticeId){
        if(notice_type_service.noticeDelete(noticeId)){
            sysJson.setStatus(true);
            sysJson.setMessage("删除成功");
        }else{
            sysJson.setStatus(false);
            sysJson.setMessage("删除失败");
        }

        return sysJson;
    }
}

