package cn.yzj.shop.po;

import java.math.BigDecimal;

public class ReturnGoods {
    private Integer id;

    private Integer recId;

    private Integer orderId;

    private String orderSn;

    private Integer goodsId;

    private Integer goodsNum;

    private Boolean type;

    private String reason;

    private String describe;

    private String imgs;

    private Integer addtime;

    private Boolean status;

    private String remark;

    private Integer userId;

    private String specKey;

    private BigDecimal refundMoney;

    private BigDecimal refundDeposit;

    private Integer refundIntegral;

    private Boolean refundType;

    private String refundMark;

    private Integer refundTime;

    private Byte isReceive;

    private String sellerDelivery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSpecKey() {
        return specKey;
    }

    public void setSpecKey(String specKey) {
        this.specKey = specKey == null ? null : specKey.trim();
    }

    public BigDecimal getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
    }

    public BigDecimal getRefundDeposit() {
        return refundDeposit;
    }

    public void setRefundDeposit(BigDecimal refundDeposit) {
        this.refundDeposit = refundDeposit;
    }

    public Integer getRefundIntegral() {
        return refundIntegral;
    }

    public void setRefundIntegral(Integer refundIntegral) {
        this.refundIntegral = refundIntegral;
    }

    public Boolean getRefundType() {
        return refundType;
    }

    public void setRefundType(Boolean refundType) {
        this.refundType = refundType;
    }

    public String getRefundMark() {
        return refundMark;
    }

    public void setRefundMark(String refundMark) {
        this.refundMark = refundMark == null ? null : refundMark.trim();
    }

    public Integer getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Integer refundTime) {
        this.refundTime = refundTime;
    }

    public Byte getIsReceive() {
        return isReceive;
    }

    public void setIsReceive(Byte isReceive) {
        this.isReceive = isReceive;
    }

    public String getSellerDelivery() {
        return sellerDelivery;
    }

    public void setSellerDelivery(String sellerDelivery) {
        this.sellerDelivery = sellerDelivery == null ? null : sellerDelivery.trim();
    }
}