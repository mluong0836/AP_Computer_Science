/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine_micheal_luong;

import java.util.Scanner;

/**
 *
 * @author dong
 */
public class Vending_Machine_Micheal_Luong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vending_Machine vm = new Vending_Machine();
        vm.Init();
        System.out.println("There's a candy vending machine right here.");
        boolean loop = true;
        while (loop) {
            System.out.println("You grab your wallet out and examine the options available.");
            vm.printOptions();
            System.out.println("To buy a candy, type in the location of the candy.");
            Scanner scan = new Scanner(System.in);
            String response = scan.nextLine();
        }
    }

}

/*
public static void Separate(String str) {
          String number = "";
          String letter = "";
      String symbol = "";
          for (int i = 0; i < str.length(); i++) {
                 char a = str.charAt(i);
                 if (Character.isDigit(a)) {
                       number = number + a;

                 } else {
                       letter = letter + a;


         }
          }
          System.out.println("Alphabets in string:"+letter);
          System.out.println("Numbers in String:"+number);   
   }

 */
