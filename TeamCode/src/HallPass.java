/*
Hall pass allows the player to eat hall monitors
Sydney Tran, Meera Kumar, Emily Chen
v1.0
*/

public class HallPass extends Food {
    //here, hasBeenEaten() [from Food] will tell you whether or not the player
    //can eat hall monitors
    
    private static String imagePath; //TODO: set equal to hall pass image path
    private static int pointVal = 100;

    public HallPass() {
        super(imagePath, pointVal);
    }

    public void draw() {

    }
}

