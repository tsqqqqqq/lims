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

    /**
     * 查询设备目录
     * @return
     */
    @Select("select * from lims_EAM_menu")
    public List<lims_EAM_menu> QueryEAM_menu();


    /**
     * 分页查询
     * @param pageSize
     * @param pageNow
     * @return
     */
    @Select("select e.*,em.inventory from lims_eam e inner join lims_eam_menu em on e.eam_menu_id = em.eam_menu_id  limit #{pageNow},#{pageSize}")
    public List<HashMap<String,Object>> QueryEAM(int pageSize,int pageNow);

    /**
     * 统计总数
     * @return
     */
    @Select("select count(EAM_id) from lims_eam")
    public int CountEam();

    /**
     * 查询设备类目状态
     * @param EAM_menu_Id
     * @return
     */
    @Select("select count(EAM_id) from lims_eam where EAM_menu_Id = #{EAM_menu_Id}")
    public int QueryInventoryEam(int EAM_menu_Id);


    /**
     * 修改类目状态
     * @param EAM_menu_id
     * @param inventory
     * @return
     */
    @Update("update  lims_EAM_menu set inventory = #{inventory} where EAM_menu_id = #{EAM_menu_id}")
    public boolean Update_EAM_menu_inventory(int EAM_menu_id,int inventory);


    /**
     *
     * @return
     */
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


    @Update("update lims_Eam set lims_EAM_name =#{name}, lims_EAM_status=#{status} where EAM_id=#{id}")
    public boolean updateEam(String name,String status,int id);


    @Delete("delete from lims_Eam where eam_id = #{id}")
    public boolean deleteEam(int id);
}
