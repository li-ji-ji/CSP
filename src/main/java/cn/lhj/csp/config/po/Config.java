package cn.lhj.csp.config.po;

import java.io.Serializable;

public class Config implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String configKey;

    private String configValue;

    private String dataType;

    private String type;

    private String enable;

    public Config(Integer id, String configKey, String configValue, String dataType, String type, String enable) {
		super();
		this.id = id;
		this.configKey = configKey;
		this.configValue = configValue;
		this.dataType = dataType;
		this.type = type;
		this.enable = enable;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey == null ? null : configKey.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

	@Override
	public String toString() {
		return "Config [id=" + id + ", configKey=" + configKey + ", configValue=" + configValue + ", dataType="
				+ dataType + ", type=" + type + ", enable=" + enable + "]";
	}
    
    
}