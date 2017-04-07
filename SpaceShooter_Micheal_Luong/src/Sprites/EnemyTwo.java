
package Sprites;

import javafx.scene.image.*;
import tankattack.*;


public class EnemyTwo extends Enemy {

    public static String imageName = "enemyShip3.png";
        
    private double leftXLimit, rightXLimit;
    private boolean goingRight;

    public EnemyTwo(double x, double y, World world) {
        
        super(EnemyThree.imageName, x, y, world);
        
        this.leftXLimit = leftXLimit;
        this.rightXLimit = rightXLimit;
        
        this.goingRight = goingRight;
        
        // health, width parent, height parent, isEnemy
        if (SpaceShooter.DIFFICULTY_SETTING == 1) {
            
            this.initHealthBar(100.0, this.width(), this.height(), true);
            
        }
        
        else if (SpaceShooter.DIFFICULTY_SETTING == 2) {
         
            this.initHealthBar(200.0, this.width(), this.height(), true);
            
        }
        
        else if (SpaceShooter.DIFFICULTY_SETTING == 3) {
         
            this.initHealthBar(300.0, this.width(), this.height(), true);
            
        }  
                
    }
    
    @Override
    public void updateEnemyXY() {
        
        if (!isAlive) {
            
            return;
                    
        }
        
        double playerLocationX = this.world().playerSprite().getTranslateX();
        double playerLocationY = this.world().playerSprite().getTranslateY();
        
        boolean isPlayerToTheRightOfBoss = (playerLocationX > this.getTranslateX());
        boolean isPlayerToTheDownOfBoss = (playerLocationY > this.getTranslateY());
        
        if (!isPlayerToTheRightOfBoss && !isPlayerToTheDownOfBoss) {
            
            goLeft();
            goUp();
            
        }
        
        else if (!isPlayerToTheRightOfBoss && isPlayerToTheDownOfBoss) {
            
            goLeft();
            goDown();
            
        }
        
        else if (isPlayerToTheRightOfBoss && !isPlayerToTheDownOfBoss) {
            
            goRight();
            goUp();
            
        }
        
        else if (isPlayerToTheRightOfBoss && isPlayerToTheDownOfBoss) {
            
            goRight();
            goDown();
            
        }
        
    }

    @Override
    public boolean isFiring() {
        
        return false;
        
    }

    private void goLeft() {

        this.setTranslateX(this.getTranslateX() - SpaceShooter.EnemyThreeSpeed);
    
    }

    private void goRight() {

        this.setTranslateX(this.getTranslateX() + SpaceShooter.EnemyThreeSpeed);
    
    }
    
    private void goUp() {

        this.setTranslateY(this.getTranslateY() - SpaceShooter.EnemyThreeSpeed);
    
    }

    private void goDown() {

        this.setTranslateY(this.getTranslateY() + SpaceShooter.EnemyThreeSpeed);
    
    }
    
    @Override
    public void displayDeath() {

        this.setImage(new Image(getClass().getResourceAsStream("normalDeath.png")));
        this.isAlive = false;
    
    }
    
}
