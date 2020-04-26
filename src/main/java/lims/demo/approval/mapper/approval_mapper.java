package lims.demo.approval.mapper;

import lims.demo.approval.lims_approval;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface approval_mapper {

    @Select("select * from lims_approval limit #{pageNow},#{pageSize}")
    public List<lims_approval>  list(int pageSize,int pageNow);

    @Update("update  lims_approval set status=#{status} , approvalDescribe=#{approvalDescribe} , approvalDate=now() where id=#{id}")
    public boolean  updateApproval(lims_approval limsApproval);

    @Select("select * from lims_approval where id = #{approvalId}")
    public lims_approval queryApproval(int approvalId);

}
