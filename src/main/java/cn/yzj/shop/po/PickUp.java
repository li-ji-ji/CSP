package cn.yzj.shop.po;

import java.io.Serializable;

public class PickUp implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer pickupId;

    private String pickupName;

    private String pickupAddress;

    private String pickupPhone;

    private String pickupContact;

    private Integer provinceId;

    private Integer cityId;

    private Integer districtId;

    private Integer suppliersid;
    
    private String provinceName;
    
    private String cityName;
    
    private String districtName;

    public Integer getPickupId() {
        return pickupId;
    }

    public void setPickupId(Integer pickupId) {
        this.pickupId = pickupId;
    }

    public String getPickupName() {
        return pickupName;
    }

    public void setPickupName(String pickupName) {
        this.pickupName = pickupName == null ? null : pickupName.trim();
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress == null ? null : pickupAddress.trim();
    }

    public String getPickupPhone() {
        return pickupPhone;
    }

    public void setPickupPhone(String pickupPhone) {
        this.pickupPhone = pickupPhone == null ? null : pickupPhone.trim();
    }

    public String getPickupContact() {
        return pickupContact;
    }

    public void setPickupContact(String pickupContact) {
        this.pickupContact = pickupContact == null ? null : pickupContact.trim();
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getSuppliersid() {
        return suppliersid;
    }

    public void setSuppliersid(Integer suppliersid) {
        this.suppliersid = suppliersid;
    }

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PickUp [pickupId=" + pickupId + ", pickupName=" + pickupName + ", pickupAddress=" + pickupAddress
				+ ", pickupPhone=" + pickupPhone + ", pickupContact=" + pickupContact + ", provinceId=" + provinceId
				+ ", cityId=" + cityId + ", districtId=" + districtId + ", suppliersid=" + suppliersid
				+ ", provinceName=" + provinceName + ", cityName=" + cityName + ", districtName=" + districtName + "]";
	}

}