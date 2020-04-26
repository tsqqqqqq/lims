package lims.demo.lims_notice.Model;

/**
 * 通知类型表
 */
public class lims_notice_type {

    private int notice_type_id;//主键
    private String name;//类型名
    private String notice_type_describe;//类型描述

    public int getNotice_type_id() {
        return notice_type_id;
    }

    public void setNotice_type_id(int notice_type_id) {
        this.notice_type_id = notice_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotice_type_describe() {
        return notice_type_describe;
    }

    public void setNotice_type_describe(String notice_type_describe) {
        this.notice_type_describe = notice_type_describe;
    }
}
