package lims.demo.lims_notice.Service;

import lims.demo.Base.SysJson;
import lims.demo.lims_notice.Mapper.Notice_Mapper;
import lims.demo.lims_notice.Model.lims_notice;
import lims.demo.lims_notice.Model.lims_notice_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Notice_type_service {


    @Autowired
    private Notice_Mapper notice_mapper;

    public List<lims_notice_type> QueryNoticeType()
    {

      return notice_mapper.queryNoticeType();
    }
    public List<lims_notice> QueryNoticeTypeList(int noticeTypeId ,int pageSize,int pageNow)
    {
        pageNow = (pageNow-1)*pageSize;
        return notice_mapper.queryNoticeTypeList(noticeTypeId,pageSize,pageNow);
    }

    public List<lims_notice> QueryNotice()
    {

        return notice_mapper.queryNotice();
    }

    public lims_notice queryNoticeId(int noticeId){
        return notice_mapper.queryNoticeId(noticeId);
    }

    public boolean CreateNoticeType(lims_notice_type notice_type)
    {
       return notice_mapper.CreateNoticeType(notice_type);
    }


    public boolean UpdateNoticeType(lims_notice_type notice_type)
    {
        return notice_mapper.UpdateNoticeType(notice_type);
    }


    public boolean CreateNotice(lims_notice notice)
    {
        return notice_mapper.CreateNotice(notice);
    }



}
