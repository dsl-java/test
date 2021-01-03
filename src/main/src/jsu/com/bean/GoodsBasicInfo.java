package jsu.com.bean;

public class GoodsBasicInfo {
    private Integer goodsId;
    private String goodsName;
    private String goodsType;
    private Integer goodsStock;
    private Double goodsPrice;
    private Integer provider_id;

    public GoodsBasicInfo() {
    }

    public GoodsBasicInfo(Integer goodsId, String goodsName, String goodsType, Integer goodsStock, Double goodsPrice, Integer provider_id) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.goodsStock = goodsStock;
        this.goodsPrice = goodsPrice;
        this.provider_id = provider_id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(Integer provider_id) {
        this.provider_id = provider_id;
    }

    @Override
    public String toString() {
        return "GoodsBasicInfo{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsStock=" + goodsStock +
                ", goodsPrice=" + goodsPrice +
                ", provider_id=" + provider_id +
                '}';
    }
}
