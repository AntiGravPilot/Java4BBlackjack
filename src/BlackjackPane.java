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

        //<editor-fold desc="Dealer Pane" defaultstate="collapsed">
        BorderPane dealerPane = new BorderPane();
        //Pane1
        //</editor-fold>

        //<editor-fold desc="Player Panes" defaultstate="collapsed">
        HBox playerPanes = new HBox();
        //Pane1
        //Pane2
        //Pane3
        //</editor-fold>

        blackjack.setTop(menuBar);
        blackjack.setBottom(playerPanes);

    }

    // Gives the Blackjack pane to the main
    public BorderPane getBlackjack(){
        return blackjack;
    }

}
