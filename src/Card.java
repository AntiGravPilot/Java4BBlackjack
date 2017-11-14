import javafx.scene.image.Image;

//This object represents a single card
//Ace has a value of 11, and all face cards have a value of 10

//Author Max Nelson

public class Card
{
    int value;
    Image front;
    Image back;
    Boolean faceUp;
    
    Card()
    {
        value = 0;
        front = null;
        back = null;
        faceUp = true;
    }
    
    Card(int iv, Image ifront, Image ib) //if was taken
    {
        value = iv;
        front = ifront;
        back = ib;
        faceUp = true;
    }
    
    Card(int iv, String ifront, String ib)
    {
        value = iv;
        front = new Image(ifront);
        back = new Image(ib);
        faceUp = true;
    }
    
    Image getImage()
    {
        if(faceUp)
        {
            return front;
        }
        else
        {
            return back;
        }
    }
    
    int getValue()
    {
        return value;
    }
    
    void flip()
    {
        if(faceUp)
        {
            faceUp = false;
        }
        else
        {
            faceUp = true;
        }
    }
}
