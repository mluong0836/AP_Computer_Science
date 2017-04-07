
package Sprites;

import javafx.scene.image.*;
import tankattack.*;


public class EnemyThree extends Enemy {

    public static String imageName = "minion.png";
        
    private double leftXLimit, rightXLimit;
    private boolean goingRight;

    public EnemyThree(double x, double y, World world, double leftXLimit, double rightXLimit, boolean goingRight) {
        
        super(EnemyThree.imageName, x, y, world);
        
        this.leftXLimit = leftXLimit;
        this.rightXLimit = rightXLimit;
        
        this.goingRight = goingRight;
        
        // health, width parent, height parent, isEnemy
        if (SpaceShooter.DIFFICULTY_SETTING == 1) {
            
            this.initHealthBar(50.0, this.width(), this.height(), true);
            
        }
        
        else if (SpaceShooter.DIFFICULTY_SETTING == 2) {
         
            this.initHealthBar(100.0, this.width(), this.height(), true);
            
        }
        
        else if (SpaceShooter.DIFFICULTY_SETTING == 3) {
         
            this.initHealthBar(200.0, this.width(), this.height(), true);
            
        }  
                
    }
    
    @Override
    public void updateEnemyXY() {
        
        if (!isAlive) {
            
            return;
            
        }
        
        if (goingRight) {
            
            double rightDestination = this.getTranslateX() + this.width() + SpaceShooter.EnemyOneSpeed;
            
            if (rightDestination >= rightXLimit) {
                
                goingRight = false;
                goLeft();
                
            }
            // Update x ++
            
            else {
                
                goRight();
                
            }
            
        }
        
        else {
            
            // Update x --
            double leftDestination = this.getTranslateX() - SpaceShooter.EnemyOneSpeed;
            
            if (leftDestination <= leftXLimit) {
                
                goingRight = true;
                goRight();
                
            }
            
            else {
                
                goLeft();
                
            }
            
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

    private void goLeft() {

        this.setTranslateX(this.getTranslateX() - SpaceShooter.EnemyOneSpeed);
    
    }

    private void goRight() {

        this.setTranslateX(this.getTranslateX() + SpaceShooter.EnemyOneSpeed);
    
    }
    
    @Override
    public void displayDeath() {

        this.setImage(new Image(getClass().getResourceAsStream("normalDeath.png")));
        this.isAlive = false;
    
    }
    
}
