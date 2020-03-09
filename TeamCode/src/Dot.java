/*
Dot that the player eats, just like in normal Pac-Man
Sydney Tran, Meera Kumar, Emily Chen
v1.0
*/

public class Dot extends Food {
    private static String dotPath; //TODO: set this equal to its image path
    private static int pointVal = 10;

    public Dot(int x, int y, int w, int h) {
        super(x, y, w, h, dotPath, pointVal);
    }
}
