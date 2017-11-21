/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author wpena
 */
public class BlackJackPlayers {

    /**
     * @param args the command line arguments
     */
    
    // Arraylist of Player 
    private ArrayList<Player> players;

    // The name of the file where the players data will be saved
    private static final String PLAYERS_FILE = "players.dat";

    //Object outputStream for saving and loading player objects
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public BlackJackPlayers() {
        players = new ArrayList<Player>();
    }
    
    //get players from file.
    public ArrayList<Player> getPlayers() throws IOException {
        loadPlayersFile();
        return players;
    }
    
    public Player getPlayer(String name){
        Player findPlayer = null;
        
        for(Player elem : players){
            if (elem.getName().equals(name))
                findPlayer = elem;
        }
        return findPlayer;     
    }
    
    //Checks if player already exists 
    public Player checkPlayerExists(String player_name){
        //Player player_exist = null;
        
        for (Player player_exist : players){ 
            if (player_exist.getName().equals(player_name)) {
                return player_exist;
            }
        }
        return null;
    }
    
    //login player, if player does not exist create one 
    public Player loginPlayer(String name){
        Player login_player;
        
        if (getPlayer(name) != null)
        {
            login_player = getPlayer(name);
            //System.out.println("Player found in list...");
        }
        else {
            login_player = new Player(name);
            players.add(login_player);
            //System.out.println("Player was not found in list... Adding Player To Players File.");
            updatePlayersFile();
        }
        return login_player;
    }
    
    //Add player to players ArrayList and update player data file.
    public int addPlayer(String name) throws IOException {
        Player add_player;
        if (getPlayer(name) != null)
        {
            add_player = getPlayer(name);
            //System.out.println("Can NOT Add " + name + ". Player already Exist!");
            return 1;
        }
        else {
            add_player = new Player(name);
            players.add(add_player);
            //System.out.println("Player was not found in list...");
            updatePlayersFile();
            
        }
        //return login_player;players.add(new Player(name));
        return 0;
    }
   
    //bets 10 points to be able to ante a game of Black Jack. 
    public boolean ante(String cplayer){
        Player player_play;
        
        player_play = getPlayer(cplayer);
        if ( player_play.getPoints() < 10 )
        {
            deletePlayer(cplayer);
            return false;
        }
        else
        {
            player_play.play();
            updatePlayersFile();
            return true;
        }
    }
    
    //Delete Player when has no points left.
    public boolean deletePlayer(String dplayer)
    {
        Player player_delete = null;
        player_delete = getPlayer(dplayer);
        if (player_delete != null )
        {
            players.remove(player_delete);
            updatePlayersFile();
            return true;
        }
        else
            return false;
    }
    
    
    //adds 20 points to player and updates player file
    public void win(String cplayer){
        Player winning_player;
        
        winning_player = getPlayer(cplayer);
        winning_player.win();
        updatePlayersFile();
        
    }
    
    //Adds 30 points when a player gets an ace and a 10 point card 
    public void blackjack(String cplayer){
        Player blackjack_player;
        
        blackjack_player = getPlayer(cplayer);
        blackjack_player.blackjack();
        updatePlayersFile();
    }
    
    //adds 10 points when a player has a draw 
    public void draw(String cplayer){
        Player draw_player;
        
        draw_player = getPlayer(cplayer);
        draw_player.draw();
        updatePlayersFile();       
    }
   
   //If player loses, check if he can play again if not logs player out. 
    public long lose(String lplayer){
        Player player_lose;
        
        player_lose = getPlayer(lplayer);
        return player_lose.getPoints();
        //updatePlayersFile();       
    }
    
    //load all the players from PLAYERS_FILE
    public void loadPlayersFile() throws IOException {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(PLAYERS_FILE));
            players = (ArrayList<Player>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[File Not Found Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
            }
        }
    }
    
    //Updates players file.
    public void updatePlayersFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(PLAYERS_FILE));
            outputStream.writeObject(players);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }
    
    //print all players
     public void printPlayers(){
        for(Player elem : players){
            elem.playerString();
        }
     }  
    
}