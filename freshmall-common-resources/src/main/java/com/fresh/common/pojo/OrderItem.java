package com.fresh.common.pojo;

public class OrderItem {
	private Long id;
	private String orderId;
	private String pid;
	private Integer num;
	private String pphoto;
	private String showName;
	private Double pscprice;

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setPphoto(String pphoto) {
        this.pphoto = pphoto;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public void setPscprice(Double pscprice) {
        this.pscprice = pscprice;
    }
}
