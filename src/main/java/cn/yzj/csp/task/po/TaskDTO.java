package cn.yzj.csp.task.po;

public class TaskDTO {
	private Integer taskId;
	private String orderId;
	private String taskTitle;

	private String taskType;

	private String finishTime;

	private String taskPublisher;

	private String taskReceiver;

	private String taskStatus;

	private String publishTime;

	private Integer isloop;

	private double taskReward;

	private String publisherName;

	private String publisherNumber;
	private String taskContext;

	private String taskRemarks;

	private String images;

	public String getTaskContext() {
		return taskContext;
	}

	public void setTaskContext(String taskContext) {
		this.taskContext = taskContext;
	}

	public String getTaskRemarks() {
		return taskRemarks;
	}

	public void setTaskRemarks(String taskRemarks) {
		this.taskRemarks = taskRemarks;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getTaskPublisher() {
		return taskPublisher;
	}

	public void setTaskPublisher(String taskPublisher) {
		this.taskPublisher = taskPublisher;
	}

	public String getTaskReceiver() {
		return taskReceiver;
	}

	public void setTaskReceiver(String taskReceiver) {
		this.taskReceiver = taskReceiver;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getIsloop() {
		return isloop;
	}

	public void setIsloop(Integer isloop) {
		this.isloop = isloop;
	}

	public double getTaskReward() {
		return taskReward;
	}

	public void setTaskReward(Double taskReward) {
		this.taskReward = taskReward;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherNumber() {
		return publisherNumber;
	}

	public void setPublisherNumber(String publisherNumber) {
		this.publisherNumber = publisherNumber;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
