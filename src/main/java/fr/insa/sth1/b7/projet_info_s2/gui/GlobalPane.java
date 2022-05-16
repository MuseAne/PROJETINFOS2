package fr.insa.sth1.b7.projet_info_s2.gui;

import fr.insa.sth1.b7.projet_info_s2.Appui;
import fr.insa.sth1.b7.projet_info_s2.Point;
import fr.insa.sth1.b7.projet_info_s2.Figure;
import fr.insa.sth1.b7.projet_info_s2.Segment;
import fr.insa.sth1.b7.projet_info_s2.ClassDessin;
import fr.insa.sth1.b7.projet_info_s2.Barre;
import fr.insa.sth1.b7.projet_info_s2.Noeud;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GlobalPane extends BorderPane {

    private ToggleButton Terrain;
    private ToggleButton Segment;
    private ToggleButton Point;
    private ToggleButton Treilli;
    private ToggleButton AppuiSimple;
    private ToggleButton AppuiDouble;
    private ToggleButton Noeuds;
    private ToggleButton Barres;
    private Label Style;
    private Label Positions;
    private ToggleButton Simulation;
    private Label Aide;
    private DessinCanvas Dessin;
    private Button Ouvrir;
    private Button Enregistrer;
    private Button Nouveau;
    private ColorPicker Couleur;
    private ToggleButton Sélectionner;
    private Button Force;
    private Button Valider;
    private TextField Norme;
    private TextField Angle;
    private Button Supprimer;
    private Label posX = new Label("");
    private Label posY = new Label("");
    private Label Type = new Label("");
    private Label NormeForce = new Label();
    private Label AngleForce = new Label();
    private Label ContraintesBarres = new Label();
    private ClassDessin model;
    private Controleur controleur;

    private File curFile;
    private Stage inStage;

    private Label UTextLabel;
    private MainMenu menu;
    private String NomUtilisatuer = "";

    public GlobalPane(Stage inStage, String UText) {
        this(inStage, null, new ClassDessin(), 0, 0, 0, 0, 0, 0, UText);
    }

    public GlobalPane(Stage inStage) {
        this(inStage, new ClassDessin());
    }

    public GlobalPane(Stage inStage, ClassDessin model) {
        this(inStage, null, model);
    }

    public GlobalPane(Stage inStage, File fromFile, ClassDessin model) {
        this(inStage, fromFile, model, 0, 0, 0, 0, 0, 0, "");

    }

    public GlobalPane(Stage inStage, File fromFile, ClassDessin model, int IDS, int IDP, int IDN, int IDB, int IDF, double Prix, String UText) {
        this.inStage = inStage;
        this.model = model;
        this.controleur = new Controleur(this, IDN, IDB, IDS, IDP, IDF);

        this.UTextLabel = new Label(UText);
        UTextLabel.setTextFill(Color.DARKSLATEGREY);
        UTextLabel.setStyle("-fx-font-weight: bold");

        this.Noeuds = new ToggleButton("Noeuds");
        this.Barres = new ToggleButton("Barres");
        this.Style = new Label("Style");
        this.Positions = new Label("Position");
        this.Simulation = new ToggleButton("Simulation");
        this.Aide = new Label();
        this.Dessin = new DessinCanvas(this);
        this.Sélectionner = new ToggleButton("Sélectionner");
        this.Force = new Button("Force");
        this.Valider = new Button("Valider");
        this.Norme = new TextField("Norme (en N)");
        this.Angle = new TextField("Angle (en rad)");
        this.Supprimer = new Button("Supprimer");
        this.Sélectionner.setPrefSize(120, 25);
        this.Norme.setPrefSize(100, 25);
        this.Angle.setPrefSize(100, 25);
        this.Supprimer.setPrefSize(120, 25);
        this.Aide.setFont(javafx.scene.text.Font.font(15));

//----------- Concerne les insertions des icones dans les différents boutons ainsi que leur taille -----------//
        //----------- Bouton Terrain -----------//
        this.Terrain = new ToggleButton("Terrain");
        this.Terrain.setContentDisplay(ContentDisplay.TOP);
        this.Terrain.setPrefSize(100, 100);

        //----------- Bouton Treilli -----------//
        this.Treilli = new ToggleButton("Treilli");
        this.Treilli.setContentDisplay(ContentDisplay.TOP);
        this.Treilli.setPrefSize(100, 100);

        //----------- Bouton Ouvrir -----------//
        this.Ouvrir = new Button("Ouvrir");
        this.Ouvrir.setPrefSize(120, 33);

        //----------- Bouton Enregistrer -----------//
        this.Enregistrer = new Button("Enregistrer");
        this.Enregistrer.setPrefSize(120, 33);

        //----------- Bouton Nouveau -----------//
        this.Nouveau = new Button("Nouveau");
        this.Nouveau.setPrefSize(120, 33);

        //----------- Bouton Segment -----------//
        this.Segment = new ToggleButton("Segment");
        this.Segment.setPrefSize(100, 50);

        //----------- Bouton Point -----------//
        this.Point = new ToggleButton("Point");
        this.Point.setPrefSize(100, 50);

        //----------- Bouton Appui Simple -----------//
        this.AppuiSimple = new ToggleButton("Appui \nSimple");
        this.AppuiSimple.setPrefSize(100, 50);

        //----------- Bouton Appui Double -----------//
        this.AppuiDouble = new ToggleButton("Appui \nDouble");
        this.AppuiDouble.setPrefSize(100, 50);

        //----------- Bouton Noeuds -----------//
        this.Noeuds = new ToggleButton("Noeuds");
        this.Noeuds.setPrefSize(100, 50);

        //----------- Bouton Barres -----------//
        this.Barres = new ToggleButton("Barres");
        this.Barres.setPrefSize(100, 50);

        //----------- Bouton Treilli -----------//
        this.Simulation = new ToggleButton("Simulation");
        this.Simulation.setContentDisplay(ContentDisplay.TOP);
        this.Simulation.setPrefSize(100, 100);

        //----------- Bouton Force -----------//
        this.Force = new Button("Force");
        this.Force.setPrefSize(100, 50);

        //----------- Bouton Barres -----------//
        this.Valider = new Button("Valider");
        this.Valider.setPrefSize(200, 50);

//----------- Concerne les éléments de la partie haute de l'interface -----------//
        // Gère les groupe de boutons à l'aide de HBox et VBox
        VBox bTerrain = new VBox(this.getSegment(), this.getPoint());
        VBox bTreilli1 = new VBox(this.getAppuiSimple(), this.getAppuiDouble());
        VBox bTreilli2 = new VBox(this.getNoeuds(), this.getBarres());

        VBox vOptions = new VBox(this.Nouveau, this.Ouvrir, this.getEnregistrer());

        HBox hTerrain = new HBox(this.getTerrain(), bTerrain);
        HBox hTreilli = new HBox(this.getTreilli(), bTreilli1, bTreilli2);

        hTerrain.setSpacing(8);
        hTreilli.setSpacing(8);

        //partie déco (logo INSA)
        NormeForce.setTextFill(Color.WHITE);
        ContraintesBarres.setTextFill(Color.WHITE);
        AngleForce.setTextFill(Color.WHITE);
        Type.setTextFill(Color.WHITE);

        // Défini les rectangles de séparation entre les groupes de boutons
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setWidth(5);
        rectangle1.setHeight(100);
        rectangle1.setFill(Color.LIGHTGRAY);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setWidth(5);
        rectangle2.setHeight(100);
        rectangle2.setFill(Color.LIGHTGRAY);

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setWidth(5);
        rectangle3.setHeight(100);
        rectangle3.setFill(Color.LIGHTGRAY);

        // Gère les groupes des différents boutons en définissant des couleurs de fond pour les H/VBox
        VBox NormeAngle = new VBox(Norme, Angle);
        HBox ForceDonnees = new HBox(Force, NormeAngle);
        VBox vbForce = new VBox(ForceDonnees, Valider);

        HBox SimFor = new HBox(Simulation, vbForce);
        SimFor.setSpacing(8);

        HBox entete = new HBox(vOptions, rectangle1, hTerrain, rectangle2, hTreilli, rectangle3, SimFor);
        entete.setSpacing(20);
        entete.setPadding(new javafx.geometry.Insets(15, 20, 10, 10));

        // Place la barre de menu en haut de l'interface
        this.menu = new MainMenu(this);
        VBox barreMenus = new VBox(menu, entete);

        Background bgBlue = new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, null));
        barreMenus.setBackground(bgBlue);

        BorderPane haut = new BorderPane();
        HBox JeSersARien = new HBox();
        JeSersARien.setBackground(bgBlue);
        haut.setLeft(entete);
        haut.setTop(menu);
        haut.setCenter(JeSersARien);
        entete.setBackground(bgBlue);

        this.setTop(haut);

