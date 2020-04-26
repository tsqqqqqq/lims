package lims.demo.lims_Project.Model;

/**
 * 项目表
 */
public class lims_project {
    private int project_id;//主键
    private String name;//项目名
    private String project_describe;//项目内容
    private int project_status;//项目状态
    private int audit_status;//审批状态
    private String create_date;//创建时间
    private String end_date;//结束时间
    private String approvalDesc;//描述审批情况

    public String getApprovalDesc() {
        return approvalDesc;
    }

    public void setApprovalDesc(String approvalDesc) {
        this.approvalDesc = approvalDesc;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject_describe() {
        return project_describe;
    }

    public void setProject_descirbe(String project_descirbe) {
        this.project_describe = project_descirbe;
    }

    public int getProject_status() {
        return project_status;
    }

    public void setProject_status(int project_status) {
        this.project_status = project_status;
    }

    public int getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(int audit_status) {
        this.audit_status = audit_status;
    }
}
