

package tankattack;

import javafx.animation.*;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.transform.*;
import javafx.stage.Stage;
import javafx.util.*;

public class SpaceShooter extends Application {
    
    public static SpaceShooter sharedInstance;
    
    public static final int NUM_FRAMES_PER_SECOND = 30;
    public static final double gameWidth = 600;
    public static final double gameHeight = 600;
    
    public static double buttonWidth = gameWidth / 5;
    public static double buttonHeight = gameWidth / 10;
    
    public static double PLAYER_SPEED = 2.5;
    public static double EnemyOneSpeed = 2.1;
    public static double EnemyTwoSpeed = 3.5;
    public static double EnemyThreeSpeed = 5;
    public static double BOSS_SPEED = 1.4;
    
    public static double BULLET_SPEED = 5.5;
    public static double BULLET_DAMAGE = 10;
    
    public static int DIFFICULTY_SETTING = 2;
    
    //this is similar to the game states in slick 2d
    private Stage stage;
    private World world;
    private Scene scene;
    
    private Group root;
    
    private VBox startQuitButtonsBox;
    private VBox difficultyButtonsBox;
    
    private BorderPane difficultyLabel;
    
    // Setters & Getters
    public Stage stage() {
        
        return this.stage;
        
    }
    
    // Actual Methods
    @Override
    public void start(Stage primaryStage) {
        
        sharedInstance = this;
        stage = primaryStage;
        displayStartMenu();

    }
    
    public void displayStartMenu() {
        
        stage.setTitle("Main Menu");
        root = new Group();
        final Scene mainMenu = new Scene(root, SpaceShooter.gameWidth, SpaceShooter.gameHeight, Color.SEAGREEN);
        
        // Launch Background Animation
        launchAnimationForDisplayMenu(stage);
        
        // Create Buttons
        createItemsForDisplayMenu();
        
        stage.setScene(mainMenu);
        stage.show();
        
        slideInTitle();
        
    }
    
    private void launchAnimationForDisplayMenu(Stage stage) {

        SpaceMoving();
        animateCircleExplosions();
        
    }
    
    private void createItemsForDisplayMenu() {
        
        VBox v = new VBox(SpaceShooter.gameHeight/20);
        startQuitButtonsBox = v;
        
        v.setTranslateY(SpaceShooter.gameHeight / 2);
        v.setMaxHeight(gameHeight / 2);
        v.setTranslateX(SpaceShooter.gameWidth/2 - SpaceShooter.buttonWidth/2);
        
        createButtonsForMainMenu(v);
        createDifficultyLabelForMainMenu(v);

        root.getChildren().add(v);
        
    }
    
