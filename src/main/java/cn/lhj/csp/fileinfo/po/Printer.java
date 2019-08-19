package cn.lhj.csp.fileinfo.po;

public class Printer {
    private Integer id;

    private String printShopName;

    private String printName;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrintShopName() {
        return printShopName;
    }

    public void setPrintShopName(String printShopName) {
        this.printShopName = printShopName == null ? null : printShopName.trim();
    }

    public String getPrintName() {
        return printName;
    }

    public void setPrintName(String printName) {
        this.printName = printName == null ? null : printName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	@Override
	public String toString() {
		return "Printer [id=" + id + ", printShopName=" + printShopName + ", printName=" + printName + ", status="
				+ status + "]";
	}

}