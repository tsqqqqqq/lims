package lims.demo.lims_Users.Model;

/**
 * 考勤表
 */
public class lims_personnel {
        private int personnel_id;//主键
        private String lims_personnel_check;//考勤日期
        private int lims_personnel_status;//考勤状态
        private int user_id;//用户

    public int getPersonnel_id() {
        return personnel_id;
    }

    public void setPersonnel_id(int personnel_id) {
        this.personnel_id = personnel_id;
    }

    public String getLims_personnel_check() {
        return lims_personnel_check;
    }

    public void setLims_personnel_check(String lims_personnel_check) {
        this.lims_personnel_check = lims_personnel_check;
    }

    public int getLims_personnel_status() {
        return lims_personnel_status;
    }

    public void setLims_personnel_status(int lims_personnel_status) {
        this.lims_personnel_status = lims_personnel_status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
