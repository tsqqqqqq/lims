package lims.demo.lims_Conference.model;

/**
 * 会议表
 */
public class lims_conference {
    private int conference_id; //会议ID
    private String name;  //会议名称
    private String content; //会议内容
    private String addr;  //会议地址
    private String conference_date; //会议时间

    public int getConference_id() {
        return conference_id;
    }

    public void setConference_id(int conference_id) {
        this.conference_id = conference_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getConference_date() {
        return conference_date;
    }

    public void setConference_date(String conference_date) {
        this.conference_date = conference_date;
    }
}
