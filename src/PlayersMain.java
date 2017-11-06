 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackplayers;

import java.util.ArrayList;

/**
 *
 * @author wpena
 */
public class PlayersMain {
    public static void main(String[] args) {
        
   BlackJackPlayers bplayers= new BlackJackPlayers();
        
        //Player john = new Player("john");
        try {
            bplayers.loadPlayersFile();
            bplayers.addPlayer("john");
            bplayers.addPlayer("jack");
            bplayers.addPlayer("anna");
            bplayers.loginPlayer("wilson");
            bplayers.loginPlayer("jack");
            bplayers.play("jack");
            bplayers.lose("jack");
            bplayers.play("wilson");
            bplayers.lose("wilson");
            bplayers.play("john");
            System.out.println("After john playing");
            bplayers.blackjack("john");
            bplayers.printPlayers();
            //bplayers.draw("john");
            System.out.println("After john getting a draw");
            bplayers.printPlayers();
            
            //Player newPlayer = pplayers.loginPlayer("jack");
            //john.playerString();
            //pplayers.a
        } catch (Exception e) {
            System.out.println("error adding players");
        }
        
        //printing players.
        bplayers.printPlayers();
    } 
}
