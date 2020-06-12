package lims.demo.lims_Conference.Mapper;


import lims.demo.lims_Conference.model.lims_conference;
import lims.demo.lims_Conference.model.lims_conference_user;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface conference_mapper {

        /**
         * 查询所有会议记录
         * @param pageNo
         * @param pageSize
         * @return
         */
        @Select("select * from lims_conference limit #{pageNo},#{pageSize}")
        public List<lims_conference> queryList(int pageNo,int pageSize);


        /**
         * 查询会议参加人
         * @param conferenceId
         * @return
         */
        @Select("select um.* from lims_conference_user cu inner join lims_user_message um on um.users_Id = cu.user_Id where cu.conference_id =#{conferenceId} ")
        public List<HashMap<String,Object>> querUserList(int conferenceId);


        /**
         * 添加会议
         * @param conference
         * @return
         */
        @Insert("insert into lims_conference(name,content,addr,conference_date) value(#{name},#{content},#{addr},#{conference_date})")
        public boolean insertConference(lims_conference conference);

        /**
         * 会议增加参加人员
         * @param userId
         * @param conferenceId
         * @return
         */
        @Insert("insert into lims_conference_user(user_id,conference_id) value(#{userId},#{conferenceId})")
        public boolean insertConfereceUser(int userId , int conferenceId);

        /**
         * 删除会议记录
         * @param conferenceId
         * @return
         */
        @Delete("delete from lims_conference where conference_id=#{conferenceId}")
        public boolean deleteConference(int conferenceId);

        /**
         * 查询会议记录列表总数
         * @return
         */
        @Select("select count(conference_id) from lims_conference")
        public int countList();


    /**
     * 查询会议信息
     * @param conferenceId
     * @return
     */
    @Select("select * from lims_conference where conference_id=#{conferenceId}")
        public lims_conference queryById(int conferenceId);


    @Update("update lims_conference set name = #{name} , content =#{content} , addr=#{addr} , conference_date=#{conference_date} where conference_id=#{conference_id}")
    public boolean updateConference(lims_conference conference);


    @Select("select u.lims_user_message_name,u.users_id from lims_user_message u \n" +
            "inner join lims_users us on u.users_id = us.users_id  where u.users_id NOT IN  \n" +
            "(select c.user_id from lims_conference_user c where c.user_Id != #{user_Id}) \n" +
            "and us. parent=#{user_Id}")
    public List<HashMap<String,Object>> queryNotInConferenceUsers(int user_Id);
}
