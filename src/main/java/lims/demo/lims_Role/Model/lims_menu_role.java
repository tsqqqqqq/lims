package lims.demo.lims_Role.Model;

/**
 * 目录权限表
 */
public class lims_menu_role {
    private int menu_role_id;//主键
    private int menu_id;//目录ID
    private int role_id;//权限ID

    public int getMenu_role_id() {
        return menu_role_id;
    }

    public void setMenu_role_id(int menu_role_id) {
        this.menu_role_id = menu_role_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
