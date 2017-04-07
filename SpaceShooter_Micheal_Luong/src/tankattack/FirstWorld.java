
// This entire file is part of my masterpiece.
// Ruslan Ardashev

package tankattack;

import Sprites.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javax.imageio.*;



public class FirstWorld extends World {

    @Override
    public void createInitialSprites() {
        
        createPlayerSprite();
        // Other sprites
        createEnemies();
        
        
    }

    @Override
    public void signalEndOfLevel() {

        SpaceShooter.sharedInstance.transitionFromFirstWorldToSecondWorld();
    
    }

    private void createEnemies() {
                
        //Enemy 1
        EnemyThree one = new EnemyThree(50.0, 40.0, this, 30.0, 150.0, true);
        
        
        // Enemy 2
        EnemyOne two = new EnemyOne(245.0, 80.0, this, 150.0, 400.0, false);
        
        
        // Enemy 3
        EnemyOne three = new EnemyOne(540.0, 60.0, this, 400.0, 560.0, true);
        
        
        
    }

}
