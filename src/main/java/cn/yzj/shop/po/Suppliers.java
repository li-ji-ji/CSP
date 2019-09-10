package cn.yzj.shop.po;

public class Suppliers {
    private Short suppliersId;

    private String suppliersName;

    private Boolean isCheck;

    private String suppliersContacts;

    private String suppliersPhone;

    private Integer provinceId;

    private Integer cityId;

    private String suppliersDesc;

    public Short getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(Short suppliersId) {
        this.suppliersId = suppliersId;
    }

    public String getSuppliersName() {
        return suppliersName;
    }

    public void setSuppliersName(String suppliersName) {
        this.suppliersName = suppliersName == null ? null : suppliersName.trim();
    }

    public Boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Boolean isCheck) {
        this.isCheck = isCheck;
    }

    public String getSuppliersContacts() {
        return suppliersContacts;
    }

    public void setSuppliersContacts(String suppliersContacts) {
        this.suppliersContacts = suppliersContacts == null ? null : suppliersContacts.trim();
    }

    public String getSuppliersPhone() {
        return suppliersPhone;
    }

    public void setSuppliersPhone(String suppliersPhone) {
        this.suppliersPhone = suppliersPhone == null ? null : suppliersPhone.trim();
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

    public String getSuppliersDesc() {
        return suppliersDesc;
    }

    public void setSuppliersDesc(String suppliersDesc) {
        this.suppliersDesc = suppliersDesc == null ? null : suppliersDesc.trim();
    }
}