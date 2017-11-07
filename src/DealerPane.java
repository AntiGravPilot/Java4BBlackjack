import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/*
 * Shown at start of program; Holds a <Deck> deckOfCards, <int> remainingCards, <Hand> handOfCards, and a visual deck of cards; has methods ShowHand, Hit, Stay, ShowScore, and most importantly StartGame which is assigned to a button that kicks off the game method.
 */
public class DealerPane {
    BorderPane dealerPane;
    Hand handOfCards;
    int remainingCards;

    public DealerPane(){
        dealerPane = new BorderPane();
        dealerPane.setId("test-pane");
        dealerPane.setPadding(new Insets(10,10,10,10));
        dealerPane.setMinSize(1200,400);
        dealerPane.setMaxSize(1200, 400); // Optional, can remove

        //<editor-fold desc="Top Pane" defaultstate="collapsed">
        Pane dealerTop = new Pane();

        Label labelDealer = new Label("Dealer");

        dealerTop.getChildren().addAll(labelDealer);
        //</editor-fold>

        //Mid
        // Nothing?!

        //Left
        //todo Dealer hand of cards

        //Right
        //todo Dealer-side stack of cards, representing the number remaining in the deck. A flipped card with a number on it can do for now.

        //<editor-fold desc="Bottom Pane" defaultstate="collapsed">
        Pane dealerBot = new Pane();

        Button buttonStart = new Button("Start Game");
        buttonStart.setOnAction( e -> { /* todo Game starts here */} );

        dealerBot.getChildren().addAll(buttonStart);
        //</editor-fold>

        dealerPane.setTop(dealerTop);
        dealerPane.setBottom(dealerBot);
    }

    public BorderPane getDealerPane() {
        return dealerPane;
    }

}
