package cn.lhj.csp.admin.po;

public class CspBackgroundMenu {
    private Integer id;

    private String name;

    private Integer pId;

    private String mainUrl;

    private String insertUrl;

    private String deleteUrl;

    private String updateUrl;

    private String selectUrl;

    private String tableName;

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

    public String getMainUrl() {
        return mainUrl;
    }

    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl == null ? null : mainUrl.trim();
    }

    public String getInsertUrl() {
        return insertUrl;
    }

    public void setInsertUrl(String insertUrl) {
        this.insertUrl = insertUrl == null ? null : insertUrl.trim();
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl == null ? null : deleteUrl.trim();
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl == null ? null : updateUrl.trim();
    }

    public String getSelectUrl() {
        return selectUrl;
    }

    public void setSelectUrl(String selectUrl) {
        this.selectUrl = selectUrl == null ? null : selectUrl.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
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
}