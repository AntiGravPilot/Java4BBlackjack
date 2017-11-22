import javafx.event.ActionEvent;
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

        handOfCards = new Hand();

        

        //<editor-fold desc="Top Pane" defaultstate="collapsed">
        Pane dealerTop = new Pane();

        Label labelDealer = new Label("Dealer");

        dealerTop.getChildren().addAll(labelDealer);
        //</editor-fold>

        //Mid
        // Nothing

        //Left
        StackPane dealerLeft = new StackPane();
        
        p1.getStayButton().setOnAction(e -> {
            p1.playerHit.setVisible(false);
            p1.playerStay.setVisible(false);
            p1.isDone = true;
            doWork();
            renderCards(dealerLeft, handOfCards);
        });
        p1.getBustButton().addEventHandler(ActionEvent.ACTION, e -> {
            p1.HitMe();
            if(p1.myHand.valueOf() >= 21)
            {
                p1.playerHit.setVisible(false);
                p1.playerStay.setVisible(false);
                p1.isDone = true;
                doWork();
                renderCards(dealerLeft, handOfCards);
            }
        });
        p2.getStayButton().setOnAction(e -> {
            p2.playerHit.setVisible(false);
            p2.playerStay.setVisible(false);
            p2.isDone = true;
            doWork();
            renderCards(dealerLeft, handOfCards);
        });
        p2.getBustButton().addEventHandler(ActionEvent.ACTION, e -> {
            p2.HitMe();
            if(p2.myHand.valueOf() >= 21)
            {
                p2.playerHit.setVisible(false);
                p2.playerStay.setVisible(false);
                p2.isDone = true;
                doWork();
                renderCards(dealerLeft, handOfCards);
            }
        });
        p3.getStayButton().setOnAction(e -> {
            p3.playerHit.setVisible(false);
            p3.playerStay.setVisible(false);
            p3.isDone = true;
            doWork();
            renderCards(dealerLeft, handOfCards);
        });
        p3.getBustButton().addEventHandler(ActionEvent.ACTION, e -> {
            p3.HitMe();
            if(p3.myHand.valueOf() >= 21)
            {
                p3.playerHit.setVisible(false);
                p3.playerStay.setVisible(false);
                p3.isDone = true;
                doWork();
                renderCards(dealerLeft, handOfCards);
            }
        });

        //Right
        //todo Dealer-side stack of cards, representing the number remaining in the deck. A flipped card with a number on it can do for now.

        //<editor-fold desc="Bottom Pane" defaultstate="collapsed">
        Pane dealerBot = new Pane();

        buttonStart = new Button("Start Game");
        buttonStart.setOnAction( e -> 
        {
            buttonStart.setVisible(false);
            inGame = true;
            handOfCards.clear();
            dealerLeft.getChildren().clear();
            handOfCards.draw(deckOfCards, 2);
            handOfCards.cards.get(1).flip();
            renderCards(dealerLeft, handOfCards);           
            
            if(!p1.isNull)
            {
                p1.isDone = false;
                p1.myHand.clear();
                p1.myPlayer.play();//antes
                p1.myHand.draw(deckOfCards, 2);
                p1.playerHit.setVisible(true);
                p1.playerStay.setVisible(true);
                //hide exit button
                p1.renderCards(p1.middle, p1.myHand);
            }
            else
            {
                //hide login button
            }
            
            if(!p2.isNull)
            {
                p2.myHand.clear();
                p2.isDone = false;
                p2.myHand.clear();
                p2.myPlayer.play();//antes
                p2.myHand.draw(deckOfCards, 2);
                p2.playerHit.setVisible(true);
                p2.playerStay.setVisible(true);
                //hide exit button
                p2.renderCards(p2.middle, p2.myHand);
            }
            else
            {
                //hide login button
            }
            
            if(!p3.isNull)
            {
                p3.myHand.clear();
                p3.isDone = false;
                p3.myHand.clear();
                p3.myPlayer.play();//antes
                p3.myHand.draw(deckOfCards, 2);
                p3.playerHit.setVisible(true);
                p3.playerStay.setVisible(true);
                //hide exit
                p3.renderCards(p3.middle, p3.myHand);
            }
            else
            {
                //hide login button
            }
            BlackjackPane.playerList.updatePlayersFile();
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
    
    void doWork()//this is called from playerpane, and it checks the other panes and controls wether the program moves forwards
    {
        if((p1.isNull || p1.isDone)&&
           (p2.isNull || p2.isDone)&&
           (p3.isNull || p3.isDone))
        {
            doWork(deckOfCards);
        }
    }
    
    void doWork(Deck deckOfCards) //this runs after all players have stayed
    {
        while((handOfCards.valueOf() < 17) &&
                ((!p1.isNull && p1.myHand.valueOf() < 22)||
                 (!p2.isNull && p2.myHand.valueOf() < 22)||
                 (!p3.isNull && p3.myHand.valueOf() < 22)))
        { //while value of dealers hand is under 17 but nor busted, won't run if all logged in players are busted
            //System.out.println("drawing for dealer");
            handOfCards.draw(deckOfCards);
        }
        handOfCards.cards.get(1).flip();
                
        if(!p1.isNull)
        {
            modifyPlayerScore(p1.myPlayer, p1.myHand, handOfCards);    
            p1.setScore((int)p1.myPlayer.getPoints());
            //bring back exit button
        }
        else
        {
            //bring back login button
        }
        
        if(!p2.isNull)
        {
            modifyPlayerScore(p2.myPlayer, p2.myHand, handOfCards); 
            p2.setScore((int)p2.myPlayer.getPoints());
            //bring back exit button
        }
        else
        {
            //bring back login pane
        }
        
        if(!p3.isNull)
        {
            modifyPlayerScore(p3.myPlayer, p3.myHand, handOfCards);
            p3.setScore((int)p3.myPlayer.getPoints());
            //bring back exit button
        }
        else
        {
            //bring back login pane
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
            else if(dHand.valueOf() > 21)
            {
                gambler.win();
                System.out.println(gambler.getName() + " wins!");
            }
            else if(pHand.compareTo(dHand) > 0)
            {
                gambler.win();
                System.out.println(gambler.getName() + " wins!");
            }
            else if(pHand.compareTo(dHand) == 0)
            {
                gambler.draw();
                System.out.println(gambler.getName() + " is tied!");
            }
            else if(pHand.compareTo(dHand) < 0)
            {
                gambler.lose();
                System.out.println(gambler.getName() + " loses!");
            }
            else
            {
                System.out.println("something went wrong");
                System.out.println("player has " + pHand.valueOf());
                System.out.println("dealer has " + dHand.valueOf());
            }
        }
        else
        {
            gambler.lose();
            System.out.println(gambler.getName() + " is Busted!");
        }
        BlackjackPane.playerList.updatePlayersFile();
        
    }
}
