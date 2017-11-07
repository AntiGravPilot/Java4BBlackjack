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
    VBox loginPane;

    public LoginPane(){
        loginPane = new VBox();
        loginPane.setId("game-pane");
        loginPane.setPadding(new Insets(10,10,10,10));
        loginPane.setMinSize(400,400);
        loginPane.setMaxSize(400, 400); // Optional, can remove
        loginPane.setAlignment(Pos.TOP_CENTER); //sets overall alignment

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

        Button loginNew = new Button("New");
        loginNew.setOnAction(e -> { /* todo New player login */ });

        Button loginLoad = new Button("Load");
        loginLoad.setOnAction(e -> { /* todo Load player login */ });

        bottom.getChildren().addAll(loginNew, loginLoad);
        //</editor-fold>

        loginPane.getChildren().addAll(top, middle, bottom);
    }

    //<editor-fold desc="Getters and Setters" defaultstate="collapsed"
    public VBox getPlayerPane() {
        return loginPane;
    }
    //</editor-fold>
}
