package lims.demo.lims_Role.Model;

/**
 * 用户权限表
 */
public class lims_user_role {
    private int user_role_id;//主键
    private int user_id;//用户id
    private int role_id;//权限Id

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
