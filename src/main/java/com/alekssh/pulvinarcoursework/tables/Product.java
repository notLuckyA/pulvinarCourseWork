package com.alekssh.pulvinarcoursework.tables;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct", nullable = false)
    private Integer id;

    @Column(name = "nameProduct", nullable = false, length = 70)
    private String nameProduct;

    @Column(name = "typeOfProduct", nullable = false, length = 70)
    private String typeOfProduct;

    @Column(name = "fillerPillows", length = 70)
    private String fillerPillows;

    @Column(name = "sizeProduct", length = 25)
    private String sizeProduct;

    @Column(name = "productPrice")
    private Integer productPrice;

    @Column(name = "linkImages", length = 150)
    private String linkImages;

    public String getLinkImages() {
        return linkImages;
    }

    public void setLinkImages(String linkImages) {
        this.linkImages = linkImages;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getSizeProduct() {
        return sizeProduct;
    }

    public void setSizeProduct(String sizeProduct) {
        this.sizeProduct = sizeProduct;
    }

    public String getFillerPillows() {
        return fillerPillows;
    }

    public void setFillerPillows(String fillerPillows) {
        this.fillerPillows = fillerPillows;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}