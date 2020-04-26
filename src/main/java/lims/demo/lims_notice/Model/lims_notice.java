package lims.demo.lims_notice.Model;

/**
 * 通知表
 */
public class lims_notice {
    private int notice_id;//主键
    private String title;//标题
    private String content;//内容
    private String notice_date;//通知时间
    private int notice_type_id;//通知类型

    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(String notice_date) {
        this.notice_date = notice_date;
    }

    public int getnotice_type_id() {
        return notice_type_id;
    }

    public void setnotice_type_id(int notice_type) {
        this.notice_type_id = notice_type;
    }
}
