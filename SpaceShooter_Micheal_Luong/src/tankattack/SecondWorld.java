package tankattack;

import Sprites.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class SecondWorld extends World {

    @Override
    public void createInitialSprites() {
        
        createPlayerSprite();
        // Other sprites
        createBossSprite();
        
    }

    @Override
    public void signalEndOfLevel() {

        SpaceShooter.sharedInstance.transitionFromSecondWorldToThirdWorld();
    
    }
    
    @Override
    public Scene createScene() {
        
        this.setGroup(new Group());
        createInitialSprites();
        
        this.setScene(new Scene(this.group(), SpaceShooter.gameWidth, SpaceShooter.gameHeight, Color.PURPLE));
        this.scene().setOnKeyPressed(e -> handleKeyInput(e));
        this.scene().setOnKeyReleased(e -> handleKeyRelease(e));
        return this.scene();
        
    }

    private void createBossSprite() {

        new Boss(SpaceShooter.gameWidth/2, 80.0, this);
    
    }
    
}
