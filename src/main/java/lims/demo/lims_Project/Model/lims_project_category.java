package lims.demo.lims_Project.Model;

/**
 * 项目设备
 */
public class lims_project_category {
        private int project_category_id;//主键
        private int project_id;//项目id
        private int EAM_menu_id;//设备种类ID

    public int getProject_category_id() {
        return project_category_id;
    }

    public void setProject_category_id(int project_category_id) {
        this.project_category_id = project_category_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getEAM_menu_id() {
        return EAM_menu_id;
    }

    public void setEAM_menu_id(int EAM_menu_id) {
        this.EAM_menu_id = EAM_menu_id;
    }
}
