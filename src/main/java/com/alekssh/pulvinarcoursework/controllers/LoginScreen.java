package com.alekssh.pulvinarcoursework.controllers;

import com.alekssh.pulvinarcoursework.Main;
import com.alekssh.pulvinarcoursework.functional.InterfaceDB;
import com.alekssh.pulvinarcoursework.tables.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginScreen {
    public Button btnLogin;
    public TextField loginField;
    public PasswordField passwordField;
    public Button btnToRegistation;
    public Label errorLoginText;

    protected static String login;

    public void authorization(ActionEvent actionEvent) throws IOException {
        InterfaceDB userCRUD = new InterfaceDB();
        if (!loginField.getText().equals("") && !passwordField.getText().equals("")) {
            try {
                User user = userCRUD.findByLogin(loginField.getText());
                if (loginField.getText().equals(user.getLogin()) && passwordField.getText().equals(user.getPassword())) {
                    login = user.getLogin();
                    if (user.getRole().equals("user")) {
                        Main.setRoot("userScreen");
                    } else if (user.getRole().equals("admin")) {
                        Main.setRoot("adminScreen");
                    }
                } else {
                    errorLoginText.setText("Неверный логин или пароль");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            errorLoginText.setText("Пустые поля");
        }
    }
    public void registration(ActionEvent actionEvent) throws IOException {
        Main.setRoot("registrationScreen");
    }
}
