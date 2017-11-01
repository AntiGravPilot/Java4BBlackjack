import javafx.scene.image.Image;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mnelson39
 */
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
