package cn.yzj.csp.task.po;

public class Task {
    private Integer taskId;

    private String orderId;

    private String taskTitle;

    private Integer taskType;

    private String finishTime;

    private Integer taskPublisher;

    private Integer taskReceiver;

    private Integer taskStatus;

    private String publishTime;

    private String prepayId;

    private Integer taskReward;

    private String publisherName;

    private String publisherNumber;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle == null ? null : taskTitle.trim();
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime == null ? null : finishTime.trim();
    }

    public Integer getTaskPublisher() {
        return taskPublisher;
    }

    public void setTaskPublisher(Integer taskPublisher) {
        this.taskPublisher = taskPublisher;
    }

    public Integer getTaskReceiver() {
        return taskReceiver;
    }

    public void setTaskReceiver(Integer taskReceiver) {
        this.taskReceiver = taskReceiver;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime == null ? null : publishTime.trim();
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
    }

    public Integer getTaskReward() {
        return taskReward;
    }

    public void setTaskReward(Integer taskReward) {
        this.taskReward = taskReward;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName == null ? null : publisherName.trim();
    }

    public String getPublisherNumber() {
        return publisherNumber;
    }

    public void setPublisherNumber(String publisherNumber) {
        this.publisherNumber = publisherNumber == null ? null : publisherNumber.trim();
    }
}