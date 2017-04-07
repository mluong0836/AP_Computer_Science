
package Sprites;

import javafx.scene.image.*;
import tankattack.*;


public class Boss extends Enemy {

    public static String imageName = "enemyShip2.png";
    
    public Boss(double x, double y, World world) {
        
        super(Boss.imageName, x, y, world);
        
        if (SpaceShooter.DIFFICULTY_SETTING == 1) {
            
            this.initHealthBar(1000.0, this.width(), this.height(), true);
            
        }
        
        else if (SpaceShooter.DIFFICULTY_SETTING == 2) {
         
            this.initHealthBar(2000.0, this.width(), this.height(), true);
            
        }
        
        else if (SpaceShooter.DIFFICULTY_SETTING == 3) {
         
            this.initHealthBar(4000.0, this.width(), this.height(), true);
            
        } 
        
    }

    @Override
    public void updateEnemyXY() {

        if (!isAlive) {
            return;
        }
        
        double playerLocation = this.world().playerSprite().getTranslateX();
        
        boolean isPlayerToTheRightOfBoss = (playerLocation > this.getTranslateX());
        
        if (isPlayerToTheRightOfBoss) {
            
            goRight();
            
        }
        
        else {
            
            goLeft();
            
        }
    
    }

    @Override
    public boolean isFiring() {
        
        if (isAlive) {
            
            return (Math.random() <= .13);
            
        }
        
        else {
            
            return false;
            
        }
        
        
        
    }
    
    @Override
    public void displayDeath() {

        this.setImage(new Image(getClass().getResourceAsStream("bossDeath.png")));
        this.isAlive = false;
    
    }

    private void goRight() {

        this.setTranslateX(this.getTranslateX() + SpaceShooter.BOSS_SPEED);
    
    }

    private void goLeft() {

        this.setTranslateX(this.getTranslateX() - SpaceShooter.BOSS_SPEED);
    
    }

}
