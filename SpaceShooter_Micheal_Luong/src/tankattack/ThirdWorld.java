package tankattack;

import Sprites.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class ThirdWorld extends World {

    @Override
    public void createInitialSprites() {
        
        createPlayerSprite();
        // Other sprites
        createSprites();
        
    }

    @Override
    public void signalEndOfLevel() {

        SpaceShooter.sharedInstance.transitionFromThirdWorldToFourthWorld();
    
    }
    
    @Override
    public Scene createScene() {
        
        this.setGroup(new Group());
        createInitialSprites();
        
        this.setScene(new Scene(this.group(), SpaceShooter.gameWidth, SpaceShooter.gameHeight, Color.SEAGREEN));
        this.scene().setOnKeyPressed(e -> handleKeyInput(e));
        this.scene().setOnKeyReleased(e -> handleKeyRelease(e));
        return this.scene();
        
    }

    private void createSprites() {        
        //         Enemy 1
        EnemyOne one = new EnemyOne(50.0, 40.0, this, 30.0, 350.0, true);
        
        //         Enemy 2
        EnemyOne two = new EnemyOne(100.0, 60.0, this, 330.0, 540.0, true);
    
    }
    
}
