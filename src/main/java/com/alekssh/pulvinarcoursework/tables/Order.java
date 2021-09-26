package com.alekssh.pulvinarcoursework.tables;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @EmbeddedId
    private OrderId id;

    @Column(name = "nameProduct", length = 70)
    private String nameProduct;

    @Column(name = "colProduct")
    private Integer colProduct;

    @Column(name = "sumCost")
    private Integer sumCost;

    @Column(name = "deliveryAddress", length = 150)
    private String deliveryAddress;

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getSumCost() {
        return sumCost;
    }

    public void setSumCost(Integer sumCost) {
        this.sumCost = sumCost;
    }

    public Integer getColProduct() {
        return colProduct;
    }

    public void setColProduct(Integer colProduct) {
        this.colProduct = colProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public OrderId getId() {
        return id;
    }

    public void setId(OrderId id) {
        this.id = id;
    }
}