package com.alekssh.pulvinarcoursework.controllers;

import com.alekssh.pulvinarcoursework.Main;
import com.alekssh.pulvinarcoursework.functional.InterfaceDB;
import com.alekssh.pulvinarcoursework.tables.Product;
import com.alekssh.pulvinarcoursework.tables.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminUpdateProductScreen {
    public Label errorUpdateProduct;
    public Button btnUpdateProduct;
    public Button btnOutProduct;
    @FXML
    public TextField nameUpdate;
    @FXML
    public TextField typeUpdate;
    @FXML
    public TextField filterUpdate;
    @FXML
    public TextField sizeUpdate;
    @FXML
    public TextField costUpdate;

    @FXML
    private void initialize() {
        nameUpdate.setText(AdminScreen.product.getNameProduct());
        typeUpdate.setText(AdminScreen.product.getTypeOfProduct());
        filterUpdate.setText(AdminScreen.product.getFillerPillows());
        sizeUpdate.setText(AdminScreen.product.getSizeProduct());
        costUpdate.setText(String.valueOf(AdminScreen.product.getProductPrice()));
    }

    public void updateProduct(ActionEvent actionEvent) {
        if (nameUpdate.getText().isBlank() || typeUpdate.getText().isBlank()
                || filterUpdate.getText().isBlank() || sizeUpdate.getText().isBlank()
                || costUpdate.getText().isBlank()) {
            errorUpdateProduct.setText("Пустые поля");
        } else {
            try {
                Product product = AdminScreen.product;
                product.setNameProduct(nameUpdate.getText());
                product.setTypeOfProduct(typeUpdate.getText());
                product.setFillerPillows(filterUpdate.getText());
                product.setSizeProduct(sizeUpdate.getText());
                product.setProductPrice(Integer.valueOf(costUpdate.getText()));

                InterfaceDB.updateProductr(product);
                errorUpdateProduct.setText("Успешно!");
            } catch (Exception e) {
                e.printStackTrace();
                errorUpdateProduct.setText("ERROR");
            }
        }
    }

    public void goOut(ActionEvent actionEvent) throws IOException {
        Main.setRoot("adminScreen");
    }
}
