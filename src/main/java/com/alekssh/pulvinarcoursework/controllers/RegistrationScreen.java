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

public class RegistrationScreen {

    public TextField registrationName;
    public TextField registrationLastName;
    public TextField registrationEmail;
    public TextField registrationTel;
    public TextField registrationLogin;
    public PasswordField registrationPassword;
    public Button btnRegistration;
    public Button btnBack;
    public Label errorRegistrationText;


    public void rigistrationUser(ActionEvent actionEvent) throws IOException {
        if (registrationName.getText().isBlank() || registrationLastName.getText().isBlank()
                || registrationEmail.getText().isBlank() || registrationTel.getText().isBlank()
                || registrationLogin.getText().isBlank() || registrationPassword.getText().isBlank()) {
            errorRegistrationText.setText("Неправильное заполнение");
        } else {
            try {
                InterfaceDB userCRUD = new InterfaceDB();
                User user = new User();
                if (userCRUD.findByLogin(registrationLogin.getText()) == null) {
                    user.setName(registrationName.getText());
                    user.setLastname(registrationLastName.getText());
                    user.setEmail(registrationEmail.getText());
                    user.setTelephone(registrationTel.getText());
                    user.setLogin(registrationLogin.getText());
                    user.setPassword(registrationPassword.getText());
                    user.setRole("user");
                    userCRUD.createUser(user);
                    Main.setRoot("loginScreen");
                } else {
                    errorRegistrationText.setText("Логин занят");
                }
            } catch (Exception e) {
                errorRegistrationText.setText("GLOBAL ERROR");
            }
        }
    }

    public void goOut(ActionEvent actionEvent) throws IOException {
        Main.setRoot("loginScreen");
    }
}