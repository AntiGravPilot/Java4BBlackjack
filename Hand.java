import java.util.ArrayList;

//This Object represents the cards that belong to one player.

//Author Max Nelson

public class Hand
{
    ArrayList<Card> cards;
    
    Hand()
    {
        cards = new ArrayList();
    }
    
    void draw(Deck topDeck)
    {
        cards.add(topDeck.draw());
    }
    
    void draw(Deck topDeck, int times)
    {
        for(int index = 0; index < times; index++)
        {
            draw(topDeck);
        }
    }
    
    int valueOf()
    {
        int total = 0;
        int aces = 0; //aces are default 11, we makes aces 1 until all are 1 or we are <= 21
        
        for(int index = 0; index < cards.size(); index++)
        {
            total += cards.get(index).getValue();
            if(cards.get(index).value == 11)
            {
                aces++;
            }
        }
        
        while(total > 21 && aces > 0)
        {
            total -= 10;
            aces--;
        }
        
        return total;
    }
    
    int compareTo(Hand otherHand) //returns positive if we are larger than passed hand
    {
        return (valueOf() - otherHand.valueOf());
    }
    
    void clear() //empties all cards from a hand
    {
        cards = new ArrayList();
    }
    
   
}
