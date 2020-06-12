package lims.demo.lims_Conference.Controller;


import lims.demo.Base.SysJson;
import lims.demo.lims_Conference.Service.conference_service;
import lims.demo.lims_Conference.model.lims_conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class conference_controller {

    @Autowired
    private conference_service conference_service;

    private SysJson sysJson = new SysJson();

    /**
     * 查询会议记录总数
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/conferenceList/{pageNo}/{pageSize}")
    public SysJson queryList(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
       String msg = "queryList fun use success";
       System.err.println(msg);
        HashMap<String,Object> map = new HashMap<String, Object>();

        List<lims_conference> list = conference_service.queryList(pageNo,pageSize);

        if(list.size()>0){
            sysJson.setStatus(true);
            msg="查询成功";
            sysJson.setMessage(msg);
            int count = conference_service.countList();
            map.put("list",list);
            map.put("count",count);
            sysJson.setResult(map);
        }else {
            sysJson.setStatus(false);
            msg="会议记录不存在";
            sysJson.setMessage(msg);
        }

        return sysJson;
    }

    /**
     * 查询会议人员
     * @param conferenceId
     * @return
     */
    @RequestMapping("/conferenceQueryUserList")
    public SysJson queryUserList(int conferenceId){
        String msg="querUserList fun use success";
        System.err.println(msg);
        List<HashMap<String,Object>> list = conference_service.querUserList(conferenceId);
        if(list.size()>0){
            sysJson.setStatus(true);
            msg="查询成功";
            sysJson.setMessage(msg);
            sysJson.setResult(list);
        }else{
            sysJson.setStatus(false);
            msg="查询失败";
            sysJson.setMessage(msg);
        }
        return sysJson;
    }

    /**
     * 添加会议记录
     * @param conference
     * @return
     */
    @RequestMapping("/insertConference")
    public SysJson insertConference(lims_conference conference){

        String msg="insertConference fun use success";
        System.err.println(msg);
        if(conference_service.insertConference(conference)){
            sysJson.setStatus(true);
            msg="添加成功";
            sysJson.setMessage(msg);

        }else{
            sysJson.setStatus(false);
            msg="查询失败";
            sysJson.setMessage(msg);
        }
        return sysJson;
    }

    /**
     * 会议添加人员
     * @param userIdList
     * @param conferenceId
     * @return
     */
    @RequestMapping("/insertConfereceUser/{conferenceId}")
    public SysJson insertConfereceUser(@RequestParam(value="userIdList[]",required = false)int[] userIdList,@PathVariable("conferenceId") int conferenceId){
        if(userIdList.length>0){
            int count =conference_service.insertConfereceUser(userIdList,conferenceId);
            sysJson.setStatus(true);
            sysJson.setMessage("已成功添加"+count+"人");
        }else{
            sysJson.setStatus(false);
            sysJson.setMessage("添加失败");
        }
        return sysJson;
    }


    /**
     * 删除会议记录
     * @param conferenceId
     * @return
     */
    @RequestMapping("/deleteConference")
    public  SysJson deleteConference(int conferenceId){
        if(conference_service.deleteConference(conferenceId)){
            sysJson.setStatus(true);
            sysJson.setMessage("删除会议成功");
        }else{
            sysJson.setStatus(false);
            sysJson.setMessage("删除会议失败");
        }

        return sysJson;
    }

    /**
     * 查询会议记录信息
     * @param conferenceId
     * @return
     */
    @RequestMapping("/queryConferenceById/{conferenceId}")
    public SysJson queryConferenceById(@PathVariable("conferenceId") int conferenceId){
        HashMap<String,Object> map = new HashMap<String, Object>();
        lims_conference conference=conference_service.queryById(conferenceId);
        System.err.println(conference);
        List<HashMap<String,Object>> list = conference_service.querUserList(conferenceId);
        if(conference!=null) {
            map.put("conference", conference);
            map.put("list", list);
            map.put("listCount", list.size());
            sysJson.setStatus(true);
            sysJson.setResult(map);
        }

        return  sysJson;
    }

    /**
     * 修改会议记录
     * @param conferenceId
     * @param conference
     * @return
     */
    @RequestMapping("/updateConference/{conferenceId}")
    public  SysJson updateConference(@PathVariable("conferenceId") int conferenceId, lims_conference conference){
        conference.setConference_id(conferenceId);
        if(conference_service.updateConference(conference)){
            sysJson.setStatus(true);
            sysJson.setMessage("修改成功");
        }else{
            sysJson.setStatus(false);
            sysJson.setMessage("修改失败");
        }

        return sysJson;
    }

    /**
     * 查询会议记录不存在的人员
     * @param userId
     * @return
     */
    @RequestMapping("/queryNotInConferenceUsers/{userId}")
    public  SysJson queryNotInConferenceUsers(@PathVariable("userId") int userId){
        List<HashMap<String,Object>> list = conference_service.queryNotInConferenceUsers(userId);
        if(list!=null) {
            sysJson.setStatus(true);
        }else{
            sysJson.setResult(false);
        }
        sysJson.setResult(list);

        return sysJson;
    }
}
