package fr.insa.sth1.b7.projet_info_s2.gui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MainMenu extends MenuBar {

    public MainMenu(GlobalPane main) {

        Menu fichier = new Menu("Fichier");
        MenuItem nouveau = new MenuItem("Nouveau");
        MenuItem ouvrir = new MenuItem("Ouvrir");
        MenuItem sauvegarder = new MenuItem("Sauvegarder");
        MenuItem sauvegarderSous = new MenuItem("Sauvegarder Sous");

        nouveau.setOnAction((t) -> {
            main.getControleur().menuNouveau(t);
        });

        ouvrir.setOnAction((t) -> {
            main.getControleur().menuOuvrir(t);
        });

        sauvegarder.setOnAction((t) -> {
            main.getControleur().menuSauvegarder(t);
        });
        sauvegarderSous.setOnAction((t) -> {
            main.getControleur().menuSauvegarderSous(t);
        });
        fichier.getItems().addAll(nouveau, ouvrir, sauvegarder, sauvegarderSous);

        Menu aide = new Menu("Aide");
        MenuItem aPropos = new MenuItem("A Propos");
        MenuItem aideUtilisation = new MenuItem("Aide Utilisation");
        MenuItem FAQ = new MenuItem("FAQ");

        aPropos.setOnAction((t) -> {
            main.getControleur().menuAPropos(t);
        });
        aideUtilisation.setOnAction((t) -> {
            main.getControleur().menuAideUtilisation(t);
        });
        FAQ.setOnAction((t) -> {
            main.getControleur().menuFAQ(t);
        });
        aide.getItems().addAll(aPropos, aideUtilisation, FAQ);

        this.getMenus().addAll(fichier, aide);
    }

}
