package cn.yzj.shop.po;

public class WxNews {
    private Integer id;

    private String keyword;

    private String createtime;

    private String uptatetime;

    private String token;

    private String imgId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUptatetime() {
        return uptatetime;
    }

    public void setUptatetime(String uptatetime) {
        this.uptatetime = uptatetime == null ? null : uptatetime.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }
}