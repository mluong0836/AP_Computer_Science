/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one_room_micheal;

    import java.util.Scanner;
    import java.util.Random;
    import java.util.logging.Level;
    import java.util.logging.Logger;

/**
 *
 * @author micheal
 */
public class One_room_Micheal {

    Scanner pdecision = new Scanner(System.in); //this will identify the player's decision
    String choice; //this string will be used to document the choice the player made
    static Random rand = new Random();//this will generate random ints that will determine what room you are in
    static int room;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean gameplay = true;
        room = rand.nextInt(3);//randomly selects a # from 0-2. Each will correspond to a room.
        intro();
        /* 
           boolean to determine when to end the game. 
           If true, loop continues, if false, game ends.
        */
        
        while(gameplay) { // this while loop will be responsible for ending or continuing the game
            System.out.println("Here are some hints...");
            System.out.println("Do you want hint 1,2, or three?");
        }
    }
    
    public static void intro() {
        System.out.println("You are in an abandoned house and have to find your way out");
        timer(2000);
        System.out.println("before it's too late. However, in order for you to do this, you must");
        timer(2000);
        System.out.println("correctly guess the room that you are in.\n\n");
        timer(2000);
        System.out.println("Don't worry, you'll have several hints to guide you.\n");
        timer(2000);
        System.out.println("Just pick the RIGHT one...");
        timer(2000);
        System.out.println("You walk in a dark room with no lights. Where are you?");
        timer(2000);
    }
    
    static void timer(int a) { //parameter int a will be the amount of milliseconds to pause
        try {
            Thread.sleep(a);
        } catch (InterruptedException ex) {
            Logger.getLogger(One_room_Micheal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
