package jsu.com.bean;

public class Orders {
    private Integer orderId;
    private String orderType;
    private String trade;
    private String orderGoodsId;
    private Integer orderCount;

    public Orders() {
    }

    public Orders(Integer orderId, String orderType, String trade, String orderGoodsId, Integer orderCount) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.trade = trade;
        this.orderGoodsId = orderGoodsId;
        this.orderCount = orderCount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(String orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderType='" + orderType + '\'' +
                ", trade='" + trade + '\'' +
                ", orderGoodsId='" + orderGoodsId + '\'' +
                ", orderCount=" + orderCount +
                '}';
    }
}
