module Projet_Info_S2 {
    //requires javafx.controlsEmpty;
    requires javafx.controls;
    //requires javafx.graphicsEmpty;
    requires javafx.graphics;
    //requires javafx.baseEmpty;
    requires javafx.base;
    //requires javafx.fxmlEmpty;
    //requires javafx.fxml;
    //requires Projet.Info.S2;
    
    opens fr.insa.sth1.b7.projet_info_s2 to javafx.graphics;
    opens fr.insa.sth1.b7.projet_info_s2.gui to javafx.graphics;
}
