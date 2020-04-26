package lims.demo.lims_EAM.Model;

/**
 * 资产借出归还记录表
 */
public class lims_EAM_out_return {
    private int out_return_id; //主键
    private int EAM_id;//资产ID；
    private int user_id;//用户ID
    private String out_date;//借出时间
    private int out_status;//借出状态
    private String return_date;//归还时间
    private int return_status;//归还状态

    public int getOut_return_id() {
        return out_return_id;
    }

    public void setOut_return_id(int out_return_id) {
        this.out_return_id = out_return_id;
    }

    public int getEAM_id() {
        return EAM_id;
    }

    public void setEAM_id(int EAM_id) {
        this.EAM_id = EAM_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOut_date() {
        return out_date;
    }

    public void setOut_date(String out_date) {
        this.out_date = out_date;
    }

    public int getOut_status() {
        return out_status;
    }

    public void setOut_status(int out_status) {
        this.out_status = out_status;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public int getReturn_status() {
        return return_status;
    }

    public void setReturn_status(int return_status) {
        this.return_status = return_status;
    }
}
