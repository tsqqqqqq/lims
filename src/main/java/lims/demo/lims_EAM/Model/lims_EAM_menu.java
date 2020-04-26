package lims.demo.lims_EAM.Model;

/**
 * 设备类目表
 */
public class lims_EAM_menu {
    private int EAM_menu_id;//主键
    private String name;//名称
    private String EAM_menu_describe;//描述
    private int inventory;//库存

    public int getEAM_menu_id() {
        return EAM_menu_id;
    }

    public void setEAM_menu_id(int EAM_menu_id) {
        this.EAM_menu_id = EAM_menu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEAM_menu_describe() {
        return EAM_menu_describe;
    }

    public void setEAM_menu_describe(String EAM_menu_describe) {
        this.EAM_menu_describe = EAM_menu_describe;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
