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
         boolean can_play = false;
        //Player john = new Player("john");
        try {
            bplayers.loadPlayersFile();
            bplayers.loginPlayer("john");
            bplayers.loginPlayer("jack");
            bplayers.loginPlayer("anna");
            bplayers.loginPlayer("wilson");
            //bplayers.loginPlayer("jack");
            //bplayers.ante("jack");
            can_play = bplayers.ante("jack");
            if (!can_play)
                System.out.println("This guy is broke and can not play..." );
            if (can_play) bplayers.lose("jack");
            can_play = bplayers.ante("wilson");
            if (!can_play)
                System.out.println("This guy is broke and can not play..." );
            //bplayers.lose("wilson");
            bplayers.ante("john");
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
