/*
Food that the player eats for points and powerups
Sydney Tran, Meera Kumar, Emily Chen
v1.0
*/

public class Food {
    private String imagePath; //path to image for the food item
    private int pointVal; //how many points the food item is worth
    private boolean eaten; //whether or not it has been eaten (will affect its visibility)

    public Food(String s, int i) {
        imagePath = s;
        pointVal = i;
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