import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mnelson39
 */
public class Hand
{
    ArrayList<Card> cards;

    public Hand()
    {
        cards = new ArrayList<>();
    }
    
    void draw(Deck topDeck)
    {
        cards.add(topDeck.draw());
    }
    
    
    
   
}
