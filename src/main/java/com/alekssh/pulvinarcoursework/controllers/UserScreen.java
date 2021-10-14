package com.alekssh.pulvinarcoursework.controllers;

import com.alekssh.pulvinarcoursework.Main;
import com.alekssh.pulvinarcoursework.functional.InterfaceDB;
import com.alekssh.pulvinarcoursework.tables.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.List;

public class UserScreen {

    public Label pillowsInBasket;
    public Label colPillowsInBasket;
    public Label pillowcaseInBasket;
    public Label colPillowcaseInBasket;
    public ToggleButton btnPickup;
    public TextField adressField;
    public ToggleButton btnCash;
    public ToggleButton btnCard;
    public Button btnOrder;
    public Button btnUserOut;
    public Button btnPillowsToBasket;
    @FXML
    private TableView tableFromProduct;
    @FXML
    private TableColumn<Product, String> columnName, columnType, columnFilter, columnSize, columnCost;

//    public static Product product;

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

    public void goOut(ActionEvent actionEvent) throws IOException {
        Main.setRoot("loginScreen");
    }

}
