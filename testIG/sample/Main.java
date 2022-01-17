package testIG.sample;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void init(){
    }

    @Override
    public void start(Stage primaryStage){


        BorderPane root = new BorderPane() ;

        Label lab = new Label("Jouer");
        Button play_bouton = new Button(); play_bouton.setText(lab.getText());
        Counter cmpt = new Counter();

        Label [] lbs = { /*new Label("1"), new Label("1"), new Label("1"),*/
        new Label("",
            new ImageView(
                new Image(
                    getClass().getResourceAsStream("/testIG/ressources/de1.png"),
                    70,70,true, true
                )
            )
        ),
        new Label("",
            new ImageView(
                new Image(
                    getClass().getResourceAsStream("/testIG/ressources/de1.png"),
                    70,70,true, true
                )
            )
        ),
        new Label("",
            new ImageView(
                new Image(
                    getClass().getResourceAsStream("/testIG/ressources/de1.png"),
                    70,70,true, true
                )
            )
        ),
        new Label("click no : 0 "),
        new Label ("correct comb 421 : 0")
        } ;

        Button[] boutons = new Button[4];

        for(int k=0; k<=2; k++)
            boutons[k] = new Button("", lbs[k].getGraphic());
        boutons[3] = play_bouton;

        ControllerButtonEcouteur clickHandler = new ControllerButtonEcouteur(cmpt,boutons,lbs);

        for(int k=0; k<=3; k++)
            boutons[k].setOnAction(clickHandler);

        root.setPadding(new Insets(5));
        root.setBottom(play_bouton);

        HBox hbLabels = new HBox();
        hbLabels.setPadding(new Insets(15));
        hbLabels.setAlignment(Pos.CENTER_RIGHT);
        hbLabels.getChildren().addAll(boutons[0], boutons[1], boutons[2]);
        root.setCenter(hbLabels);


        //Compteur + nb combinaisons correctes
        VBox vbLabels = new VBox();
        vbLabels.setPadding(new Insets(8));
        vbLabels.setAlignment(Pos.CENTER);
        vbLabels.getChildren().addAll(lbs[3],lbs[4]);
        root.setTop(vbLabels);

        //quit
        Button bouton2 = new Button("",
                new ImageView(
                    new Image(
                        getClass().getResourceAsStream("/testIG/ressources/quit.png"),
                        100, 100, true, true
                    )
                )
        );

        bouton2.setOnAction(evt-> Platform.exit());
        root.setLeft(bouton2);

        //parametrage fen
        primaryStage.setTitle("javaFX_Test_421");
        Scene scene = new Scene(root,450,405);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop(){
    }

    public static void main(String[] args) {
        launch(args);
    }
}
