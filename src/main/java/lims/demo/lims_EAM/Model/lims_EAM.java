package lims.demo.lims_EAM.Model;

/**
 * 资产管理表
 */
public class lims_EAM {
    private int EAM_id; //资产id
    private String lims_EAM_name;//资产名
    private String lims_EAM_describe;//资产描述
    private String lims_EAM_status;//资产状态
    private int EAM_menu_id;//资产类目

    public int getEAM_id() {
        return EAM_id;
    }

    public void setEAM_id(int EAM_id) {
        this.EAM_id = EAM_id;
    }

    public String getLims_EAM_name() {
        return lims_EAM_name;
    }

    public void setLims_EAM_name(String lims_EAM_name) {
        this.lims_EAM_name = lims_EAM_name;
    }

    public String getLims_EAM_describe() {
        return lims_EAM_describe;
    }

    public void setLims_EAM_describe(String lims_EAM_describe) {
        this.lims_EAM_describe = lims_EAM_describe;
    }

    public String getLims_EAM_status() {
        return lims_EAM_status;
    }

    public void setLims_EAM_status(String lims_EAM_status) {
        this.lims_EAM_status = lims_EAM_status;
    }

    public int getEAM_menu_id() {
        return EAM_menu_id;
    }

    public void setEAM_menu_id(int EAM_menu_id) {
        this.EAM_menu_id = EAM_menu_id;
    }
}
