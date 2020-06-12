package lims.demo.lims_notice.Mapper;

import lims.demo.Base.SysJson;
import lims.demo.lims_notice.Model.lims_notice;
import lims.demo.lims_notice.Model.lims_notice_type;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface Notice_Mapper {


        @Select("Select * from lims_notice_type")
        public List<lims_notice_type> queryNoticeType();

        @Select("Select * from lims_notice order By notice_date desc limit #{pageNow},#{pageSize}")
        public List<lims_notice> queryNoticeTypeList(int pageSize,int pageNow);

        @Select("select * from lims_notice  order by notice_date  desc , notice_type_id asc")
        public List<lims_notice>  queryNotice();

        @Select("select * from lims_notice where notice_id=#{noticeId}")
        public lims_notice queryNoticeId(int noticeId);

        @Insert("insert into lims_notice_type(name,notice_type_describe) value(#{name},#{notice_type_describe});")
        public boolean CreateNoticeType(lims_notice_type lims_notice_type);


        @Update("update lims_notice_type set name = #{name} , notice_type_describe = #{notice_type_describe} where notice_type_id = #{notice_type_id} ")
        public boolean UpdateNoticeType(lims_notice_type lims_notice_type);


        @Insert("insert into lims_notice(title,content,notice_date,notice_type_id) value(#{title},#{content},now(),#{notice_type_id})")
        public boolean CreateNotice(lims_notice notice);


        @Select("select count(*) from lims_notice")
        public int count();

        @Update("update lims_notice set title=#{title}, content=#{content}, notice_type_id=#{notice_type_id} , notice_date=now() where  notice_id=#{notice_id}")
        public boolean update(lims_notice notice);


        @Delete("delete from lims_notice where notice_id=#{noticeId}")
        public boolean noticeDelete(int noticeId);
}
