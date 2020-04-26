package lims.demo.lims_EAM.Mapper;

import lims.demo.lims_EAM.Model.lims_EAM;
import lims.demo.lims_EAM.Model.lims_EAM_menu;
import lims.demo.lims_EAM.Model.lims_EAM_out_return;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface EAM_Mapper {

    @Select("select * from lims_EAM_menu")
    public List<lims_EAM_menu> QueryEAM_menu();

    @Select("select e.*,em.inventory from lims_eam e inner join lims_eam_menu em on e.eam_menu_id = em.eam_menu_id  limit #{pageNow},#{pageSize}")
    public List<HashMap<String,Object>> QueryEAM(int pageSize,int pageNow);

    @Select("select count(EAM_id) from lims_eam")
    public int CountEam();

    @Select("select count(EAM_id) from lims_eam where EAM_menu_Id = #{EAM_menu_Id}")
    public int QueryInventoryEam(int EAM_menu_Id);

    @Update("update  lims_EAM_menu set inventory = #{inventory} where EAM_menu_id = #{EAM_menu_id}")
    public boolean Update_EAM_menu_inventory(int EAM_menu_id,int inventory);



    @Select("select EAM_menu_id , count(EAM_menu_id) as inventory from lims_eam where lims_EAM_status!=1 and EAM_id not in (select EAM_id from lims_eam_out_return) group by EAM_menu_id;")
    public List<lims_EAM_menu> QueryEAM_inventory();


    @Insert("insert into lims_eam_menu(name,EAM_menu_describe) value(#{name},#{EAM_menu_describe})")
    public boolean Insert_EAM_menu(lims_EAM_menu lims_eam_menu);


    @Insert("insert into lims_eam(lims_EAM_name,lims_EAM_describe,lims_EAM_status,EAM_menu_id) value(#{lims_EAM_name},#{lims_EAM_describe},0,#{EAM_menu_id})")
    public boolean Insert_EAM(lims_EAM lims_eam);


    @Insert("insert into lims_EAM_out_return(EAM_id,user_id,out_date,out_status) value(#{EAM_id},#{user_id},now(),#{out_status})")
    public boolean insert_EAM_out_return(lims_EAM_out_return lims_eam_out_return);


    @Update("update lims_EAM_out_return  set return_date = now() , return_status =#{return_status} where out_return_id =#{out_return_id}")
    public boolean Update_EAM_out_return(lims_EAM_out_return lims_eam_out_return);
}
