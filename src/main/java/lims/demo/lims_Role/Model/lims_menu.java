package lims.demo.lims_Role.Model;

/**
 * 功能目录
 */
public class lims_menu {
    private int menu_id;//主键
    private String lims_menu_name;//目录名
    private String lims_menu_path;//目录路径
    private String lims_menu_descirbe;//目录描述
    private String lims_menu_icon;//目录图标

    public String getLims_menu_icon() {
        return lims_menu_icon;
    }

    public void setLims_menu_icon(String lims_menu_icon) {
        this.lims_menu_icon = lims_menu_icon;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getLims_menu_name() {
        return lims_menu_name;
    }

    public void setLims_menu_name(String lims_menu_name) {
        this.lims_menu_name = lims_menu_name;
    }

    public String getLims_menu_path() {
        return lims_menu_path;
    }

    public void setLims_menu_path(String lims_menu_path) {
        this.lims_menu_path = lims_menu_path;
    }

    public String getLims_menu_descirbe() {
        return lims_menu_descirbe;
    }

    public void setLims_menu_descirbe(String lims_menu_descirbe) {
        this.lims_menu_descirbe = lims_menu_descirbe;
    }
}
