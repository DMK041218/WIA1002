package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    Stage primaryStage;
    Scene scene1;
    Scene scene2;
    Scene scene3;
    Scene scene4;
    Scene scene5;
    Scene scene6;
    double locationX;
    double locationY;
    Label messageLabel;

    public Main() {
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Button button1 = new Button("Login");
        button1.setOnAction((e) -> {
            primaryStage.setScene(this.scene2);
        });
        Button button2 = new Button("Sign-Up");
        button2.setOnAction((e) -> {
            primaryStage.setScene(this.scene3);
        });
        Button button3 = new Button("Exit");
        button3.setOnAction((e) -> {
            primaryStage.close();
        });
        HBox layout1 = new HBox(10.0);
        layout1.getChildren().addAll(new Node[]{button1, button2, button3});
        layout1.setAlignment(Pos.CENTER);
        this.scene1 = new Scene(layout1, 500.0, 500.0);
        Button backToScene1 = new Button("Back");
        backToScene1.setOnAction((e) -> {
            primaryStage.setScene(this.scene1);
        });
        ChoiceBox<String> loginChoiceBox = new ChoiceBox();
        loginChoiceBox.getItems().addAll(new String[]{"Email", "Username"});
        loginChoiceBox.setValue("Email");
        Label loginLabel = new Label("Username or Email:");
        TextField loginField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        loginButton.setOnAction((e) -> {
            String loginType = loginChoiceBox.getValue(); // 获取选择的登录类型
            String loginValue = loginField.getText(); // 获取输入的用户名或邮箱
            String password = passwordField.getText(); // 获取输入的密码
            String query;
            if (loginType.equals("Email")) {
                query = "SELECT * FROM users WHERE email = ? AND password = ?";
            } else { // 默认为用户名
                query = "SELECT * FROM users WHERE username = ? AND password = ?";
            }

            // 执行查询
            if (this.authenticate(query, loginValue, password)) {
                this.showMessage("Login successful!");
                System.out.println("suscessfully");
            } else {
                this.showMessage("Login failed! Invalid " + loginType.toLowerCase() + " or password.");
                System.out.println("no");
                System.out.println(loginType.toLowerCase());
            }

        });
        GridPane layout2 = new GridPane();
        layout2.setPadding(new Insets(10.0));
        layout2.setHgap(10.0);
        layout2.setVgap(10.0);
        layout2.add(loginChoiceBox, 0, 0, 2, 1);
        layout2.add(loginLabel, 0, 1);
        layout2.add(loginField, 1, 1, 3, 1);
        layout2.add(backToScene1, 0, 4);
        layout2.add(passwordLabel, 0, 2);
        layout2.add(passwordField, 1, 2, 3, 1);
        layout2.add(loginButton, 0, 3);
        this.messageLabel = new Label();
        layout2.add(this.messageLabel, 1, 4);
        this.scene2 = new Scene(layout2, 500.0, 500.0);
        this.showMessage("Choose Your Role To Sign!!!");
        Button backToScene1Again = new Button("Back");
        backToScene1Again.setOnAction((e) -> {
            primaryStage.setScene(this.scene1);
        });
        Button asStudent = new Button("Young Student");
        asStudent.setOnAction((e) -> {
            primaryStage.setScene(this.scene4);
        });
        Button asParents = new Button("Parents");
        asParents.setOnAction((e) -> {
            primaryStage.setScene(this.scene5);
        });
        Button asEducator = new Button("Educator");
        asEducator.setOnAction((e) -> {
            primaryStage.setScene(this.scene6);
        });
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10.0);
        gridPane.setVgap(20.0);
        gridPane.add(this.messageLabel, 0, 0, 4, 1);
        gridPane.add(backToScene1Again, 0, 1);
        gridPane.add(asStudent, 1, 1);
        gridPane.add(asParents, 2, 1);
        gridPane.add(asEducator, 3, 1);
        this.messageLabel.setStyle("-fx-text-fill: blue;");
        this.scene3 = new Scene(gridPane, 500.0, 500.0);
        Label registerLabel4 = new Label("Young Student Registration");
        Label emailLabel4 = new Label("Email:");
        TextField emailField4 = new TextField();
        Label usernameLabel4 = new Label("Username:");
        TextField usernameField4 = new TextField();
        Label passwordLabel4 = new Label("Password:");
        PasswordField passwordField4 = new PasswordField();
        Label parentsLabel4 = new Label("Parents:");
        TextField parentsField4 = new TextField();
        Label currentPointsLabel4 = new Label("Current Points:");
        TextField currentPointsField4 = new TextField();
        Button registerButton4 = new Button("Register");
        registerButton4.setOnAction((e) -> {
            String email = emailField4.getText();
            String username = usernameField4.getText();
            String password = passwordField4.getText();
            String parents = parentsField4.getText();
            String currentPoints = currentPointsField4.getText();
        });
        Button backToScene1From4 = new Button("Back");
        backToScene1From4.setOnAction((e) -> {
            primaryStage.setScene(this.scene1);
        });
        GridPane gridPane4 = new GridPane();
        gridPane4.setAlignment(Pos.CENTER);
        gridPane4.setHgap(10.0);
        gridPane4.setVgap(20.0);
        gridPane4.add(registerLabel4, 0, 0, 2, 1);
        gridPane4.add(emailLabel4, 0, 1);
        gridPane4.add(emailField4, 1, 1, 3, 1);
        gridPane4.add(usernameLabel4, 0, 2);
        gridPane4.add(usernameField4, 1, 2, 3, 1);
        gridPane4.add(passwordLabel4, 0, 3);
        gridPane4.add(passwordField4, 1, 3, 3, 1);
        gridPane4.add(parentsLabel4, 0, 4);
        gridPane4.add(parentsField4, 1, 4, 3, 1);
        gridPane4.add(currentPointsLabel4, 0, 5);
        gridPane4.add(currentPointsField4, 1, 5, 3, 1);
        gridPane4.add(registerButton4, 0, 6);
        gridPane4.add(backToScene1From4, 0, 7);
        this.scene4 = new Scene(gridPane4, 500.0, 500.0);
        Label registerLabel5 = new Label("Parents Registration");
        Label emailLabel5 = new Label("Email:");
        TextField emailField5 = new TextField();
        Label usernameLabel5 = new Label("Username:");
        TextField usernameField5 = new TextField();
        Label passwordLabel5 = new Label("Password:");
        PasswordField passwordField5 = new PasswordField();
        Label childrenLabel5 = new Label("Children:");
        TextField childrenField5 = new TextField();
        Button registerButton5 = new Button("Register");
        registerButton5.setOnAction((e) -> {
            String email = emailField5.getText();
            String username = usernameField5.getText();
            String password = passwordField5.getText();
            String children = childrenField5.getText();
            this.showMessage("Successfully Signed Up");
        });
        Button backToScene1From5 = new Button("Back");
        backToScene1From5.setOnAction((e) -> {
            primaryStage.setScene(this.scene1);
        });
        GridPane gridPane5 = new GridPane();
        gridPane5.setAlignment(Pos.CENTER);
        gridPane5.setHgap(10.0);
        gridPane5.setVgap(20.0);
        gridPane5.add(registerLabel5, 0, 0, 2, 1);
        gridPane5.add(emailLabel5, 0, 1);
        gridPane5.add(emailField5, 1, 1, 3, 1);
        gridPane5.add(usernameLabel5, 0, 2);
        gridPane5.add(usernameField5, 1, 2, 3, 1);
        gridPane5.add(passwordLabel5, 0, 3);
        gridPane5.add(passwordField5, 1, 3, 3, 1);
        gridPane5.add(childrenLabel5, 0, 4);
        gridPane5.add(childrenField5, 1, 4, 3, 1);
        gridPane5.add(registerButton5, 0, 5);
        gridPane5.add(backToScene1From5, 0, 6);
        this.scene5 = new Scene(gridPane5, 500.0, 500.0);
        Label registerLabel6 = new Label("Educator Registration");
        Label emailLabel6 = new Label("Email:");
        TextField emailField6 = new TextField();
        Label usernameLabel6 = new Label("Username:");
        TextField usernameField6 = new TextField();
        Label passwordLabel6 = new Label("Password:");
        PasswordField passwordField6 = new PasswordField();
        Button registerButton6 = new Button("Register");
        registerButton6.setOnAction((e) -> {
            String email = emailField6.getText();
            String username = usernameField6.getText();
            String password = passwordField6.getText();
            this.showMessage("Successfully Signed Up");
        });
        Button backToScene1From6 = new Button("Back");
        backToScene1From6.setOnAction((e) -> {
            primaryStage.setScene(this.scene1);
        });
        GridPane gridPane6 = new GridPane();
        gridPane6.setAlignment(Pos.CENTER);
        gridPane6.setHgap(10.0);
        gridPane6.setVgap(20.0);
        gridPane6.add(registerLabel6, 0, 0, 2, 1);
        gridPane6.add(emailLabel6, 0, 1);
        gridPane6.add(emailField6, 1, 1, 3, 1);
        gridPane6.add(usernameLabel6, 0, 2);
        gridPane6.add(usernameField6, 1, 2, 3, 1);
        gridPane6.add(passwordLabel6, 0, 3);
        gridPane6.add(passwordField6, 1, 3, 3, 1);
        gridPane6.add(registerButton6, 0, 4);
        gridPane6.add(backToScene1From6, 0, 5);
        this.scene6 = new Scene(gridPane6, 500.0, 500.0);
        primaryStage.setScene(this.scene1);
        primaryStage.setTitle("Login/Registration Page");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private boolean authenticate(String query, String loginValue, String password) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String dbPassword = "password";

        try {
            Connection conn = DriverManager.getConnection(url, user, dbPassword);

            try {
                PreparedStatement pstmt = conn.prepareStatement(query);

                try {
                    pstmt.setString(1, loginValue); // 绑定用户名或邮箱
                    pstmt.setString(2, password); // 绑定密码
                    ResultSet rs = pstmt.executeQuery();

                    try {
                        return rs.next(); // 如果有匹配的用户，则返回 true，否则返回 false
                    } finally {
                        rs.close();
                    }
                } finally {
                    pstmt.close();
                }
            } finally {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    private void showMessage(String message) {
        this.messageLabel.setText(message);

    }
}