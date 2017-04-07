package tankattack;

import Sprites.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class FourthWorld extends World {

    @Override
    public void createInitialSprites() {
        
        createPlayerSprite();
        // Other sprites
        createSprites();
        
    }

    @Override
    public void signalEndOfLevel() {

        SpaceShooter.sharedInstance.displayStartMenu();
    
    }
    
    @Override
    public Scene createScene() {
        
        this.setGroup(new Group());
        createInitialSprites();
        
        this.setScene(new Scene(this.group(), SpaceShooter.gameWidth, SpaceShooter.gameHeight, Color.BURLYWOOD));
        this.scene().setOnKeyPressed(e -> handleKeyInput(e));
        this.scene().setOnKeyReleased(e -> handleKeyRelease(e));
        return this.scene();
        
    }

    private void createSprites() {
        
        //         Enemy 1
        new EnemyTwo(SpaceShooter.gameWidth/3, 40.0, this);  
        
    }
    
}
