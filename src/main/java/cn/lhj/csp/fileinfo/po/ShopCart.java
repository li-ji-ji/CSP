package cn.lhj.csp.fileinfo.po;

import java.util.List;

public class ShopCart {
    private Integer id;

    private String orderNo;

    private Float totalFee;

    private Integer studentId;

    private String status;

    private List<PrintOrder> printOrders;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Float totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public List<PrintOrder> getPrintOrders() {
		return printOrders;
	}

	public void setPrintOrders(List<PrintOrder> printOrders) {
		this.printOrders = printOrders;
	}

	@Override
	public String toString() {
		return "ShopCart [id=" + id + ", orderNo=" + orderNo + ", totalFee=" + totalFee + ", studentId=" + studentId
				+ ", status=" + status + ", printOrders=" + printOrders + "]";
	}
       
}