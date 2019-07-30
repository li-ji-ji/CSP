package cn.lhj.csp.config.po;

public class FolderInfo {
    private Integer id;

    private String name;

    private String icon;

    private Integer fid;

    
    public FolderInfo(Integer id, String name, String icon, Integer fid) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.fid = fid;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

	@Override
	public String toString() {
		return "FolderInfo [id=" + id + ", name=" + name + ", icon=" + icon + ", fid=" + fid + "]";
	}
    
}