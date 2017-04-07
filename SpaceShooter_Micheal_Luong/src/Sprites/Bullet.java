

package Sprites;

import tankattack.*;


public class Bullet extends Sprite {

    public static String imageName = "bullet.png";
    
    
    private boolean goingUp;
    
    
    public Bullet(double x, double y, World world, boolean goingUp) {
        
        super(Bullet.imageName, x, y, world);
        this.goingUp = goingUp;
        
    }
    
    public void updateXY() {
        
        boolean outOfBounds = 
                (this.getTranslateY() > SpaceShooter.gameHeight) 
                || 
                (this.getTranslateY() < 0.0);
                
        if (outOfBounds) {
            
            addSelfToRemoveFromWorldArray();
            return;
            
        }
        
        else {
                        
            if (goingUp) {

                // Subtract y. y is actually up. Player.
                this.setTranslateY(this.getTranslateY() - SpaceShooter.BULLET_SPEED);

            }

            else {

                // Add y. Enemies code. "Down" is +y
                this.setTranslateY(this.getTranslateY() + SpaceShooter.BULLET_SPEED);

            }
            
        }
        
    }

    public void addSelfToRemoveFromWorldArray() {

        this.world().addToOutOfBoundaryBulletsArray(this);
        
    }
    
    
    
}
