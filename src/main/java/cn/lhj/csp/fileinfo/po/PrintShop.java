package cn.lhj.csp.fileinfo.po;

import java.util.List;

public class PrintShop {
    private Integer id;

    private String name;

    private String location;

    private String mobile;

    private String status;

    private String printerConfig;

    private String price;

    private String shopImage;
    
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPrinterConfig() {
        return printerConfig;
    }

    public void setPrinterConfig(String printerConfig) {
        this.printerConfig = printerConfig == null ? null : printerConfig.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage == null ? null : shopImage.trim();
    }

	public List<Printer> getPrints() {
		return prints;
	}

	public void setPrints(List<Printer> prints) {
		this.prints = prints;
	}

	@Override
	public String toString() {
		return "PrintShop [id=" + id + ", name=" + name + ", location=" + location + ", mobile=" + mobile + ", status="
				+ status + ", printerConfig=" + printerConfig + ", price=" + price + ", shopImage=" + shopImage
				+ ", prints=" + prints + "]";
	}

}