//----------- Concerne les éléments de la partie gauche de l'interface -----------//
        //----------- Définit le bouton Couleur en définissant la couleur Noir par défaut -----------//
        Couleur = new ColorPicker(Color.BLACK);
        Couleur.setOnAction((t) -> {
            controleur.changeColor(Couleur.getValue());
        });
        Couleur.setPrefSize(120, 25);

        //----------- On place les différents éléments qui composent la partie gauche -----------//
        // On défini une BorderPane pour la partie gauche pour bien placer les éléments
        BorderPane gauche = new BorderPane();

        // On défini les groupes de bouton à l'aide de H/VBox, on modifie la taille police et les couleurs
        HBox hStyle = new HBox(this.Style);
        hStyle.setPadding(new javafx.geometry.Insets(10, 5, 0, 0));

        HBox hPositions = new HBox(this.Positions);
        hPositions.setPadding(new javafx.geometry.Insets(10, 10, 0, 0));

        this.Style.setFont(javafx.scene.text.Font.font(15));
        this.Positions.setFont(javafx.scene.text.Font.font(15));

        VBox coteGauche = new VBox(hStyle, getCouleur(),
                hPositions, this.Sélectionner, Supprimer);
        coteGauche.setPadding(new javafx.geometry.Insets(2, 15, 10, 10));

        Background bgLightBlue = new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, null));
        coteGauche.setBackground(bgLightBlue);

        // Permet d'afficher les coordonnées du pointeurs en direct lorsqu'on bouge la souris sur le Canvas
        Dessin.setOnMouseMoved((t) -> {
            double x;
            double y;
            x = t.getSceneX() - 145.6;
            y = t.getSceneY() - 152.8;
            posX.setText("X : " + ((int) x));
            posX.setStyle("-fx-font-weight: bold");
            posY.setText("Y : " + ((int) y));
            posY.setStyle("-fx-font-weight: bold");
        });

        VBox posCurseur = new VBox(posX, posY);
        VBox IndicationElement = new VBox(Type, NormeForce, AngleForce, ContraintesBarres);
        VBox Assemblage = new VBox(IndicationElement, posCurseur);
        VBox JeSersARienBis = new VBox();

        Assemblage.setBackground(bgLightBlue);
        JeSersARienBis.setBackground(bgLightBlue);

        gauche.setTop(coteGauche);
        gauche.setCenter(JeSersARienBis);
        gauche.setBottom(Assemblage);

        this.setLeft(gauche);

