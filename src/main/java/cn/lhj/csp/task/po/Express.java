package cn.lhj.csp.task.po;

public class Express {
    private Integer id;

    private String textcontent;

    private String targetaddress;

    private String takeaddress;

    private Integer superiortaskId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextcontent() {
        return textcontent;
    }

    public void setTextcontent(String textcontent) {
        this.textcontent = textcontent == null ? null : textcontent.trim();
    }

    public String getTargetaddress() {
        return targetaddress;
    }

    public void setTargetaddress(String targetaddress) {
        this.targetaddress = targetaddress == null ? null : targetaddress.trim();
    }

    public String getTakeaddress() {
        return takeaddress;
    }

    public void setTakeaddress(String takeaddress) {
        this.takeaddress = takeaddress == null ? null : takeaddress.trim();
    }

    public Integer getSuperiortaskId() {
        return superiortaskId;
    }

    public void setSuperiortaskId(Integer superiortaskId) {
        this.superiortaskId = superiortaskId;
    }
}