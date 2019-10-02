package cn.lhj.csp.assist.menu.po;

public class CspAdminMenu {
    private Integer id;

    private String name;
    
    private String pName;

    private Integer pId;

    private Integer isHidden;

    private String mainurl;

    private String icon;

    private String iconOpen;

    private String iconClose;

    private String fongCss;

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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }

    public String getMainurl() {
        return mainurl;
    }

    public void setMainurl(String mainurl) {
        this.mainurl = mainurl == null ? null : mainurl.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getIconOpen() {
        return iconOpen;
    }

    public void setIconOpen(String iconOpen) {
        this.iconOpen = iconOpen == null ? null : iconOpen.trim();
    }

    public String getIconClose() {
        return iconClose;
    }

    public void setIconClose(String iconClose) {
        this.iconClose = iconClose == null ? null : iconClose.trim();
    }

    public String getFongCss() {
        return fongCss;
    }

    public void setFongCss(String fongCss) {
        this.fongCss = fongCss == null ? null : fongCss.trim();
    }

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
    
}