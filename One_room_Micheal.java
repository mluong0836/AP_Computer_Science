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

    static Scanner pdecision = new Scanner(System.in); //this will identify the player's decision
    static String choice; //this string will be used to document the choice the player made
    static Random rand = new Random();//this will generate random ints that will determine what room you are in
    static int room;//the randomly generated ints will be recorded here. Depending on what # is selected, you will be in either of the three rooms
    static boolean gameplay = true; //  If true, loop continues, if false, game ends. 
               
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        room = rand.nextInt(3);//randomly selects a # from 0-2. Each will correspond to a different room.
        intro();//calls a method that introduces the storyline
        
        while(gameplay) { // this while loop will be responsible for ending or continuing the game
            System.out.println("Here are some hints...");
            System.out.println("Do you want hint 1,2, or 3?");
            choice = pdecision.nextLine();//records what hint you wanted...
            if(room == 0) { //stadium
                stadium();
            } else if(room == 1) { //kitchen
                kitchen();
            } else { //library
                library();
            }
        }
    }
    
    public static void intro() { //method for the intro storyline. I encapsulated it so it can be called upon later on.
        System.out.println("You are in an abandoned house and have to find your way out");
        timer(2000);//goes to the timer method, which has a parameter of 2000 milliseconds as a pause
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
    
            /********************************************************
                    
                 Method for my timer to make a pause in the game
                    
            /********************************************************/
    
    static void timer(int a) { //parameter int a will be the amount of milliseconds to pause/sleep
        try {
            Thread.sleep(a);
        } catch (InterruptedException ex) {
            Logger.getLogger(One_room_Micheal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
            /********************************************************
                    
                     method for the stadium if int room was 0 
                    
            /********************************************************/
    
    static void stadium() { //method for the stadium if int room was 0
        if(choice.contains("1") || choice.contains("o")) {
            System.out.println("This where you see your favorite team play.\n");
        } else if(choice.contains("2")|| choice.contains("t")) {
            System.out.println("This is a gigantic room.\n");
        } else {
            System.out.println("This room is where you play basketball.\n");
        }
        
        System.out.println("Where do you think you are in: the stadium, kitchen, or library?\n");
        choice = pdecision.nextLine();// records player's guess to string choice
        if(choice.contains("s")|| choice.contains("S")) {
            System.out.println("You win!\n");
            gameplay = false;
        } else {
            System.out.println("NOPE. Do you want to try again(t) or quit(q).");
            choice = pdecision.nextLine();//records if player wants to continue playing or not
            if(choice.contains("q")|| choice.contains("Q")) {
                gameplay = false;//ends gameplay loop since player chose to quit
            }
        } 
    }
        
            /********************************************************
                    
                     method for the kitchen if int room was 1 
                    
            /********************************************************/
    
    static void kitchen() { 
        
        if(choice.contains("1") || choice.contains("o")) {
            System.out.println("I am hungry...\n");
        } else if(choice.contains("2")|| choice.contains("t")) {
            System.out.println("Mom cooks here.\n");
        } else {
            System.out.println("This is where the oven is located.\n");
        }
        
        System.out.println("Where do you think you are in: the stadium, kitchen, or library?\n");
        choice = pdecision.nextLine();// records player's guess to string choice
        if(choice.contains("k")|| choice.contains("K")) {
            System.out.println("You win!\n");
            gameplay = false;
        } else {
            System.out.println("NOPE. Do you want to try again(t) or quit(q).");
            choice = pdecision.nextLine();
            if(choice.contains("q")|| choice.contains("Q")) {
                gameplay = false;//ends gameplay loop since player chose to quit
            }
        }
    }
    
            /********************************************************
                    
                     method for the library if int room was 2 
                    
            /********************************************************/
    
    static void library() { 
        if(choice.contains("1") || choice.contains("o")) {
            System.out.println("You go here to do research.\n");
        } else if(choice.contains("2")|| choice.contains("t")) {
            System.out.println("A lot of Books...\n");
        } else {
            System.out.println("Remember to be quiet here.\n");
        }
        
        System.out.println("Where do you think you are in: the stadium, kitchen, or library?\n");
        choice = pdecision.nextLine();// records player's guess to string choice
        
        if(choice.contains("l")|| choice.contains("L")) {
            System.out.println("You win!\n");
            gameplay = false;//ends the game play loop
        } else {
            System.out.println("NOPE. Do you want to try again(t) or quit(q).");
            choice = pdecision.nextLine();
            if(choice.contains("q")|| choice.contains("Q")) {
                gameplay = false;//ends gameplay loop since player chose to quit
            }
        }
    }
}
