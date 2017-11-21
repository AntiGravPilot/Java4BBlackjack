import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/* Shown after successful login; holds a hand of cards, displays the player name and score, has buttons to either hit or stay, and has an exit button to log the player out. Should be visually similar to LoginPane.
 * @author Brandon
 */
public class PlayerPane extends Pane {
    VBox playerPane;
    private String name;
    private int score;

    HBox top;
    StackPane middle;
    HBox bottom;

    Player myPlayer;
    Hand myHand;
    
    Button playerHit;
    Button playerStay;
    Boolean isDone;

    public PlayerPane(Deck deckOfCards)
    {
        myHand = new Hand();
        
        playerPane = new VBox();
        playerPane.setId("game-pane");
        playerPane.setPadding(new Insets(10,10,10,10));
        playerPane.setMinSize(400,400);
        playerPane.setMaxSize(400, 400); // Optional, can remove
        playerPane.setAlignment(Pos.TOP_CENTER); //sets overall alignment

        //<editor-fold desc="Top section" defaultstate="collapsed"
        top = new HBox();
        top.setAlignment(Pos.TOP_CENTER);
        top.setPrefHeight(50);
        top.setSpacing(100);
        top.setPadding(new Insets(10,10,10,10));

        this.setName("Player");
        Label playerName = new Label(name);

        //todo updatePoints method
        this.setScore(0);
        Label playerScore = new Label(Integer.toString(score));

        top.getChildren().addAll(playerName, playerScore);
        //</editor-fold>

        //<editor-fold desc="Middle section (standin)" defaultstate="collapsed"
        //todo Rendering a hand of cards properly
        middle = new StackPane();
        middle.setPrefHeight(350);
        //</editor-fold>

        //<editor-fold desc="Bottom section" defaultstate="collapsed"
        bottom = new HBox();
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        bottom.setPrefHeight(50);
        bottom.setSpacing(100);
        bottom.setPadding(new Insets(10,10,10,10));

        playerHit = new Button("Hit");
        playerHit.setOnAction(e -> 
            { 
                if(myHand.valueOf() <= 21)
                {
                    myHand.draw(deckOfCards); 
                    if(myHand.valueOf() > 21)
                    {
                        System.out.println(myHand.valueOf() + " is Busted!");
                        hitStay();
                    }
                    else if(myHand.valueOf() == 21)
                    {
                        System.out.println("BlackJack!");
                    }
                    else
                    {
                        System.out.println("Your hand is now worth " + myHand.valueOf());
                    }
                    
                    renderCards(middle, myHand);
                }
                else
                {
                    System.out.println("You are BUSTED!!!");
                }
            });
        playerHit.setVisible(false);

        playerStay = new Button("Stay");
        playerStay.setOnAction(e -> { hitStay(); });
        playerStay.setVisible(false);

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
    
    
    //copy pasted shamelessly from dealer pane
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
                iv.setTranslateX((50 * i) - 90);

                render.getChildren().add(iv);
            }
            return render;
        }
    }
    
    void hitStay()
    {
        playerHit.setVisible(false);
        playerStay.setVisible(false);
        isDone = true;
        //DealerPane.DoWork(); //goes here
    }

    public Button getStayButton(){
        return this.playerStay;
    }

    public void setPlayer(Player loadedPlayer){
        myPlayer = loadedPlayer;
    }
}
