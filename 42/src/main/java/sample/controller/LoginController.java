package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Mapper;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {
    @FXML
    Button loginButton;
    @FXML
    Button logoutButton;
    @FXML
    public TextField userField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Label promptLabel;
    @FXML
    public Label jpgLabel;

    private Mapper mapper;
    private Stage stage;

    @FXML
    public void login() throws Exception {
        String user = userField.getText().replaceAll("\\s*", "");
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(passwordField.getText().getBytes(StandardCharsets.UTF_8));
        String password = new BigInteger(1, md.digest()).toString(16);
        Boolean is = mapper.login(user, password);
        if (is == null) {
            promptLabel.setText("(°ー°〃)哒嘞？");
        } else if (!Objects.equals(user, "") && is) {
            promptLabel.setText("(✿◡‿◡)达令~");
        } else {
            promptLabel.setText("（｀へ´）哒咩！");
        }
    }

    @FXML
    public void logout() throws SQLException {
        if (stage == null) {
            stage = (Stage) logoutButton.getScene().getWindow();
        }
        mapper.close();
        stage.close();
    }
    @FXML
    public void enroll() throws IOException {
        if (stage == null) {
            stage = (Stage) logoutButton.getScene().getWindow();
        }
        Parent root = FXMLLoader.load(getClass().getResource("/enroll.fxml"));
        stage.setScene(new Scene(root));
    }

    public void initialize() throws Exception {
        mapper = new Mapper();
        Image image = new Image("https://img.tt98.com/d/file/96kaifa/2018081420174327/5b63b5ceb2e8c.jpg", 310, 520, false, false);
        jpgLabel.setGraphic(new ImageView(image));
    }
}
