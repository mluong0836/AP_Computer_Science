
package Sprites;

import javafx.scene.image.*;
import tankattack.*;


public class EnemyOne extends Enemy {

    public static String imageName = "enemyShip2.png";
        
    private double leftXLimit, rightXLimit;
    private boolean goingRight;

    public EnemyOne(double x, double y, World world, double leftXLimit, double rightXLimit, boolean goingRight) {
        
        super(EnemyThree.imageName, x, y, world);
        
        this.leftXLimit = leftXLimit;
        this.rightXLimit = rightXLimit;
        
        this.goingRight = goingRight;
        
        // health, width parent, height parent, isEnemy
        this.initHealthBar(200.0, this.width(), this.height(), true);
                
    }
    
    @Override
    public void updateEnemyXY() {
        
        if (!isAlive) {
            
            return;
            
        }
        
        if (goingRight) {
            
            double rightDestination = this.getTranslateX() + this.width() + SpaceShooter.EnemyTwoSpeed;
            
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
            double leftDestination = this.getTranslateX() - SpaceShooter.EnemyTwoSpeed;
            
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

        this.setTranslateX(this.getTranslateX() - SpaceShooter.EnemyTwoSpeed);
    
    }

    private void goRight() {

        this.setTranslateX(this.getTranslateX() + SpaceShooter.EnemyTwoSpeed);
    
    }
    
    @Override
    public void displayDeath() {

        this.setImage(new Image(getClass().getResourceAsStream("normalDeath.png")));
        this.isAlive = false;
    
    }
    
}