//----------- Concerne les éléments de la partie inférieure de l'interface -----------//
        Aide.setText("Cliquez sur un bouton pour modéliser votre treilli");

        HBox coteBas = new HBox(this.Aide);

        Background bgLightBlue2 = new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, null));
        coteBas.setBackground(bgLightBlue2);

        this.setBottom(coteBas);

//----------- Concerne la position centrale du canvas -----------//
        this.setCenter(Dessin);

//----------- Concerne l'activation et la désactivation des boutons par défaut / Met les ToggleButton dans des groupes -----------//
        Point.setDisable(true);
        Segment.setDisable(true);
        Barres.setDisable(true);
        AppuiSimple.setDisable(true);
        AppuiDouble.setDisable(true);
        Noeuds.setDisable(true);
        Valider.setDisable(true);
        Norme.setDisable(true);
        Angle.setDisable(true);
        Supprimer.setDisable(true);

        ToggleGroup gPointSegment = new ToggleGroup();
        Segment.setToggleGroup(gPointSegment);
        Point.setToggleGroup(gPointSegment);

        ToggleGroup gTerrainTreilli = new ToggleGroup();
        Terrain.setToggleGroup(gTerrainTreilli);
        Treilli.setToggleGroup(gTerrainTreilli);
        Sélectionner.setToggleGroup(gTerrainTreilli);

        ToggleGroup gTreilli = new ToggleGroup();
        Noeuds.setToggleGroup(gTreilli);
        Barres.setToggleGroup(gTreilli);
        AppuiSimple.setToggleGroup(gTreilli);
        AppuiDouble.setToggleGroup(gTreilli);

