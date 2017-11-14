import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/*
 * Shown at start of program; Holds a <Deck> deckOfCards, <int> remainingCards, <Hand> handOfCards, and a visual deck of cards; has methods ShowHand, Hit, Stay, ShowScore, and most importantly StartGame which is assigned to a button that kicks off the game method.
 */
public class DealerPane {
    BorderPane dealerPane;
    Hand handOfCards;

    public DealerPane(Deck deckOfCards, PlayerPane p1, PlayerPane p2, PlayerPane p3){
        dealerPane = new BorderPane();
        dealerPane.setId("game-pane");
        dealerPane.setPadding(new Insets(10,10,10,10));
        dealerPane.setMinSize(1200,400);
        dealerPane.setMaxSize(1200, 400); // Optional, can remove

        //Variable definitions
        //todo Fix filepath for deckOfCards
        handOfCards = new Hand();
        handOfCards.draw(deckOfCards, 2);
        //handOfCards.cards.get(1).flip();

        //<editor-fold desc="Top Pane" defaultstate="collapsed">
        Pane dealerTop = new Pane();

        Label labelDealer = new Label("Dealer");

        dealerTop.getChildren().addAll(labelDealer);
        //</editor-fold>

        //Mid
        // Nothing

        //Left
        StackPane dealerLeft = new StackPane();
        renderCards(dealerLeft, handOfCards);


        //Right
        //todo Dealer-side stack of cards, representing the number remaining in the deck. A flipped card with a number on it can do for now.

        //<editor-fold desc="Bottom Pane" defaultstate="collapsed">
        Pane dealerBot = new Pane();

        Button buttonStart = new Button("Start Game");
        buttonStart.setOnAction( e -> 
        {
            
        } );

        dealerBot.getChildren().addAll(buttonStart);
        //</editor-fold>

        dealerPane.setTop(dealerTop);
        dealerPane.setLeft(dealerLeft);
        dealerPane.setBottom(dealerBot);
    }

    public BorderPane getDealerPane() {
        return dealerPane;
    }

    //todo Finish this once filepathing is figured out
    public StackPane renderCards(StackPane render, Hand hand) {
        if (hand.cards.size() == 0) {
            System.out.println("Can't render - No Cards");
            return render;
        } else {
            int numCards = hand.cards.size();

            for (int i = 0; i < numCards; i++) {
                Image card = hand.cards.get(i).getImage();

                ImageView iv = new ImageView(card);
                iv.setFitWidth(200);
                iv.setPreserveRatio(true);
                iv.setSmooth(true);
                iv.setCache(true);
                iv.setTranslateX(50 * i);

                render.getChildren().add(iv);
            }
            return render;
        }
    }
}
