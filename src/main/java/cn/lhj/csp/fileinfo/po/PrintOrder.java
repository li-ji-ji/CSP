package cn.lhj.csp.fileinfo.po;

public class PrintOrder {
	
    private Integer id;

    private String orderNo;

    private Integer studentId;

    private String nickName;

    private String orderImage;

    private String fileName;

    private String color;

    private String paper;

    private String side;

    private String printMode;

    private String printCopy;

    private String deliveryMode;

    private String orderTime;

    private Integer page;

    private String isUrgent;

    private Float price;

    private String note;

    private String contact;

    private String mobile;

    private String storeAddress;

    private String deliveryAddress;

    private String status;

    private String filePath;

    
    
    public PrintOrder(Integer id, String orderNo, Integer studentId, String nickName, String orderImage,
			String fileName, String color, String paper, String side, String printMode, String printCopy,
			String deliveryMode, String orderTime, Integer page, String isUrgent, Float price, String note,
			String contact, String mobile, String storeAddress, String deliveryAddress, String status,
			String filePath) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.studentId = studentId;
		this.nickName = nickName;
		this.orderImage = orderImage;
		this.fileName = fileName;
		this.color = color;
		this.paper = paper;
		this.side = side;
		this.printMode = printMode;
		this.printCopy = printCopy;
		this.deliveryMode = deliveryMode;
		this.orderTime = orderTime;
		this.page = page;
		this.isUrgent = isUrgent;
		this.price = price;
		this.note = note;
		this.contact = contact;
		this.mobile = mobile;
		this.storeAddress = storeAddress;
		this.deliveryAddress = deliveryAddress;
		this.status = status;
		this.filePath = filePath;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(String orderImage) {
        this.orderImage = orderImage == null ? null : orderImage.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper == null ? null : paper.trim();
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side == null ? null : side.trim();
    }

    public String getPrintMode() {
        return printMode;
    }

    public void setPrintMode(String printMode) {
        this.printMode = printMode == null ? null : printMode.trim();
    }

    public String getPrintCopy() {
        return printCopy;
    }

    public void setPrintCopy(String printCopy) {
        this.printCopy = printCopy == null ? null : printCopy.trim();
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode == null ? null : deliveryMode.trim();
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(String isUrgent) {
        this.isUrgent = isUrgent == null ? null : isUrgent.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

	@Override
	public String toString() {
		return "PrintOrder [id=" + id + ", orderNo=" + orderNo + ", studentId=" + studentId + ", nickName=" + nickName
				+ ", orderImage=" + orderImage + ", fileName=" + fileName + ", color=" + color + ", paper=" + paper
				+ ", side=" + side + ", printMode=" + printMode + ", printCopy=" + printCopy + ", deliveryMode="
				+ deliveryMode + ", orderTime=" + orderTime + ", page=" + page + ", isUrgent=" + isUrgent + ", price="
				+ price + ", note=" + note + ", contact=" + contact + ", mobile=" + mobile + ", storeAddress="
				+ storeAddress + ", deliveryAddress=" + deliveryAddress + ", status=" + status + ", filePath="
				+ filePath + "]";
	}
    
}