package sample.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Mapper;

import java.io.IOException;
import java.sql.SQLException;

public class EnrollController {
    @FXML
    public Label jpgLabel;

    private Mapper mapper;
    private Stage stage;
    @FXML
    public void enroll() {
    }

    @FXML
    public void logout() throws SQLException {
        if (stage == null) {
            stage = (Stage) jpgLabel.getScene().getWindow();
        }
        mapper.close();
        stage.close();
    }
    @FXML
    public void back() throws IOException {
        if (stage == null) {
            stage = (Stage) jpgLabel.getScene().getWindow();
        }
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        stage.setScene(new Scene(root));
    }

    public void initialize() throws Exception {
        mapper = new Mapper();
        Image image = new Image("https://tse3-mm.cn.bing.net/th/id/OIP-C._S02kFPETgTe3L2x58b2RAHaNf?w=185&h=337&c=7&r=0&o=5&dpr=1.25&pid=1.7", 310, 520, false, false);
        jpgLabel.setGraphic(new ImageView(image));
    }
}
