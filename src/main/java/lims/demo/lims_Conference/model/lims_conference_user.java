package lims.demo.lims_Conference.model;

/**
 * 用户会议表 记录用户与会议的关系
 */
public class lims_conference_user {
    private int conference_user_id;
    private int user_id;
    private int conference_id;

    public int getConference_user_id() {
        return conference_user_id;
    }

    public void setConference_user_id(int conference_user_id) {
        this.conference_user_id = conference_user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getConference_id() {
        return conference_id;
    }

    public void setConference_id(int conference_id) {
        this.conference_id = conference_id;
    }
}
