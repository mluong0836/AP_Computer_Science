/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine_micheal_luong;

    import java.util.ArrayList;

/**
 *
 * @author dong
 */
public class Vending_Machine {
    private Candy candy[][][] = new Candy[3][3][1];
    private ArrayList<Candy> stock = new ArrayList<Candy>();
    private String[] labels = new String[9];//used for reference
    
    public void Init() {
        stock.add(new Candy("KitKat", "Chocolate", 200, 2.50, 10));
        stock.add(new Candy("Snickers", "Chocolate", 200, 2.50, 10));
        stock.add(new Candy("m&m's", "Chocolate", 200, 2.50, 10));
        stock.add(new Candy("Herseys", "Chocolate", 200, 2.50, 10));
        stock.add(new Candy("skittles", "fruity", 200, 2.50, 10));
        stock.add(new Candy("Twix", "fruity", 200, 2.50, 10));
        stock.add(new Candy("GummiWorms", "gummy", 200, 2.50, 10));
        stock.add(new Candy("ButterFinger", "Chocolate", 200, 2.50, 10));
        stock.add(new Candy("StarBurst", "fruity", 200, 2.50, 10));
        
        int counter = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                candy[i][j][0] = stock.get(counter);
                labels[counter] = stock.get(counter).getName();
                counter++;
            }
        }
    }
    
    public boolean isEmpty(Candy candy) {
        if(candy.getAmount() >= 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public void printOptions() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(candy[i][j][0].getName() + "  ");
            }
            System.out.println("");
        }
    }
    
    /*This will only run after we identify whether there's still that specific candy left*/
    public void info(Candy candy) {
        System.out.println("_______________________________________");
        System.out.println("Candy Name: " + candy.getName());
        System.out.println("Candy Type: " + candy.getType());
        System.out.println("Calories: " + candy.getCalories());
        System.out.println("Price: " + candy.getPrice());
        System.out.println("_______________________________________");
    } 

    //still debating if i need it or not
    public ArrayList<Candy> getStock() {
        return stock;
    }
    
    public Candy[][][] getCandy() {
        return candy;
    }

    public String[] getLabels() {
        return labels;
    }    
}
