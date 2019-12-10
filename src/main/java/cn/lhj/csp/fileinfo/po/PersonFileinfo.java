package cn.lhj.csp.fileinfo.po;

public class PersonFileinfo {
	
    private Integer id;

    private Integer studentId;

    private Integer printOrderId;

    private String fileImage;

    private String fileName;

    private String path;

    private String time;

    private String fileSize;

    private Integer page;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPrintOrderId() {
        return printOrderId;
    }

    public void setPrintOrderId(Integer printOrderId) {
        this.printOrderId = printOrderId;
    }

    public String getFileImage() {
        return fileImage;
    }

    public void setFileImage(String fileImage) {
        this.fileImage = fileImage == null ? null : fileImage.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	@Override
	public String toString() {
		return "PersonFileinfo [id=" + id + ", studentId=" + studentId + ", printOrderId=" + printOrderId
				+ ", fileImage=" + fileImage + ", fileName=" + fileName + ", path=" + path + ", time=" + time
				+ ", fileSize=" + fileSize + ", page=" + page + ", status=" + status + "]";
	}
    
}