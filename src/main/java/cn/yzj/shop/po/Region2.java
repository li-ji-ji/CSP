package cn.yzj.shop.po;

/**
 * 地区2
 * @author syf
 *
 */
public class Region2 {
    private Integer id;

    private String name;

    private Integer parentId;

    private Integer level;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Region2 [id=" + id + ", name=" + name + ", parentId=" + parentId + ", level=" + level + "]";
	}

}