//----------- Concerne les instructions attendues lorsqu'on clique sur Point -----------//
        Point.setOnAction((t) -> {
            Aide.setText("Cliquez sur la zone du dessin pour placer vos points");

            if (Segment.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonPoint(t);
            }

            // Quand Point est activé, on désactive tous les autres boutons
            if (Segment.isDisabled() == true) {
                Treilli.setDisable(false);
                Terrain.setDisable(false);
                Force.setDisable(false);
                Simulation.setDisable(false);
                Segment.setDisable(false);
                Sélectionner.setDisable(false);
            } else {
                Treilli.setDisable(true);
                Terrain.setDisable(true);
                Force.setDisable(true);
                Simulation.setDisable(true);
                Segment.setDisable(true);
                Sélectionner.setDisable(true);
            }
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Segment -----------//
        Segment.setOnAction((t) -> {
            Aide.setText("Placez 2 points pour créer un segment ou reliez 2 points déjà existants");
            if (Point.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonSegment(t);
            }

            // Quand Segment est activé, on désactive tous les autres boutons
            if (Point.isDisabled() == true) {
                Point.setDisable(false);
                Treilli.setDisable(false);
                Terrain.setDisable(false);
                Force.setDisable(false);
                Simulation.setDisable(false);
                Sélectionner.setDisable(false);
            } else {
                Point.setDisable(true);
                Treilli.setDisable(true);
                Terrain.setDisable(true);
                Force.setDisable(true);
                Simulation.setDisable(true);
                Sélectionner.setDisable(true);
            }
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Appui Simple -----------//
        AppuiSimple.setOnAction((t) -> {
            Aide.setText("Cliquez sur un segment du terrain pour y placer un appui simple");
            if (AppuiDouble.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonAppuiSimple(t);
            }

            // Quand Appui Simple est activé, on désactive tous les autres boutons
            if (Barres.isDisabled() == true) {
                Treilli.setDisable(false);
                Terrain.setDisable(false);
                Simulation.setDisable(false);
                Force.setDisable(false);
                Barres.setDisable(false);
                AppuiDouble.setDisable(false);
                Noeuds.setDisable(false);
                Sélectionner.setDisable(false);
            } else {
                Treilli.setDisable(true);
                Terrain.setDisable(true);
                Simulation.setDisable(true);
                Force.setDisable(true);
                Barres.setDisable(true);
                AppuiDouble.setDisable(true);
                Noeuds.setDisable(true);
                Sélectionner.setDisable(true);
            }
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Appui Double -----------//
        AppuiDouble.setOnAction((t) -> {
            Aide.setText("Cliquez sur un segment du terrain pour y placer un appui double");
            if (AppuiSimple.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonAppuiDouble(t);
            }

            // Quand Appui Double est activé, on désactive tous les autres boutons
            if (Barres.isDisabled() == true) {
                Treilli.setDisable(false);
                Terrain.setDisable(false);
                Simulation.setDisable(false);
                Force.setDisable(false);
                Barres.setDisable(false);
                AppuiSimple.setDisable(false);
                Noeuds.setDisable(false);
                Sélectionner.setDisable(false);
            } else {
                Treilli.setDisable(true);
                Terrain.setDisable(true);
                Simulation.setDisable(true);
                Force.setDisable(true);
                Barres.setDisable(true);
                AppuiSimple.setDisable(true);
                Noeuds.setDisable(true);
                Sélectionner.setDisable(true);
            }
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Barres -----------//
        Barres.setOnAction((t) -> {
            Aide.setText("Cliquez sur 2 noeuds pour créer une barre");
            if (Noeuds.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonBarres(t);
            }

            // Quand Appui Double est activé, on désactive tous les autres boutons
            if (Noeuds.isDisabled() == true) {
                Treilli.setDisable(false);
                Terrain.setDisable(false);
                Simulation.setDisable(false);
                Force.setDisable(false);
                AppuiDouble.setDisable(false);
                AppuiSimple.setDisable(false);
                Noeuds.setDisable(false);
                Sélectionner.setDisable(false);
            } else {
                Treilli.setDisable(true);
                Terrain.setDisable(true);
                Simulation.setDisable(true);
                Force.setDisable(true);
                AppuiDouble.setDisable(true);
                AppuiSimple.setDisable(true);
                Noeuds.setDisable(true);
                Sélectionner.setDisable(true);
            }
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Noeuds -----------//
        Noeuds.setOnAction((t) -> {
            Aide.setText("Cliquez sur un point pour créer un noeud");
            if (Barres.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonNoeuds(t);
            }

            // Quand Noeuds est activé, on désactive tous les autres boutons
            if (Barres.isDisabled() == true) {
                Treilli.setDisable(false);
                Terrain.setDisable(false);
                Simulation.setDisable(false);
                Force.setDisable(false);
                Barres.setDisable(false);
                AppuiSimple.setDisable(false);
                AppuiDouble.setDisable(false);
                Sélectionner.setDisable(false);
            } else {
                Treilli.setDisable(true);
                Terrain.setDisable(true);
                Simulation.setDisable(true);
                Force.setDisable(true);
                Barres.setDisable(true);
                AppuiSimple.setDisable(true);
                AppuiDouble.setDisable(true);
                Sélectionner.setDisable(true);
            }
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Terrain -----------//
        Terrain.setOnAction((t) -> {
            Aide.setText("Cliquez sur le bouton Point ou Segment afin de modéliser votre terrain");
            Barres.setDisable(true);
            AppuiSimple.setDisable(true);
            AppuiDouble.setDisable(true);
            Noeuds.setDisable(true);

            // Quand Terrain est activé, on active Point et Terrain et on désactive tous les autres boutons
            if (Segment.isDisabled() == true) {
                Segment.setDisable(false);
                Point.setDisable(false);
                Treilli.setDisable(true);
                Simulation.setDisable(true);
            } else {
                Segment.setDisable(true);
                Point.setDisable(true);
                Treilli.setDisable(false);
                Simulation.setDisable(false);
            }
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Treilli -----------//
        Treilli.setOnAction((t) -> {
            Aide.setText("Cliquez sur le bouton Noeuds, Appui (Simple/Double) ou Barres pour modéliser votre treilli");
            Point.setDisable(true);
            Segment.setDisable(true);

            // Quand Treilli est activé, on active Appui Simple, Appui Double, Noeuds et Barres et on désactive tous les autres boutons
            if (Barres.isDisabled() == true) {
                Barres.setDisable(false);
                AppuiSimple.setDisable(false);
                AppuiDouble.setDisable(false);
                Noeuds.setDisable(false);
                Terrain.setDisable(true);
                Simulation.setDisable(true);
            } else {
                Barres.setDisable(true);
                AppuiSimple.setDisable(true);
                AppuiDouble.setDisable(true);
                Noeuds.setDisable(true);
                Terrain.setDisable(false);
                Simulation.setDisable(false);
            }
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Sélectionner -----------//
        Sélectionner.setOnAction((t) -> {
            Aide.setText("Cliquez sur des éléments pour les sélectionner");
            this.controleur.boutonSélectionner(t);

            // On désactive tous les bouton et on active le bouton Supprimer
            if (Segment.isDisabled() == false || Barres.isDisabled() == false) {
                Segment.setDisable(true);
                Point.setDisable(true);
                AppuiSimple.setDisable(true);
                AppuiDouble.setDisable(true);
                Barres.setDisable(true);
                Noeuds.setDisable(true);
            }
            if (Supprimer.isDisable() == true) {
                Supprimer.setDisable(false);
            } else {
                Supprimer.setDisable(true);
            }

        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Force -----------//
        Force.setOnAction((t) -> {
            Aide.setText("Sélectionnez le noeuds puis entrez la norme et l'angle de la force qui s'y applique");
            controleur.boutonEtatNeutre(t);

            // On active les zones de texte et le bouton valider
            if (Angle.isDisabled() == true) {
                Angle.setDisable(false);
                Norme.setDisable(false);
                Valider.setDisable(false);
                Sélectionner.setDisable(true);
            } else {
                Angle.setDisable(true);
                Norme.setDisable(true);
                Valider.setDisable(true);
                Sélectionner.setDisable(false);
            }
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Simulation -----------//
        Simulation.setOnAction((t) -> {

            // Permet de lancer les calculs et de dire si le treillis est isostatique / Affiche une erreur si le calcul est impossible
            ArrayList<Noeud> AN = controleur.getVue().getModel().Tri_Des_Noeuds();
            ArrayList<Barre> AB = controleur.getVue().getModel().Tri_Des_Barres();
            ArrayList<Segment> AS = controleur.getVue().getModel().Tri_Des_Segment();
            if (AN.isEmpty() || AB.isEmpty() || AS.isEmpty()) {
                Aide.setText("La simulation est impossible, vous devez avoir au moins un Segment, une Barre et un Noeud.");
            } else {
                controleur.boutonSimulation(t);
            }
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Supprimer -----------//
        Supprimer.setOnAction((t) -> {

            int i = 0;
            for (Figure F : controleur.getSelection()) { //On récupère toutes les figures de la séléction
                if (controleur.getVue().getModel().getContenu().contains(F)) { //Comme dans la suite, on va enlever des figures qui ne sont pas demander d'enlever, mais qui créent des ncohérence, alors, on vérfie si cette figure est déjà enlevé ou pas
                    if (F instanceof Point) { //On regarde le tupe de la figure
                        System.out.println("+++Point");
                        ArrayList<Segment> AS = ((Point) F).getSegment_Point();//On récupère tous les segments qui touchent le point
                        System.out.println("AS : " + AS);
                        if (!AS.isEmpty()) {
                            for (Segment S : AS) {
                                ArrayList<Appui> AA = S.getAppui();//On récupère tous les appuis qui touchent les segments qui touchent le point
                                System.out.println("AA : " + AA);
                                if (!AA.isEmpty()) {
                                    for (Appui A : AA) {
                                        ArrayList<Barre> AB = A.getBarre(); //On récupère toutes les barres de tous les appuis
                                        System.out.println("AB : " + AB);
                                        if (!AB.isEmpty()) {
                                            for (Barre B : AB) {
                                                controleur.getVue().getModel().Remove(B); //On enlève la barre de la liste de figure du model
                                                controleur.getVue().getModel().MAJ_Ids(B, B.getId()); //On met à jours les identificateurs
                                                controleur.setIdBarre(controleur.getIdBarre() - 1); //On met à jour l'identificateur pour la création de nouvelles barres ensuite
                                                System.out.println("OK " + i + " fois");
                                                i++;

                                                for (int j = 0; j < 2; j++) {
                                                    if (B.getNoeuds_Barre(j) != A) {//On prend l'autre noued que l'appui pour lui enlever la barre pour ne pas avoir de bare présente dans la liste de ce noeud alors que normalement elle n'existe plus
                                                        B.getNoeuds_Barre(j).removeBarre(B);
                                                    }
                                                }
                                            }
                                        }
                                        controleur.getVue().getModel().Remove(A); //On enlève l'appui
                                        controleur.getVue().getModel().MAJ_Ids(A, A.getId()); //On met à jour les Id des noeuds
                                        controleur.setIdNoeud(controleur.getIdNoeud() - 1);//On met à jour l'identificateur des appuis pour pouvoir ensuite créer des noueds appui sans problème d'id
                                    }
                                }
                                controleur.getVue().getModel().Remove(S); //On enlève le segment
                                controleur.getVue().getModel().MAJ_Ids(S, S.getId()); //On met à jour les id des segments
                                controleur.setIdSegment(controleur.getIdSegment() - 1);//On met à jour l'id de création de segment
                                for (int j = 0; j < 2; j++) {
                                    if (S.getExtremite(j) != (Point) F) { //On enlève le segment de la liste des segments du point qui n'est pas pris en compte ici
                                        S.getExtremite(j).removeSegment(S);
                                    }
                                }
                            }
                        }
                        controleur.getVue().getModel().Remove(F); //On enlève la figure
                        controleur.getVue().getModel().MAJ_Ids(F, F.getId()); //On met à jour ses id
                        controleur.setIdPoint(controleur.getIdPoint() - 1); //On met à jour l'Id de création
                    } else if (F instanceof Segment) {
                        System.out.println("+++Segment");
                        ArrayList<Appui> AA = ((Segment) F).getAppui();
                        for (Appui A : AA) {
                            ArrayList<Barre> AB = A.getBarre();
                            for (Barre B : AB) {
                                controleur.getVue().getModel().Remove(B);
                                controleur.getVue().getModel().MAJ_Ids(B, B.getId());
                                controleur.setIdBarre(controleur.getIdBarre() - 1);
                                System.out.println("OK " + i + " fois");
                                i++;

                            }

                            controleur.getVue().getModel().Remove(A);
                            controleur.getVue().getModel().MAJ_Ids(A, A.getId());
                            controleur.setIdNoeud(controleur.getIdNoeud() - 1);
                        }
                        controleur.getVue().getModel().Remove(F);
                        controleur.getVue().getModel().MAJ_Ids(F, F.getId());
                        controleur.setIdSegment(controleur.getIdSegment() - 1);

                        for (int j = 0; j < 2; j++) {

                            ((Segment) F).getExtremite(j).removeSegment(((Segment) F));

                        }

                    } else if (F instanceof Noeud) {
                        System.out.println("+++Noeud");
                        ArrayList<Barre> AB = ((Noeud) F).getBarre();
                        for (Barre B : AB) {
                            controleur.getVue().getModel().Remove(B);
                            controleur.getVue().getModel().MAJ_Ids(B, B.getId());
                            controleur.setIdBarre(controleur.getIdBarre() - 1);
                            System.out.println("OK " + i + " fois");
                            i++;

                            for (int j = 0; j < 2; j++) {
                                if (B.getNoeuds_Barre(j) != ((Noeud) F)) {
                                    B.getNoeuds_Barre(j).removeBarre(B);
                                }
                            }

                        }
                        controleur.getVue().getModel().Remove(F);
                        controleur.getVue().getModel().MAJ_Ids(F, F.getId());
                        controleur.setIdNoeud(controleur.getIdNoeud() - 1);

                    } else if (F instanceof Barre) {
                        System.out.println("+++Barre");
                        controleur.getVue().getModel().Remove(F);
                        controleur.getVue().getModel().MAJ_Ids(F, F.getId());
                        controleur.setIdBarre(controleur.getIdBarre() - 1);
                        System.out.println("OK " + i + " fois");
                        i++;
                        for (int j = 0; j < 2; j++) {

                            ((Barre) F).getNoeuds_Barre(j).removeBarre((Barre) F);

                        }
                    }
                }
            }
            controleur.getTreillisControleur().setTreillis(controleur.getVue().getModel());
            System.out.println("Treilis: " + controleur.getTreillisControleur());
            System.out.println("\n-|-|-|- ID BARRE : " + controleur.getIdBarre() + "\n");
            controleur.getVue().redrawAll();
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Terrain -----------//
        Nouveau.setOnAction((t) -> {
            controleur.menuNouveau(t);
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Ouvrir -----------//  
        Ouvrir.setOnAction((t) -> {
            controleur.menuOuvrir(t);
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Nouveau -----------//  
        Nouveau.setOnAction((t) -> {
            controleur.menuNouveau(t);
        });

//----------- Concerne les instructions attendues lorsqu'on clique sur Sauvegarder -----------//  
        Enregistrer.setOnAction((t) -> {
            ArrayList<Noeud> AN = controleur.getVue().getModel().Tri_Des_Noeuds();
            ArrayList<Barre> AB = controleur.getVue().getModel().Tri_Des_Barres();
            ArrayList<Segment> AS = controleur.getVue().getModel().Tri_Des_Segment();
            if (AN.isEmpty() || AB.isEmpty() || AS.isEmpty()) {//En fait, seule le fait que la liste des segments ne doit pas être vide suffit,mais cela n'a pas vraiment de sens d'enregistrer un fichier sans au moins une des trois conditions donc ce n'est pas très déreangant
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Problème durant la sauvegarde\n\nPour sauvegarder un fichier, celui_ci doit contenir au moins : \n-Une barre\n-Un noeud simple\n-Un segment");
                alert.showAndWait();
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.menuSauvegarder(t);
            }
        });

//----------- Concerne les actions quand on veut valider une force -------------------------//
        Valider.setOnAction((t) -> {
            controleur.BoutonValider(t);

            // Une fois cliqué sur Valider, on désactive les champ et ce même bouton
            Valider.setDisable(true);
            Norme.setDisable(true);
            Angle.setDisable(true);
        });

//----------- Concerne les actions lorsqu'on entre une norme -------------------------//        
        Norme.setOnMouseClicked((ti) -> {
            if (Norme.getText().equals("Norme (en N)")) {
                Norme.setText("");
            }
        });

//----------- Concerne les actions lorsqu'on entre un angle -------------------------//         
        Angle.setOnMouseClicked((ti) -> {
            if (Angle.getText().equals("Angle (en rad)")) {
                Angle.setText("");
            }
        });
    }

    public void redrawAll() {
        this.Dessin.redrawAll();
    }

    public ClassDessin getModel() {
        return model;
    }

    public Controleur getControleur() {
        return controleur;
    }

    public ToggleButton getTerrain() {
        return Terrain;
    }

    public ToggleButton getSegment() {
        return Segment;
    }

    public ToggleButton getPoint() {
        return Point;
    }

    public ToggleButton getTreilli() {
        return Treilli;
    }

    public ToggleButton getAppuiSimple() {
        return AppuiSimple;
    }

    public ToggleButton getAppuiDouble() {
        return AppuiDouble;
    }

    public ToggleButton getNoeuds() {
        return Noeuds;
    }

    public ToggleButton getBarres() {
        return Barres;
    }

    public ToggleButton getSimulation() {
        return Simulation;
    }

    public Button getEnregistrer() {
        return Enregistrer;
    }

    public ColorPicker getCouleur() {
        return Couleur;
    }

    public File getCurFile() {
        return curFile;
    }

    public void setCurFile(File curFile) {
        this.curFile = curFile;
    }

    public Stage getInStage() {
        return inStage;
    }

    public MainMenu getMenu() {
        return menu;
    }

    public void setTextByMoi(String text) {
        Aide.setText(text);
    }

    public double getChampNorme() {
        double Val;
        Val = Double.parseDouble(Norme.getText());
        return Val;
    }

    public double getChampAngle() {
        double Val;
        Val = Double.parseDouble(Angle.getText());
        return Val;
    }

    public void setType(String S) {
        this.Type.setText(S);
    }

    public void setNormeForce(String S) {
        this.NormeForce.setText(S);
    }

    public void setAngleForce(String S) {
        this.AngleForce.setText(S);
    }

    public void setContraintesBarres(String S) {
        this.ContraintesBarres.setText(S);
    }

    public String getUText() {
        return NomUtilisatuer;
    }

    public void setTextNorme(String Instructions) {
        Norme.setText(Instructions);
    }

    public void setTextAngle(String Instructions) {
        Angle.setText(Instructions);
    }

}
