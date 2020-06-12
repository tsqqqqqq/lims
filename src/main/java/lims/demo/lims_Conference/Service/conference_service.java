package lims.demo.lims_Conference.Service;


import lims.demo.lims_Conference.Mapper.conference_mapper;
import lims.demo.lims_Conference.model.lims_conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class conference_service {

    @Autowired
    private conference_mapper conference_mapper;


    /**
     * 查询所有会议记录
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<lims_conference> queryList(int pageNo, int pageSize)
    {
        return conference_mapper.queryList((pageNo-1)*pageSize,pageSize);
    }


    /**
     * 查询会议参加人
     * @param conferenceId
     * @return
     */
    public List<HashMap<String,Object>> querUserList(int conferenceId){
        return conference_mapper.querUserList(conferenceId);
    }

    /**
     * 添加会议
     * @param conference
     * @return
     */
    public boolean insertConference(lims_conference conference){
        return conference_mapper.insertConference(conference);
    }


    /**
     * 会议增加参加人员
     * @param
     * @param conferenceId
     * @return
     */

    public int  insertConfereceUser(int[] userIdList , int conferenceId){
         int count = 0;

        for(int i =0; i<userIdList.length;i++){
            if(conference_mapper.insertConfereceUser(userIdList[i],conferenceId)){
                count++;
            };
        }
        return count;
    }

    /**
     * 删除会议记录
     * @param conferenceId
     * @return
     */

    public boolean deleteConference(int conferenceId){
        return conference_mapper.deleteConference(conferenceId);
    }


    /**
     * 查询记录总数
     * @return
     */
    public int countList(){
        return conference_mapper.countList();
    };


    public lims_conference queryById(int conferenceId){
        return  conference_mapper.queryById(conferenceId);
    }

    /***
     * 修改会议记录
     * @param conference
     * @return
     */
    public boolean updateConference(lims_conference conference){
        return conference_mapper.updateConference(conference);
    }

    /**
     * 查询未添加到会议中并且属于该角色创建的用户列表
     * @param userId
     * @return
     */
    public List<HashMap<String,Object>> queryNotInConferenceUsers(int userId)
    {
        return conference_mapper.queryNotInConferenceUsers(userId);
    }
}
