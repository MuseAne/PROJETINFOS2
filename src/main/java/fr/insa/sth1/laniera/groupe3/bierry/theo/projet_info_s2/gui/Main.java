/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author theob
 */
public class Main extends Application {

    private Label titre;
    private Scene scene;
    private Scene scene2;

//
//    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.getIcons().add(new Image("file:Image_Logo.png"));
        primaryStage.setTitle("TREILLIS");

        //Scene scene = new Scene(new MainDessinPane());
        scene2 = new Scene(new GlobalPane(primaryStage));
        primaryStage.setScene(scene2);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}