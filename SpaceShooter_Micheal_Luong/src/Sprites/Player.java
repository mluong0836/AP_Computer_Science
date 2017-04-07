package Sprites;

import javafx.scene.image.*;
import tankattack.*;


public class Player extends Sprite {
    
    public static String imageName = "SpacePlayer.png";
    
    // coordinates recorded in these arrays
    private double[] location; //x,y
    private double[] newXY; //x,y
    
    public Player(double x, double y, World world) {
        
        super(Player.imageName, x, y, world);
        
        // health, width parent, height parent, isEnemy
        
        if (SpaceShooter.DIFFICULTY_SETTING == 1) {
            
            this.initHealthBar(200.0, this.width(), this.height(), false);
            
        }
        
        else if (SpaceShooter.DIFFICULTY_SETTING == 2) {
         
            this.initHealthBar(100.0, this.width(), this.height(), false);
            
        }
        
        else if (SpaceShooter.DIFFICULTY_SETTING == 3) {
         
            this.initHealthBar(50.0, this.width(), this.height(), false);
            
        }        
                                
    }
         
    public void updateLocation() {
                
        if (location == null) {
            
            location = new double[2];
            
        }
        
        location[0] = this.getTranslateX();
        location[1] = this.getTranslateY();            
                
        double playerWidth  = this.width();
        double playerHeight = this.height();

        if (newXY == null) {
            
            newXY = new double[2];
            
        }
        
        newXY = Controls.getNewXY(location, playerWidth, playerHeight, SpaceShooter.PLAYER_SPEED);
        
        this.setTranslateX(newXY[0]);
        this.setTranslateY(newXY[1]);    
    
    }
 
    public double getBulletOffsetX() {
        
        return (this.getTranslateX() + this.width()/2 );
        
    }
    
    public double getBulletOffsetY() {
        
        return (this.getTranslateY());
        
    }
    
    @Override
    public void checkForDeathAndReactAppropriately() {

        if (this.getHealthBar().getHealth() <= 0) {
            
            displayDeath();
            this.world().endOfLevelFailure();
            
        }

    }

    private void displayDeath() {

        this.setImage(new Image(getClass().getResourceAsStream("normalDeath.png")));
    
    }
    
}
