package com.example.javafxdemo.fx;
import static com.sun.javafx.application.LauncherImpl.launchApplication;

import com.example.javafxdemo.fx.controller.DataSourceSettingController;
import com.example.javafxdemo.fx.controller.FileUrlSettingController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * <b>ClassName</b>: AbstractFxApplication <br/>
 *
 * <b>Description</b>: AbstractFxApplication <br/>
 *
 * <b>Date</b>: Apr 22, 2019 12:20:32 PM <br/>
 * 
 * @author pdai
 * @version Apr 22, 2019
 *
 */
@SuppressWarnings("restriction")
public abstract class AbstractFxApplication extends Application {
	private double xOffset = 0;
	private double yOffset = 0;
	protected static Logger LOGGER = LoggerFactory.getLogger(AbstractFxApplication.class);

	protected static ConfigurableApplicationContext applicationContext;

	/**
	 * @param appClass 启动类
	 * @param args 启动类参数
	 */
	public static void run(final Class<? extends Application> appClass, final String[] args) {

		CompletableFuture.supplyAsync(() -> applicationContext = SpringApplication.run(appClass, args))
				.whenComplete((ctx, throwable) -> {
					if (throwable != null) {
						LOGGER.error("Failed to load spring application context: ", throwable);
					} else {
						launchApplication(appClass, args);
					}
				});
	}

	/**
	 * 加载页面
	 * @param stage 页面根对象
	 * @throws IOException 加载异常
	 */
	@Override
	public void start(Stage stage) throws IOException {
		// 展示文件选择页面
		fileSelectPageShow(stage);
	}

	private void dataSourcePageShow(Stage stage) throws IOException {
		FXMLLoader loa = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/datesource.fxml")));

		Parent root = loa.load();

		// 给Controller赋值根节点
		DataSourceSettingController npc = loa.getController();
		npc.setStage(stage);

		stage.setTitle("测试窗口");
		stage.setScene(new Scene(root, 600, 250));

		// 设置窗口样式，去掉最小化、最大化、关闭按钮
		stage.initStyle(StageStyle.UNDECORATED);

		// 添加拖动事件监听器
		root.setOnMousePressed(event -> {
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		});

		root.setOnMouseDragged(event -> {
			stage.setX(event.getScreenX() - xOffset);
			stage.setY(event.getScreenY() - yOffset);
		});

		stage.show();
	}

	private void fileSelectPageShow(Stage stage) throws IOException {
		FXMLLoader loa = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/select-file.fxml")));

		Parent root = loa.load();

		// 给Controller赋值根节点
		FileUrlSettingController npc = loa.getController();
		npc.setStage(stage);

		stage.setTitle("测试窗口");
		stage.setScene(new Scene(root, 600, 250));

		// 设置窗口样式，去掉最小化、最大化、关闭按钮
		stage.initStyle(StageStyle.UNDECORATED);

		// 添加拖动事件监听器
		root.setOnMousePressed(event -> {
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		});

		root.setOnMouseDragged(event -> {
			stage.setX(event.getScreenX() - xOffset);
			stage.setY(event.getScreenY() - yOffset);
		});

		stage.show();
	}
}
