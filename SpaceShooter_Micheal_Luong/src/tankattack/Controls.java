package tankattack;

public class Controls {
    
    public static boolean upPressed, downPressed, leftPressed, rightPressed;
    public static boolean spacePressed;
    
    public static double[] returnArray;    

    public static double[] getNewXY(double[] currPosition, double itemWidth, double itemHeight, double multiplier) {
        
        // Always returns double[2], array[0] = x, array[1]
                
        if (returnArray == null) {
            
            returnArray = new double[2];
            
        }

        double[] returnArray = new double[2];
        
        if (!upPressed && !downPressed && !leftPressed && !rightPressed) {
            // 0000
            returnArray[0] = 0.0;
            returnArray[1] = 0.0;
        }
        
        else if (!upPressed && !downPressed && !leftPressed && rightPressed) {
            // 0001
            returnArray[0] = 1.0;
            returnArray[1] = 0.0;
        }
        
        else if (!upPressed && !downPressed && leftPressed && !rightPressed) {
            // 0010
            returnArray[0] = -1.0;
            returnArray[1] = 0.0;
        }
        
        else if (!upPressed && !downPressed && leftPressed && rightPressed) {
            // 0011
            returnArray[0] = 0.0;
            returnArray[1] = 0.0;
        }
        
        else if (!upPressed && downPressed && !leftPressed && !rightPressed) {
            // 0100
            returnArray[0] = 0.0;
            returnArray[1] = 1.0;
        }
        
        else if (!upPressed && downPressed && !leftPressed && rightPressed) {
            // 0101
            returnArray[0] = 0.70710678118;
            returnArray[1] = 0.70710678118;
        }
        
        else if (!upPressed && downPressed && leftPressed && !rightPressed) {
            // 0110
            returnArray[0] = -0.70710678118;
            returnArray[1] = 0.70710678118;
        }
        
        else if (!upPressed && downPressed && leftPressed && rightPressed) {
            // 0111
            returnArray[0] = 0.0;
            returnArray[1] = 0.70710678118;
        }
        
        else if (upPressed && !downPressed && !leftPressed && !rightPressed) {
            // 1000
            returnArray[0] = 0.0;
            returnArray[1] = -1.0;
        }
        
        else if (upPressed && !downPressed && !leftPressed && rightPressed) {
            // 1001
            returnArray[0] =  0.70710678118;
            returnArray[1] = -0.70710678118;
        }
        
        else if (upPressed && !downPressed && leftPressed && !rightPressed) {
            // 1010
            returnArray[0] = -0.70710678118;
            returnArray[1] = -0.70710678118;
        }
        
        else if (upPressed && !downPressed && leftPressed && rightPressed) {
            // 1011
            returnArray[0] = 0.0;
            returnArray[1] = -1.0;
        }
        
        else if (upPressed && downPressed && !leftPressed && !rightPressed) {
            // 1100
            returnArray[0] = 0.0;
            returnArray[1] = 0.0;
        }
        
        else if (upPressed && downPressed && !leftPressed && rightPressed) {
            // 1101
            returnArray[0] = 1.0;
            returnArray[1] = 0.0;
        }
        
        else if (upPressed && downPressed && leftPressed && !rightPressed) {
            // 1110
            returnArray[0] = -1.0;
            returnArray[1] =  0.0;
        }
        
        else if (upPressed && downPressed && leftPressed && rightPressed) {
            // 1111
            returnArray[0] = 0.0;
            returnArray[1] = 0.0;
        }
        
        // Speed
        returnArray[0] = returnArray[0] * multiplier;
        returnArray[1] = returnArray[1] * multiplier;
                
        returnArray = Controls.checkBounds(returnArray, currPosition, itemWidth, itemHeight);
        
        return returnArray;
        
    }
    
    public static double[] checkBounds(double[] increments, double[] currPosition, double itemWidth, double itemHeight) {
                        
        // Up Boundary
        if (currPosition[1] + increments[1] <= 0) {
            
            increments[1] = 0;
            
        }
        
        // Down Boundary
        if (currPosition[1] + increments[1] + itemHeight >= SpaceShooter.gameHeight) {
            
            increments[1] = 0;
            
        }
        
        // Left Boundary
        if (currPosition[0] + increments[0] <= 0) {
            
            increments[0] = 0;
            
        }
        
        // Right Boundary
        if (currPosition[0] + increments[0] + itemWidth >= SpaceShooter.gameWidth) {
            
            increments[0] = 0;
            
        }
                
        currPosition[0] = currPosition[0] + increments[0];
        currPosition[1] = currPosition[1] + increments[1];
                
        return currPosition;
        
    }
    
}
