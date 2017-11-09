package blackjack09;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

/**
 *
 * @author wpena
 */
public class Player implements Serializable {
 private String name;
    private long points;
    
    public Player(String new_player){
        this.name = new_player;
        this.points = 100;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the points
     */
    public long getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(long points) {
        this.points = points;
    }
    
    //deducts 10 points from player and returns the remaining points.
    public long play(){
        this.points -= 10;      
        return this.points;
    }
    
    public void win(){
        this.points += 20;
    }
  
    //Adds 30 points to player which has a black jack.
    public void blackjack()
    {
        this.points += 30;
    }
    
    //player has a draw and gets his original points bet back
    public void draw(){
        this.points +=10;
    
    }
    
    // when a player looses checks, if the player can play again if points < 0
    // Deletes the player from the file.
    public long lose(){
        return this.points;
    }
    
    
    public void playerString(){
        System.out.println("Player name: " + this.name + " points: " + this.points);
    }
    
}
