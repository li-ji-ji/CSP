package cn.yzj.shop.po;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class Config implements Serializable {
    private Short id;
    
    @NotBlank(message = "配置名称不能为空")
    private String name;
    @NotBlank(message = "配置内容不能为空")
    private String value;

    private String incType;

    private String remarks;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getIncType() {
        return incType;
    }

    public void setIncType(String incType) {
        this.incType = incType == null ? null : incType.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}