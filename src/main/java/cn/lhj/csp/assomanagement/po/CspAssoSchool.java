package cn.lhj.csp.assomanagement.po;

public class CspAssoSchool {
    private Integer id;

    private String schoolNo;

    private String schoolName;

    private String schoolAddress;

    private String schoolAddressProvince;

    private Integer schoolAddressProvinceId;

    private String schoolAddressCity;

    private Integer schoolAddressCityId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolNo() {
        return schoolNo;
    }

    public void setSchoolNo(String schoolNo) {
        this.schoolNo = schoolNo == null ? null : schoolNo.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress == null ? null : schoolAddress.trim();
    }

    public String getSchoolAddressProvince() {
        return schoolAddressProvince;
    }

    public void setSchoolAddressProvince(String schoolAddressProvince) {
        this.schoolAddressProvince = schoolAddressProvince == null ? null : schoolAddressProvince.trim();
    }

    public Integer getSchoolAddressProvinceId() {
        return schoolAddressProvinceId;
    }

    public void setSchoolAddressProvinceId(Integer schoolAddressProvinceId) {
        this.schoolAddressProvinceId = schoolAddressProvinceId;
    }

    public String getSchoolAddressCity() {
        return schoolAddressCity;
    }

    public void setSchoolAddressCity(String schoolAddressCity) {
        this.schoolAddressCity = schoolAddressCity == null ? null : schoolAddressCity.trim();
    }

    public Integer getSchoolAddressCityId() {
        return schoolAddressCityId;
    }

    public void setSchoolAddressCityId(Integer schoolAddressCityId) {
        this.schoolAddressCityId = schoolAddressCityId;
    }
}