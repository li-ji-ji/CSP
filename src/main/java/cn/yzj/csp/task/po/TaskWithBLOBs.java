package cn.yzj.csp.task.po;

public class TaskWithBLOBs extends Task {
    private String taskContext;

    private String taskRemarks;

    private String images;

    public String getTaskContext() {
        return taskContext;
    }

    public void setTaskContext(String taskContext) {
        this.taskContext = taskContext == null ? null : taskContext.trim();
    }

    public String getTaskRemarks() {
        return taskRemarks;
    }

    public void setTaskRemarks(String taskRemarks) {
        this.taskRemarks = taskRemarks == null ? null : taskRemarks.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }
}