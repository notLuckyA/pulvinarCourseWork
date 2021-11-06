package com.alekssh.pulvinarcoursework.controllers;

import com.alekssh.pulvinarcoursework.Main;
import com.alekssh.pulvinarcoursework.functional.InterfaceDB;
import com.alekssh.pulvinarcoursework.tables.Product;
import com.alekssh.pulvinarcoursework.tables.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.List;

public class AdminScreen {
    public Button btnAddUsers;
    public Button btnUpdateUsers;
    public Button btnDeleteUsers;
    public Button btnAddProduct;
    public Button btnUpdateProduct;
    public Button btnDeleteProduct;
    @FXML
    private TableView tablesAdminUsers;
    @FXML
    private TableColumn<User, String> columnNameUser, columnLastNameUser, columnEmailUser, columnTelUser, columnRoleUser;
    @FXML
    private TableView tablesAdminProduct;
    @FXML
    private TableColumn<Product, String> columnIdProduct, columnNameProduct, columnTypeProduct, columnFilterProduct, columnSizeProduct, columnCostProduct;

    @FXML
    private void initialize() {
        unloadingToTablesUsers();
        unloadingToTablesProduct();
    }

    private void unloadingToTablesUsers() {
        List<User> userList = InterfaceDB.selectFromUser();
        columnNameUser.setCellValueFactory((TableColumn.CellDataFeatures<User, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getName());
        });
        columnLastNameUser.setCellValueFactory((TableColumn.CellDataFeatures<User, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getLastname());
        });
        columnEmailUser.setCellValueFactory((TableColumn.CellDataFeatures<User, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getEmail());
        });
        columnTelUser.setCellValueFactory((TableColumn.CellDataFeatures<User, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getTelephone());
        });
        columnRoleUser.setCellValueFactory((TableColumn.CellDataFeatures<User, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getRole());
        });
        ObservableList<User> tableUser = FXCollections.observableList(userList);
        tablesAdminUsers.setItems(tableUser);
    }

    private void unloadingToTablesProduct() {
        List<Product> productList = InterfaceDB.selectFromProduct();
        columnIdProduct.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getId().toString());
        });
        columnNameProduct.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getNameProduct());
        });
        columnTypeProduct.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getTypeOfProduct());
        });
        columnFilterProduct.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getFillerPillows());
        });
        columnSizeProduct.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getSizeProduct());
        });
        columnCostProduct.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getProductPrice().toString());
        });
        ObservableList<Product> tableProduct = FXCollections.observableList(productList);
        tablesAdminProduct.setItems(tableProduct);
    }

    public void goAddUsers(ActionEvent actionEvent) throws IOException {
        Main.setRoot("adminAddUsesScreen");
    }

    public void goAddProduct(ActionEvent actionEvent) throws IOException {
        Main.setRoot("adminAddProductScreen");
    }

    public void goOut(ActionEvent actionEvent) throws IOException {
        Main.setRoot("loginScreen");
    }
}
