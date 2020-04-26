package lims.demo.lims_Role.Model;

/**
 * 权限表
 */
public class lims_role {
    private int role_id;//主键
    private String role_name;//权限名
    private String role_describe;//权限描述

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_describe() {
        return role_describe;
    }

    public void setRole_describe(String role_describe) {
        this.role_describe = role_describe;
    }
}
