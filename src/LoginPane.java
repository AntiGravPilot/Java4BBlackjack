import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/* Shown at program start; allows user to input name, to either be newly created or loaded. Should be visually similar to PlayerPane.
 * @author Brandon
 */
public class LoginPane {
    VBox visiblePane;
    PlayerPane player;
    Player myPlayer;

    public LoginPane(PlayerPane player){
        this.player = player;

        visiblePane = new VBox();
        visiblePane.setId("game-pane");
        visiblePane.setPadding(new Insets(10,10,10,10));
        visiblePane.setMinSize(400,400);
        visiblePane.setMaxSize(400, 400); // Optional, can remove
        visiblePane.setAlignment(Pos.TOP_CENTER); //sets overall alignment

        //<editor-fold desc="Top section" defaultstate="collapsed"
        HBox top = new HBox();
        top.setAlignment(Pos.TOP_CENTER);
        top.setPrefHeight(50);
        top.setSpacing(10);
        top.setPadding(new Insets(10,10,10,10));

        Label usernameText = new Label("Username:");

        TextField usernameField = new TextField();
        usernameField.setPrefWidth(280);

        top.getChildren().addAll(usernameText, usernameField);
        //</editor-fold>

        //<editor-fold desc="Middle section (buffer)" defaultstate="collapsed"
        Pane middle = new Pane();
        middle.setPrefHeight(350);

        //</editor-fold>

        //<editor-fold desc="Bottom section" defaultstate="collapsed"
        HBox bottom = new HBox();
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        bottom.setPrefHeight(50);
        bottom.setSpacing(100);
        bottom.setPadding(new Insets(10,10,10,10));

        HBox pane = new HBox();
        Button playerExit = new Button("Exit");
        pane.getChildren().add(playerExit);
        playerExit.setOnAction(e -> {
            player.myHand.clear();
            visiblePane.getChildren().clear();
            visiblePane.getChildren().addAll(top, middle, bottom);
            player.isNull = true;
        });

        Button loginNew = new Button("Log in");
        loginNew.setOnAction(e -> {
            visiblePane.getChildren().clear();
            visiblePane.getChildren().addAll(pane, player.top, player.middle, player.bottom);

            myPlayer = BlackjackPane.playerList.loginPlayer(usernameField.getText());
            player.setPlayer(myPlayer);            
            player.setScore((int)myPlayer.getPoints());
            player.isNull = false;
        });

        bottom.getChildren().addAll(loginNew);
        //</editor-fold>

        visiblePane.getChildren().addAll(top, middle, bottom);
    }

    //<editor-fold desc="Getters and Setters" defaultstate="collapsed"
    public VBox getVisiblePane() {
        return visiblePane;
    }

    public VBox getPlayerPane() {
        return player.getPlayerPane();
    }
    //</editor-fold>
}
