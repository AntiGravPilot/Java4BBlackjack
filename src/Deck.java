import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.image.Image;

/**
 *
 * @author mnelson39
 */
public class Deck
{  
    ArrayList<Card> cards;
    
    Deck(String imageFolder){
        cards = Deck.newDeck(imageFolder);
    }
    
    private void add(Card toAdd)
    {
        cards.add(toAdd);
    }
    
    Card draw()
    {
        Card retVal = cards.get(0);
        cards.remove(0);
        return retVal;
    }
    
    void shuffle()
    {
        Collections.shuffle(cards);
    }
    
    public static ArrayList<Card> newDeck(String folder){
        ArrayList<Card> retVal = new ArrayList();
        
        int value = 0;
        String suitName = "joker";
        
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
                System.out.println(folder + suitName + Integer.toString(rank) + ".png");
                retVal.add(new Card(value, new Image(folder + suitName + Integer.toString(rank) + ".png"), new Image(folder + "back.png")));
            }
            
        }
        
        return retVal;
    }
}
