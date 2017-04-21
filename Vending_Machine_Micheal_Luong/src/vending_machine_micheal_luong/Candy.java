/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine_micheal_luong;

/**
 *
 * @author dong
 */
public class Candy {
    private String name;
    private String type;
    private int calories;
    private double price;
    private int amount;

    public Candy(String name, String type, int calories, double price, int amount) {
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
