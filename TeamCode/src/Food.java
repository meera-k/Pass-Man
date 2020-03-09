/*
Food that the player eats for points and powerups
Sydney Tran, Meera Kumar, Emily Chen
v1.0
*/

import java.awt.*;
import javax.swing.*;

public class Food extends Drawable {
    private String imagePath; //path to image for the food item
    private int pointVal; //how many points the food item is worth
    private boolean eaten; //whether or not it has been eaten (will affect its visibility)

    public Food(int x, int y, int w, int h, String imagePath, int pointVal) {
        super(x, y, w, h);
        this.imagePath = imagePath;
        this.pointVal = pointVal;
        eaten = false;
    }
    
    public String getImagePath() {
        return imagePath;
    }

    //may not be necessary in gameplay
    public int getPointVal() {
        return pointVal;
    }

    public boolean hasBeenEaten() {
        return eaten;
    }

    public int eat() {
        eaten = true;
        return pointVal;
    }
}