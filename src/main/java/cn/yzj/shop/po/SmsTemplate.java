package cn.yzj.shop.po;

public class SmsTemplate {
    private Integer tplId;

    private String smsSign;

    private String smsTplCode;

    private String tplContent;

    private String sendScene;

    private Integer addTime;

    public Integer getTplId() {
        return tplId;
    }

    public void setTplId(Integer tplId) {
        this.tplId = tplId;
    }

    public String getSmsSign() {
        return smsSign;
    }

    public void setSmsSign(String smsSign) {
        this.smsSign = smsSign == null ? null : smsSign.trim();
    }

    public String getSmsTplCode() {
        return smsTplCode;
    }

    public void setSmsTplCode(String smsTplCode) {
        this.smsTplCode = smsTplCode == null ? null : smsTplCode.trim();
    }

    public String getTplContent() {
        return tplContent;
    }

    public void setTplContent(String tplContent) {
        this.tplContent = tplContent == null ? null : tplContent.trim();
    }

    public String getSendScene() {
        return sendScene;
    }

    public void setSendScene(String sendScene) {
        this.sendScene = sendScene == null ? null : sendScene.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }
}