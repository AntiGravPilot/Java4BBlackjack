import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/* Shown after successful login; holds a hand of cards, displays the player name and score, has buttons to either hit or stay, and has an exit button to log the player out. Should be visually similar to LoginPane.
 * @author Brandon
 */
public class PlayerPane extends Pane {
    VBox playerPane;
    private String name;
    private int score;

    //User myUser; //No User object currently exists
    Hand myHand;

    public PlayerPane(){
        playerPane = new VBox();
        playerPane.setId("game-pane");
        playerPane.setPadding(new Insets(10,10,10,10));
        playerPane.setMinSize(400,400);
        playerPane.setMaxSize(400, 400); // Optional, can remove
        playerPane.setAlignment(Pos.TOP_CENTER); //sets overall alignment

        //<editor-fold desc="Top section" defaultstate="collapsed"
        HBox top = new HBox();
        top.setAlignment(Pos.TOP_CENTER);
        top.setPrefHeight(50);
        top.setSpacing(100);
        top.setPadding(new Insets(10,10,10,10));

        Button playerExit = new Button("Exit");
        playerExit.setOnAction(e -> { /* todo Player leaves game / exit method */ });

        this.setName("Player");
        Label playerName = new Label(name);

        //todo updatePoints method
        this.setScore(0);
        Label playerScore = new Label(Integer.toString(score));

        top.getChildren().addAll(playerExit, playerName, playerScore);
        //</editor-fold>

        //<editor-fold desc="Middle section (standin)" defaultstate="collapsed"
        //todo Rendering a hand of cards properly
        Pane middle = new Pane();
        middle.setPrefHeight(350);
        //</editor-fold>

        //<editor-fold desc="Bottom section" defaultstate="collapsed"
        HBox bottom = new HBox();
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        bottom.setPrefHeight(50);
        bottom.setSpacing(100);
        bottom.setPadding(new Insets(10,10,10,10));

        Button playerHit = new Button("Hit");
        playerHit.minWidth(40);
        playerExit.setOnAction(e -> { /* todo Player hits */ });

        Button playerStay = new Button("Stay");
        playerExit.setOnAction(e -> { /* todo Player stays */ });

        // todo consider "Show Hand" button or method

        bottom.getChildren().addAll(playerHit, playerStay);
        //</editor-fold>

        playerPane.getChildren().addAll(top, middle, bottom);
    }

    //<editor-fold desc="Getters and Setters" defaultstate="collapsed"
    public VBox getPlayerPane() {
        return playerPane;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    //</editor-fold>
}
