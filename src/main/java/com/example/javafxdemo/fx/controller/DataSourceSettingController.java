package com.example.javafxdemo.fx.controller;

import com.example.javafxdemo.service.YourService;
import com.example.javafxdemo.util.SpringUtils;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: #{auth}
 * @Mail: #{email}
 * @Date: 2023/11/06
 * @Version: 1.0
 * @Description: 数据源配置页面
 */
@FXMLController
@Component
public class DataSourceSettingController {

    @FXML
    private Stage stage;

    @FXML
    private JFXTextField dbUrlTextField;

    @FXML
    private JFXTextField portTextField;

    @FXML
    private JFXTextField dbNameTextField;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXPasswordField passwordField;



    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    void minimize(ActionEvent event) {
        stage.setIconified(true);
    }

    @FXML
    void close(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("确认关闭");
        alert.setHeaderText("关闭窗口");
        alert.setContentText("关闭后设备数据读取将会停止，确认关闭吗？");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            stage.close();
        }
    }

    @FXML
    void save(ActionEvent event) {
        String dbUrl = dbUrlTextField.getText();
        String port = portTextField.getText();
        String dbName = dbNameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        YourService yourService = SpringUtils.getBean(YourService.class);
        yourService.saveDatabaseInfoToRedis(String.format("%s : %s : %s : %s", dbUrl,port,username,password));
        // 在这里处理保存逻辑，可以将这些值存入数据库或者进行其他操作
        System.out.println(yourService.getDatabaseInfoFromRedis());
    }
}
