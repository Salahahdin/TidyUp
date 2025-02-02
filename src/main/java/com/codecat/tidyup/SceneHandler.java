package com.codecat.tidyup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler {

    private Stage stage;

    public SceneHandler(Stage stage)
    {
        this.stage = stage;
    }

    public void changeScene(String filename) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filename));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);


    }
    public void wrapChangeScene(String filename, double width, double height, boolean resizable, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filename));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setScene(scene);
        stage.setResizable(resizable);
        stage.setTitle(title);
        stage.show();
    }
}
