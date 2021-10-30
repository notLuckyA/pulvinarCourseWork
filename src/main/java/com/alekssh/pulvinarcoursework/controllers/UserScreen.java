package com.alekssh.pulvinarcoursework.controllers;

import com.alekssh.pulvinarcoursework.Main;
import com.alekssh.pulvinarcoursework.functional.InterfaceDB;
import com.alekssh.pulvinarcoursework.tables.Order;
import com.alekssh.pulvinarcoursework.tables.OrderId;
import com.alekssh.pulvinarcoursework.tables.Product;
import com.alekssh.pulvinarcoursework.tables.User;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.util.List;

public class UserScreen {

    public TextField colProductInBasket;
    public Label productInBasket;
    public ToggleButton btnPickup;
    public TextField adressField;
    public ToggleButton btnCash;
    public ToggleButton btnCard;
    public Button btnOrder;
    public Button btnUserOut;
    public Button btnPillowsToBasket;
    public HBox adressBox;
    public ToggleButton btnSetAdress;
    public Label errorLabel;
    public Label sum;
    public Label textPayment;
    @FXML
    private TableView tableFromProduct;
    @FXML
    private TableColumn<Product, String> columnName, columnType, columnFilter, columnSize, columnCost;

    private String nameProduct;
    private int productPrice;
    private int idProduct;

    @FXML
    private void initialize() {
        unloadingToTables();
    }

    private void unloadingToTables() {
        List<Product> productList = InterfaceDB.selectFromProduct();
        columnName.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getNameProduct());
        });
        columnType.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getTypeOfProduct());
        });
        columnFilter.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getFillerPillows());
        });
        columnSize.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getSizeProduct());
        });
        columnCost.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getProductPrice().toString());
        });
        ObservableList<Product> tableProduct = FXCollections.observableList(productList);
        tableFromProduct.setItems(tableProduct);
    }

    private Product product;

    @FXML
    private void onMouseClicked() {
        int rowIndex = tableFromProduct.getSelectionModel().getFocusedIndex();
        product = (Product) tableFromProduct.getItems().get(rowIndex);
        idProduct = product.getId();
        nameProduct = product.getNameProduct();
        productPrice = product.getProductPrice();
    }

    public void addProductToBasket(ActionEvent actionEvent) throws IOException {
        productInBasket.setText(nameProduct);
        sum.setText(String.valueOf(productPrice));
    }

    public void revaluation(ActionEvent actionEvent) throws IOException {
        try {
            colProductInBasket.textProperty().addListener(
                    (observable, oldValue, newValue) -> sum.setText(String.valueOf(Integer.parseInt(newValue) * productPrice)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAdress(ActionEvent actionEvent) throws IOException {
        adressBox.setVisible(true);
    }

    public void hideAdress(ActionEvent actionEvent) throws IOException {
        adressBox.setVisible(false);
        adressField.setText("");
    }

    public void showCash(ActionEvent actionEvent) throws IOException {
        textPayment.setText("Наличными");
    }

    public void showBC(ActionEvent actionEvent) throws IOException {
        textPayment.setText("Банковской картой");
    }

//    public void createOrder(ActionEvent actionEvent) throws IOException {
//        try {
//            LoginScreen ls = new LoginScreen();
//            InterfaceDB orderCRUD = new InterfaceDB();
//            User user = orderCRUD.findByLogin(ls.loginTo.getText());
//            Order order = new Order();
//            OrderId orderId = new OrderId();
//            if (!productInBasket.equals("")) {
//                orderId.setIdUsers(1);
//                orderId.setIdProduct(Integer.valueOf(productInBasket.getId()));
//                order.setNameProduct(productInBasket.getText());
//                order.setColProduct(Integer.valueOf(colProductInBasket.getText()));
//                order.setSumCost(Integer.valueOf(sum.getText()));
//                order.setDeliveryAddress(adressField.getText());
//                orderCRUD.createOrders(order);
//                errorLabel.setText("Получилось");
//            } else {
//                errorLabel.setText("Не получилось");
//            }
//        } catch (Exception e) {
//            errorLabel.setText("Error");
//        }
//    }

    public void goOut(ActionEvent actionEvent) throws IOException {
        Main.setRoot("loginScreen");
    }
}