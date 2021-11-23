package com.alekssh.pulvinarcoursework.controllers;

import com.alekssh.pulvinarcoursework.Main;
import com.alekssh.pulvinarcoursework.functional.InterfaceDB;
import com.alekssh.pulvinarcoursework.tables.Product;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminAddProductScreen {
    public Label errorAddProduct;
    public TextField nameAdd;
    public TextField typeAdd;
    public TextField filterAdd;
    public TextField sizeAdd;
    public TextField costAdd;
    public Button btnAddProduct;
    public Button btnOutProduct;

    public void addProduct(ActionEvent actionEvent) throws IOException {
        if (nameAdd.getText().isBlank() || typeAdd.getText().isBlank()
                || filterAdd.getText().isBlank() || sizeAdd.getText().isBlank()
                || costAdd.getText().isBlank()) {
            errorAddProduct.setText("Неправильное заполнение");
        } else {
            try {
                InterfaceDB productCRUD = new InterfaceDB();
                Product product = new Product();
                if (productCRUD.findByName(nameAdd.getText()) == null) {
                    product.setNameProduct(nameAdd.getText());
                    product.setTypeOfProduct(typeAdd.getText());
                    product.setFillerPillows(filterAdd.getText());
                    product.setSizeProduct(sizeAdd.getText());
                    product.setProductPrice(Integer.valueOf(costAdd.getText()));
                    productCRUD.createProduct(product);
                    errorAddProduct.setText("Успешно!");
                } else {
                    errorAddProduct.setText("Название занято");
                }
            } catch (Exception e) {
                errorAddProduct.setText("GLOBAL ERROR");
            }
        }
    }

    public void goOut(ActionEvent actionEvent) throws IOException {
        Main.setRoot("AdminScreen");
    }
}
