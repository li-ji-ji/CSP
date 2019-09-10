package cn.yzj.shop.po;

public class PaymentWithBLOBs extends Payment {
    private String payDesc;

    private String payConfig;

    public String getPayDesc() {
        return payDesc;
    }

    public void setPayDesc(String payDesc) {
        this.payDesc = payDesc == null ? null : payDesc.trim();
    }

    public String getPayConfig() {
        return payConfig;
    }

    public void setPayConfig(String payConfig) {
        this.payConfig = payConfig == null ? null : payConfig.trim();
    }
}