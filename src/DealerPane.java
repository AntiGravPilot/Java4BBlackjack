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
    Deck deckOfCards;
    Boolean inGame;
    Button buttonStart;
    PlayerPane p1;
    PlayerPane p2;
    PlayerPane p3;
    

    public DealerPane(Deck iDeckOfCards, PlayerPane ip1, PlayerPane ip2, PlayerPane ip3)
    {
        inGame = false;
        deckOfCards = iDeckOfCards;
        p1 = ip1;
        p2 = ip2;
        p3 = ip3;
        
        dealerPane = new BorderPane();
        dealerPane.setId("game-pane");
        dealerPane.setPadding(new Insets(10,10,10,10));
        dealerPane.setMinSize(1200,400);
        dealerPane.setMaxSize(1200, 400); // Optional, can remove

        //Variable definitions
        //todo Fix filepath for deckOfCards
        handOfCards = new Hand();

        // todo Implement shit
        p1.getStayButton().setOnAction(e -> {

        });

        //<editor-fold desc="Top Pane" defaultstate="collapsed">
        Pane dealerTop = new Pane();

        Label labelDealer = new Label("Dealer");

        dealerTop.getChildren().addAll(labelDealer);
        //</editor-fold>

        //Mid
        // Nothing

        //Left
        StackPane dealerLeft = new StackPane();

        //Right
        //todo Dealer-side stack of cards, representing the number remaining in the deck. A flipped card with a number on it can do for now.

        //<editor-fold desc="Bottom Pane" defaultstate="collapsed">
        Pane dealerBot = new Pane();

        buttonStart = new Button("Start Game");
        buttonStart.setOnAction( e -> 
        {
            buttonStart.setVisible(false);
            inGame = true;
            handOfCards.draw(deckOfCards, 2);
            //handOfCards.cards.get(1).flip();
            renderCards(dealerLeft, handOfCards);           
            
            if(p1 != null)
            {
                p1.isDone = false;
                p1.myHand.clear();
                p1.myHand.draw(deckOfCards, 2);
                p1.playerHit.setVisible(true);
                p1.playerStay.setVisible(true);
                //remove exit button
                p1.renderCards(p1.middle, p1.myHand);
            }
            else
            {
                //remove login pane
            }
            
            if(p2 != null)
            {
                p2.myHand.clear();
                p2.isDone = false;
                p2.myHand.draw(deckOfCards, 2);
                p2.playerHit.setVisible(true);
                p2.playerStay.setVisible(true);
                //remove exit button
                p2.renderCards(p2.middle, p2.myHand);
            }
            else
            {
                //remove login pane
            }
            
            if(p3 != null)
            {
                p3.myHand.clear();
                p3.isDone = false;
                p3.myHand.draw(deckOfCards, 2);
                p3.playerHit.setVisible(true);
                p3.playerStay.setVisible(true);
                //remove exit button
                p3.renderCards(p3.middle, p3.myHand);
            }
            else
            {
                //remove login pane
            }
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
        if (hand.cards.isEmpty()) {
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
    
    void doWork()//this is called from playerpane, and it checks the other panes and controls wether the program moves forwards
    {
        if((p1 == null || p1.isDone)&&
           (p2 == null || p2.isDone)&&
           (p3 == null || p3.isDone))
        {
            doWork(deckOfCards);
        }
    }
    
    void doWork(Deck deckOfCards) //this runs after all players have stayed
    {
        while((handOfCards.valueOf() < 17 && handOfCards.valueOf() < 22) || 
                ((p1 == null || p1.myHand.valueOf() > 21)&&
                 (p2 == null || p2.myHand.valueOf() > 21)&&
                 (p3 == null || p3.myHand.valueOf() > 21)))
        { //while value of dealers hand is under 17 but nor busted, won't run if all logged in players are busted
            handOfCards.draw(deckOfCards);
        }
                
        if(p1 != null)
        {
            modifyPlayerScore(p1.myPlayer, p1.myHand, handOfCards);
            //reset buttons
            p1.playerHit.setVisible(true);
            p1.playerStay.setVisible(true);
            //bring back exit button
        }
        else
        {
            //return login pane
        }
        
        if(p2 != null)
        {
            modifyPlayerScore(p2.myPlayer, p1.myHand, handOfCards);
            //reset buttons
            p2.playerHit.setVisible(true);
            p2.playerStay.setVisible(true);
            //bring back exit button
        }
        else
        {
            //return login pane
        }
        
        if(p3 != null)
        {
            modifyPlayerScore(p3.myPlayer, p1.myHand, handOfCards);
            //reset buttons
            p3.playerHit.setVisible(true);
            p3.playerStay.setVisible(true);
            //bring back exit button
        }
        else
        {
            //return login pane
        }
        
        buttonStart.setVisible(true);
    }
    
    void modifyPlayerScore(Player gambler, Hand pHand, Hand dHand)
    {

        if(pHand.valueOf() <= 21)
        {
            if(pHand.valueOf() == 21)
            {
                gambler.blackjack();
                System.out.println(gambler.getName() + " has blackjack!");
            }
            else if(pHand.compareTo(dHand) > 0)
            {
                gambler.win();
                System.out.println(gambler.getName() + " wins!");
            }
            else if(dHand.valueOf() > 21)
            {
                gambler.win();
                System.out.println(gambler.getName() + " wins!");
            }
            else if(pHand.compareTo(dHand) == 0)
            {
                gambler.draw();
                System.out.println(gambler.getName() + " is tied!");
            }
        }
        else
        {
            gambler.lose();
            System.out.println(gambler.getName() + " loses!");
        }
        
    }
}
