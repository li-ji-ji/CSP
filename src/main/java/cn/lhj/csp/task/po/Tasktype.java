package cn.lhj.csp.task.po;

public class Tasktype {
    private Integer tasktypeId;

    private String tasktypeName;

    private Integer tasktypeWeight;

    private Integer tasktypeStatus;

    public Integer getTasktypeId() {
        return tasktypeId;
    }

    public void setTasktypeId(Integer tasktypeId) {
        this.tasktypeId = tasktypeId;
    }

    public String getTasktypeName() {
        return tasktypeName;
    }

    public void setTasktypeName(String tasktypeName) {
        this.tasktypeName = tasktypeName == null ? null : tasktypeName.trim();
    }

    public Integer getTasktypeWeight() {
        return tasktypeWeight;
    }

    public void setTasktypeWeight(Integer tasktypeWeight) {
        this.tasktypeWeight = tasktypeWeight;
    }

    public Integer getTasktypeStatus() {
        return tasktypeStatus;
    }

    public void setTasktypeStatus(Integer tasktypeStatus) {
        this.tasktypeStatus = tasktypeStatus;
    }
}