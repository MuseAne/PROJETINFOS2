module Projet_Info_S2 {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    
    opens fr.insa.sth1.b7.projet_info_s2 to javafx.graphics;
    opens fr.insa.sth1.b7.projet_info_s2.gui to javafx.graphics;
}
