package lims.demo.lims_Users.Model;

/**
 * 用户信息表
 */
public class lims_user_message {
    private int id ;//主键
    private String lims_user_message_name;//用户姓名
    private int lims_user_message_age;//用户年龄
    private String lims_user_message_sex;//用户性别
    private int users_id;//关联账号表


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLims_user_message_name() {
        return lims_user_message_name;
    }

    public void setLims_user_message_name(String lims_user_message_name) {
        this.lims_user_message_name = lims_user_message_name;
    }

    public int getLims_user_message_age() {
        return lims_user_message_age;
    }

    public void setLims_user_message_age(int lims_user_message_age) {
        this.lims_user_message_age = lims_user_message_age;
    }

    public String getLims_user_message_sex() {
        return lims_user_message_sex;
    }

    public void setLims_user_message_sex(String lims_user_message_sex) {
        this.lims_user_message_sex = lims_user_message_sex;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int user_id) {
        this.users_id = user_id;
    }
}
