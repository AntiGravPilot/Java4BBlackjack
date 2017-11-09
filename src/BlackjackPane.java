import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/* Shown at program start; Holds a DealerPane, up to three total PlayerPanes and/or LoginPanes, and a menu bar. Is the primary pane that users look at.
 * @author Brandon
 */
public class BlackjackPane {
    BorderPane blackjack;
    DealerPane dealerPane;
    PlayerPane player1;
    PlayerPane player2;
    PlayerPane player3;

    // Creates the Blackjack pane
    public BlackjackPane(){
        blackjack =  new BorderPane();

        //<editor-fold desc="Menus" defaultstate="collapsed">
        Menu file = new Menu("_File");

        MenuItem fileExit = new MenuItem("Exit");
        fileExit.setOnAction(e -> System.exit(0));

        file.getItems().addAll(fileExit);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file);
        //</editor-fold>

        //<editor-fold desc="Player Panes" defaultstate="collapsed">
        // todo Proper way to switch between PlayerPane and LoginPane
        HBox playerPanes = new HBox();
        player1 = new PlayerPane();
        player2 = new PlayerPane();
        player3 = new PlayerPane();
        playerPanes.getChildren().addAll(player1.getPlayerPane(), player2.getPlayerPane(), player3.getPlayerPane());
        //</editor-fold>

        //<editor-fold desc="Dealer Pane" defaultstate="collapsed">
        dealerPane = new DealerPane(player1, player2, player3);
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
