import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/* Shown at program start; Holds a DealerPane, up to three total PlayerPanes and/or LoginPanes, and a menu bar. Is the primary pane that users look at.
 * @author Brandon
 */
public class BlackjackPane {
    BorderPane blackjack;
    DealerPane dealerPane;
    PlayerPane player1;
    PlayerPane player2;
    PlayerPane player3;
    LoginPane login1;
    LoginPane login2;
    LoginPane login3;

    Deck deckOfCards = new Deck();

    // Creates the Blackjack pane
    public BlackjackPane(Stage primaryStage){
        blackjack =  new BorderPane();

        //<editor-fold desc="Menus" defaultstate="collapsed">
        Menu file = new Menu("_File");

        MenuItem fileExit = new MenuItem("Exit");
        fileExit.setOnAction(e -> System.exit(0));

        file.getItems().addAll(fileExit);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file);
        //</editor-fold>

        deckOfCards.shuffle();
        
        //<editor-fold desc="Player Panes" defaultstate="collapsed">
        // todo Proper way to switch between PlayerPane and LoginPane
        player1 = new PlayerPane(deckOfCards);
        player2 = new PlayerPane(deckOfCards);
        player3 = new PlayerPane(deckOfCards);

        HBox playerPanes = new HBox();
        login1 = new LoginPane(player1);
        login2 = new LoginPane(player2);
        login3 = new LoginPane(player3);
        playerPanes.getChildren().addAll(login1.getVisiblePane(), login2.getVisiblePane(), login3.getVisiblePane());
        //</editor-fold>

        //<editor-fold desc="Dealer Pane" defaultstate="collapsed">
        dealerPane = new DealerPane(deckOfCards, player1, player2, player3);
        //</editor-fold>

        blackjack.setTop(menuBar);
        blackjack.setCenter(dealerPane.getDealerPane());
        blackjack.setBottom(playerPanes);

    }

    // Gives the Blackjack pane to the main
    public BorderPane getBlackjack(){
        return blackjack;
    }

}
