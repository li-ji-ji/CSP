package cn.lhj.csp.fileinfo.po;

import java.util.List;

public class PrintShop {
	
    private Integer id;

    private String name;

    private String location;

    private String status;
    
    private List<Printer> prints;
    
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public List<Printer> getPrints() {
		return prints;
	}

	public void setPrints(List<Printer> prints) {
		this.prints = prints;
	}

	@Override
	public String toString() {
		return "PrintShop [id=" + id + ", name=" + name + ", location=" + location + ", status=" + status + ", prints="
				+ prints + "]";
	}

}