package cn.yzj.shop.po;

import java.io.Serializable;

public class PaymentWithBLOBs extends Payment implements Serializable{
    /*
	 *yzj
	 *2019
	 *2019年9月23日
	 */
	private static final long serialVersionUID = 1L;

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