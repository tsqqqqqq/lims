package lims.demo.lims_Project.Model;

/**
 * 项目参与人员
 */
public class lims_project_user {
    private int project_user_id;//主键
    private int user_id;//用户ID；
    private  int project_id;//项目ID

    public int getProject_user_id() {
        return project_user_id;
    }

    public void setProject_user_id(int project_user_id) {
        this.project_user_id = project_user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
