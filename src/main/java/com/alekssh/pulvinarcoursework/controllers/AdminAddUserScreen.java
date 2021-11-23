package com.alekssh.pulvinarcoursework.controllers;

import com.alekssh.pulvinarcoursework.Main;
import com.alekssh.pulvinarcoursework.functional.InterfaceDB;
import com.alekssh.pulvinarcoursework.tables.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminAddUserScreen {

    public TextField firstNameAdd;
    public TextField lastNameAdd;
    public TextField eMailAdd;
    public TextField telAdd;
    public TextField loginAdd;
    public TextField passwordAdd;
    public TextField roleAdd;
    public Button btnAddUsers;
    public Button btnOutUsers;
    public Label errorAddUser;

    public void addUser(ActionEvent actionEvent) throws IOException {
        if (firstNameAdd.getText().isBlank() || lastNameAdd.getText().isBlank()
                || eMailAdd.getText().isBlank() || telAdd.getText().isBlank()
                || loginAdd.getText().isBlank() || passwordAdd.getText().isBlank()
                || roleAdd.getText().isBlank()) {
            errorAddUser.setText("Неправильное заполнение");
        } else {
            try {
                InterfaceDB userCRUD = new InterfaceDB();
                User user = new User();
                if (userCRUD.findByLogin(loginAdd.getText()) == null) {
                    user.setName(firstNameAdd.getText());
                    user.setLastname(lastNameAdd.getText());
                    user.setEmail(eMailAdd.getText());
                    user.setTelephone(telAdd.getText());
                    user.setLogin(loginAdd.getText());
                    user.setPassword(passwordAdd.getText());
                    user.setRole(roleAdd.getText());
                    userCRUD.createUser(user);
                    errorAddUser.setText("Успешно!");
                } else {
                    errorAddUser.setText("Логин занят");
                }
            } catch (Exception e) {
                errorAddUser.setText("GLOBAL ERROR");
            }
        }
    }

    public void goOut(ActionEvent actionEvent) throws IOException {
        Main.setRoot("AdminScreen");
    }
}
