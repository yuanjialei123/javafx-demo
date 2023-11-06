package com.example.javafxdemo.fx.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

/**
 * @Author: #{auth}
 * @Mail: #{email}
 * @Date: 2023/11/06
 * @Version: 1.0
 * @Description: 需要设置文件路径页面的Controller
 */
@FXMLController
public class FileUrlSettingController {

    @FXML
    private Stage stage;

    @FXML
    private JFXTextField filePathTextField;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    void clickStart(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择文件");
        File initialDirectory = new File(System.getProperty("user.home"));
        fileChooser.setInitialDirectory(initialDirectory);
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            filePathTextField.setText(filePath);
        }
    }

    @FXML
    void minimize(ActionEvent event) {
        stage.setIconified(true);
    }

    @FXML
    void close(ActionEvent event) {
        // 显示关闭前的确认对话框
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("确认关闭");
        alert.setHeaderText("关闭窗口");
        alert.setContentText("关闭后设备数据读取将会停止，确认关闭吗？");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            stage.close();
        }
    }
}
