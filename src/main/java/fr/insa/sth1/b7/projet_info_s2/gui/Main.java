package fr.insa.sth1.b7.projet_info_s2.gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene scene;

//
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("PROJET S2");
        scene = new Scene(new GlobalPane(primaryStage));
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
