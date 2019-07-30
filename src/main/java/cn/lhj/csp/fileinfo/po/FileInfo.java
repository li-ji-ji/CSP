package cn.lhj.csp.fileinfo.po;

public class FileInfo {
	
    private Integer id;

    private String name;

    private String keyword;

    private String description;

    private String type;

    private Integer folderId;

    private String url;

    private String date;

    private String size;

    
    
    public FileInfo(Integer id, String name, String keyword, String description, String type, Integer folderId,
			String url, String date, String size) {
		super();
		this.id = id;
		this.name = name;
		this.keyword = keyword;
		this.description = description;
		this.type = type;
		this.folderId = folderId;
		this.url = url;
		this.date = date;
		this.size = size;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

	@Override
	public String toString() {
		return "FileInfo [id=" + id + ", name=" + name + ", keyword=" + keyword + ", description=" + description
				+ ", type=" + type + ", folderId=" + folderId + ", url=" + url + ", date=" + date + ", size=" + size
				+ "]";
	}
    
}