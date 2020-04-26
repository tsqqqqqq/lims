package lims.demo.approval;


/**
 * 审批表
 */
public class lims_approval {
    private int id ;//id主键
    private String approvalName;//审批事件名
    private String status;//审批状态
    private String approvalDate;//审批时间
    private String approvalDescribe;//审批备注

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovalDescribe() {
        return approvalDescribe;
    }

    public void setApprovalDescribe(String approvalDescribe) {
        this.approvalDescribe = approvalDescribe;
    }
}
