import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.image.Image;

//This Object represents the deck that players draw from over the course of the
//game. the majority of its methods serve to allow the deck to be refilled with
//a single copy of each card easily. there are no jokers

//Author Max Nelson

public class Deck
{
    // todo Make card folder accessible from project folder (should work with ./PNGcards)
    final String defaultImageFolder = "file:\\\\\\C:\\Users\\bmontes5\\Desktop\\PNGcards\\";
    ArrayList<Card> newDeck;//never changes after initial load
    ArrayList<Card> cards;
    
    Deck(String imageFolder)
    {
        newDeck = Deck.newDeck(imageFolder);
        cards = new ArrayList(newDeck);
    }
    
    Deck()
    {
        newDeck = Deck.newDeck(defaultImageFolder);
        cards = new ArrayList(newDeck);
    }
    
    Card draw()
    {
        if(cards.isEmpty())
        {
            System.out.println("Deck out of cards!");
            reset();
        }
        Card retVal = cards.get(0);
        cards.remove(0);
        return retVal;
    }
    
    void reset()
    {
        cards = new ArrayList(newDeck);
        shuffle();
    }
     
    void shuffle()
    {
        Collections.shuffle(cards);
    }
    
    private static ArrayList<Card> newDeck(String folder)
    {
        System.out.println("Loading Card Images");
        
        ArrayList<Card> retVal = new ArrayList();
        
        int value;
        String suitName;
        
        for(int suit = 0; suit < 4; suit++)
        {
            for(int rank = 1; rank < 14; rank++)
            {
                if(rank == 1)
                {
                    value = 11;
                }
                else if(rank > 9)
                {
                    value = 10;
                }
                else
                {
                    value = rank;
                }
                switch(suit)
                {
                    case 0: suitName = "diamond";
                    break;
                    case 1: suitName = "club";
                    break;
                    case 2: suitName = "heart";
                    break;
                    case 3: suitName = "spade";
                    break;
                    default: suitName = "joker";
                    break;
                }
                System.out.println(suitName + Integer.toString(rank));
                retVal.add(new Card(value, new Image(folder + suitName + Integer.toString(rank) + ".png"), new Image(folder + "back.png")));
            }
            
        }
        
        return retVal;
    }
}
