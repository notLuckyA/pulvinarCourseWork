package com.alekssh.pulvinarcoursework.controllers;

import com.alekssh.pulvinarcoursework.Main;
import com.alekssh.pulvinarcoursework.functional.InterfaceDB;
import com.alekssh.pulvinarcoursework.tables.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminUpdateUserScreen {
    public Label errorUpdateUsers;
    public Button btnUpdateUsers;
    public Button btnOutUsers;
    @FXML
    public TextField loginUpdate;
    @FXML
    public TextField passwordUpdate;
    @FXML
    public TextField firstNameUpdate;
    @FXML
    public TextField lastNameUpdate;
    @FXML
    public TextField eMailUpdate;
    @FXML
    public TextField telUpdate;
    @FXML
    public TextField roleUpdate;

    @FXML
    private void initialize() {
        loginUpdate.setText(AdminScreen.user.getLogin());
        passwordUpdate.setText(AdminScreen.user.getPassword());
        firstNameUpdate.setText(AdminScreen.user.getName());
        lastNameUpdate.setText(AdminScreen.user.getLastname());
        eMailUpdate.setText(AdminScreen.user.getEmail());
        telUpdate.setText(AdminScreen.user.getTelephone());
        roleUpdate.setText(AdminScreen.user.getRole());
    }

    public void updateUser(ActionEvent actionEvent) {
        if (loginUpdate.getText().isBlank() || passwordUpdate.getText().isBlank()
                || eMailUpdate.getText().isBlank() || telUpdate.getText().isBlank()
                || firstNameUpdate.getText().isBlank() || lastNameUpdate.getText().isBlank()
                || roleUpdate.getText().isBlank()) {
            errorUpdateUsers.setText("Пустые поля");
        } else {
            try {
                User user = AdminScreen.user;
                user.setLogin(loginUpdate.getText());
                user.setPassword(passwordUpdate.getText());
                user.setEmail(eMailUpdate.getText());
                user.setTelephone(telUpdate.getText());
                user.setName(firstNameUpdate.getText());
                user.setLastname(lastNameUpdate.getText());
                user.setRole(roleUpdate.getText());

                InterfaceDB.updateUser(user);
                errorUpdateUsers.setText("Успешно!");
            } catch (Exception e) {
                e.printStackTrace();
                errorUpdateUsers.setText("ERROR");
            }
        }
    }

    public void goOut(ActionEvent actionEvent) throws IOException {
        Main.setRoot("adminScreen");
    }
}
