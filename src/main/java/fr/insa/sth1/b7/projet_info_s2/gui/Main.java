package fr.insa.sth1.b7.projet_info_s2.gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene scene;

//
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.getIcons().add(new Image("file:Image_Logo.png"));
        primaryStage.setTitle("TREILLIS");

        //Scene scene = new Scene(new MainDessinPane());
        scene = new Scene(new GlobalPane(primaryStage));
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
