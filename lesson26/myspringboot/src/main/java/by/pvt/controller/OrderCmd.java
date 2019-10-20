package by.pvt.controller;

import java.io.Serializable;
import java.util.Date;

public class OrderCmd implements Serializable {

    private Long productId;
    private Double productPrice;
    private Integer itemCount;
    private String comment;
    private Date createDate;

    public OrderCmd() {
    }

    public OrderCmd(Long productId, Double productPrice, Integer itemCount, String comment, Date createDate) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.itemCount = itemCount;
        this.comment = comment;
        this.createDate = createDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", productId=" + productId +
                ", productPrice=" + productPrice +
                ", itemCount=" + itemCount +
                ", comment='" + comment + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
