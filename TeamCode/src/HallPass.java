/*
Hall pass allows the player to eat hall monitors
Sydney Tran, Meera Kumar, Emily Chen
v1.0
*/

import javax.swing.*;
import java.awt.*;

public class HallPass extends Food {
    //here, hasBeenEaten() [from Food] will tell you whether or not the player
    //can eat hall monitors
    
    private static final String imagePath = "Pass-Man Drawings/pass.png";
    private static final int pointVal = 100;

    public HallPass(int x, int y, int w, int h) {
        super(x, y, w, h, imagePath, pointVal);
    }

    public void draw(Graphics g) {
    }
}