    private void displayDifficultyMenu() {
        
        root.getChildren().remove(this.startQuitButtonsBox);
        
        VBox v = new VBox(SpaceShooter.gameHeight/20);
        difficultyButtonsBox = v;
        
        v.setTranslateY(SpaceShooter.gameHeight / 2);
        
        v.setTranslateX(SpaceShooter.gameWidth/2 - SpaceShooter.buttonWidth/2);
        
        Button easy = this.createButton("EASY");
        
        easy.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                
                SpaceShooter.setEasy();
                removeDifficultyButtonsAndDisplayMenuAgain();
                
            }
            
        });
        
        Button medium = this.createButton("MEDIUM");
        
        medium.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                
                SpaceShooter.setMedium();
                removeDifficultyButtonsAndDisplayMenuAgain();
                
            }
            
        });
        
        Button hard = this.createButton("HARD");
        
        hard.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                
                SpaceShooter.setHard();
                removeDifficultyButtonsAndDisplayMenuAgain();
                
            }
            
        });
                
        v.getChildren().addAll(easy, medium, hard);
        
        root.getChildren().add(v);
        
    }
    
    public static void setEasy() {
        
        EnemyOneSpeed = 1.4;
        EnemyTwoSpeed = 2.5;
        EnemyThreeSpeed = 3;
        BOSS_SPEED = 1;
        DIFFICULTY_SETTING = 1;
        
    }
    
    public static void setMedium() {
        
        EnemyOneSpeed = 2.1;
        EnemyTwoSpeed = 3.5;
        EnemyThreeSpeed = 5;
        BOSS_SPEED = 1.4;
        DIFFICULTY_SETTING = 2;
        
    }
    
    public static void setHard() {
        
        EnemyOneSpeed = 3;
        EnemyTwoSpeed = 4.2;
        EnemyThreeSpeed = 5.6;
        BOSS_SPEED = 3;
        DIFFICULTY_SETTING = 3;
        
    }
    
    private void removeDifficultyButtonsAndDisplayMenuAgain() {
     
        root.getChildren().remove(difficultyButtonsBox);
        createItemsForDisplayMenu();
        
    }
    
    private Button createButton(String text) {
        
        Button returnButton = new Button();
        
        if (!text.isEmpty()) {
            
            returnButton.setText(text);
            
        }
        
        returnButton.setMinSize(buttonWidth, buttonHeight);
        
        return returnButton;
        
    }
    
    public void transitionFromFirstWorldToSecondWorld() {
        
        world = new SecondWorld();
        initCurrWorld();
        
    }
    
    public void transitionFromSecondWorldToThirdWorld() {
        
        world = new ThirdWorld();
        initCurrWorld();
        
    }
    
    public void transitionFromThirdWorldToFourthWorld() {
        
        world = new FourthWorld();
        initCurrWorld();
        
    }

    private void initCurrWorld() {
        
        // Prior to this method, set currWorld. 
        
        scene = world.createScene();
        stage.setScene(scene);
        world.initAnimation();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void slideInTitle() {

        BorderPane b = new BorderPane();
        b.setMinWidth(SpaceShooter.gameWidth);
        b.translateYProperty().set(-60.0);
        
        Label l = new Label("Space Shooter");
        l.setFont(new Font("Arial", 80));
        l.setTextFill(Color.GREEN);
        
        b.setCenter(l);
        
        KeyValue kVal = new KeyValue(b.translateYProperty(), SpaceShooter.gameHeight/3);
        KeyFrame k = new KeyFrame(Duration.millis(3000), kVal);
               
        Timeline timeL = new Timeline();  
        timeL.getKeyFrames().add(k);  
        timeL.setCycleCount(1);  
        timeL.play();  
        
        root.getChildren().add(b);
    
    }

    private void animateCircleExplosions() {
         
        Group circles = new Group();

        for(int cont = 0 ; cont < 30 ; cont++) {  
            
            addAnimatedCircleToGroup(circles);
            
        }  
        
        root.getChildren().add(circles);
    
    }
    
    private void addAnimatedCircleToGroup(Group g) {
        
        Circle circle = new Circle();  
            
        if (Math.random() <= 0.5) {
            circle.setFill(Color.CRIMSON); 
        }

        else {
            circle.setFill(Color.YELLOW);
        }
            
        circle.setEffect(new GaussianBlur(Math.random() * 8 + 2));  
        circle.setOpacity(Math.random());  
        circle.setRadius(Math.random()*30);  
        circle.setCenterX(SpaceShooter.gameWidth * Math.random());
        circle.setCenterY(SpaceShooter.gameHeight * Math.random());

        g.getChildren().add(circle);  

        double randScale = (Math.random() * 4) + 1;  

        KeyValue kValueX = new KeyValue(circle.scaleXProperty() , randScale);  
        KeyValue kValueY = new KeyValue(circle.scaleYProperty() , randScale);  
        KeyFrame kFrame = new KeyFrame(Duration.millis(5000 + (Math.random() * 5000)) , kValueX , kValueY);  

        createIndefiniteTimeLineAndAnimateForKeyFrameForAutoReverse(kFrame, true);
        
    }

    private void SpaceMoving() {

        ImageView SpaceShip = new ImageView();
        SpaceShip.xProperty().set(-gameWidth/3);
        SpaceShip.translateYProperty().set(gameHeight*5/6);
        
        SpaceShip.setImage(new Image(getClass().getResourceAsStream("spaceShip3.png")));
        
        KeyValue kValueX = new KeyValue(SpaceShip.xProperty(), gameWidth+gameWidth/3);
        KeyFrame kFrame = new KeyFrame(Duration.millis(8000) , kValueX); 
        
        createIndefiniteTimeLineAndAnimateForKeyFrameForAutoReverse(kFrame, true);

        root.getChildren().add(SpaceShip);
        
    }
    
    private void createIndefiniteTimeLineAndAnimateForKeyFrameForAutoReverse(KeyFrame k, boolean autoReverse) {
        
        Timeline t = new Timeline();
        t.getKeyFrames().add(k);  
        t.setAutoReverse(autoReverse);
        t.setCycleCount(Animation.INDEFINITE);
        t.play(); 
        
        
    }

    private void createButtonsForMainMenu(VBox v) {
        
        Button start = this.createButton("START");
        
        start.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                
                stage.setTitle("Space Shooter");
                world = new FirstWorld();
                initCurrWorld();
                
            }
            
        });
        
        Button difficulty = this.createButton("DIFFICULTY");
        
        difficulty.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                
                displayDifficultyMenu();
                
            }
            
        });
        
        Button quit = this.createButton("QUIT");
        
        quit.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                
                System.out.println("Quit button pressed.");
                Platform.exit();
                
            }
            
        });
                
        v.getChildren().addAll(start, difficulty, quit);
        
    }

    private void createDifficultyLabelForMainMenu(VBox v) {

        if (difficultyLabel != null) {
            
            root.getChildren().remove(difficultyLabel);
            difficultyLabel = null;
            
        }
        
        BorderPane b = new BorderPane();
        b.setPrefSize(gameWidth, gameHeight);
        difficultyLabel = b;
        b.setMinWidth(SpaceShooter.gameWidth);
        
        StringBuilder sb = new StringBuilder();
        sb.append("Difficulty: ");
        
        if (SpaceShooter.DIFFICULTY_SETTING == 1) {
            
            sb.append("Easy");
            
        }
        
        else if (SpaceShooter.DIFFICULTY_SETTING == 2) {
            
            sb.append("Medium");
            
        }
        
        else if (SpaceShooter.DIFFICULTY_SETTING == 3) {
            
            sb.append("Hard");
            
        }
        
        Label l = new Label(sb.toString());
        l.setFont(new Font("Arial", 30));
        l.setTextFill(Color.WHITE);
        
        b.setBottom(l);
        root.getChildren().add(b);
                    
    }

}




