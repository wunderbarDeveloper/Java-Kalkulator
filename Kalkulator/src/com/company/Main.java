package com.company;
import  javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader loader = new FXMLLoader( getClass().getResource( "Main.fxml" ) );

        Parent root=loader.load();
        MainController rc = loader.<MainController>getController();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
        //Application.setUserAgentStylesheet(getClass().getResource("style.css").toExternalForm());
        root.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            {
                rc.checkKeyEvent(key);
                System.out.println(key.getCode().getName());
            }
        });
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}

