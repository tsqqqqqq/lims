package lims.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RDStest {


    @Select("Select  users from lims_users where users_id = 1; ")
    public String selectadmin();
}
