package com.example.pulvinar.tables;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderId implements Serializable {
    private static final long serialVersionUID = -438080711189254608L;
    @Column(name = "idOrders", nullable = false)
    private Integer idOrders;
    @Column(name = "idUsers", nullable = false)
    private Integer idUsers;
    @Column(name = "idProduct", nullable = false)
    private Integer idProduct;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public Integer getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Integer idOrders) {
        this.idOrders = idOrders;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idUsers, idOrders);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderId entity = (OrderId) o;
        return Objects.equals(this.idProduct, entity.idProduct) &&
                Objects.equals(this.idUsers, entity.idUsers) &&
                Objects.equals(this.idOrders, entity.idOrders);
    }
}