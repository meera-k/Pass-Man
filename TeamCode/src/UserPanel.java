
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//UserPanel inherits from JPanel and uses the KeyListener and ActionListener interfaces

public class UserPanel extends JPanel implements KeyListener, ActionListener, JavaArcade {
    int points, highScore;
    private Student student; // active student

    private Timer timer; // controls how often we updated the x, y pos of enemies and how often we
                                     // repaint
    //private javax.swing.Timer pointsTimer; // controls how often our points value change

    private HallMonitor enemy;
    
    private Map map;

    private boolean start = false;
    private int x, y;

    private Direction direction;

    private boolean canMove;

    public UserPanel(int width, int height) {

        Color backColor = Color.black;

        int playerHeight, playerWidth, enemyWidth, enemyHeight, enemyX, enemyY;

        // Make hero proportional to height/width of panel.

        playerHeight = height / 22;
        playerWidth = width / 27;

        enemy = new HallMonitor(100,51,2);

        map = new Map(width, height);

        points = 0;

        student = new Student(201,51,4);

        // Status check every 50 milliseconds
        timer = new javax.swing.Timer(50, this);

        // Timer invoked every 3 seconds, just a demo of using 2 timers - currently
        // points value decrease
        // pointsTimer = new javax.swing.Timer(3000, new PointsListener());
        // addMouseListener(new PanelListener());
        // addMouseMotionListener(new PanelMotionListener());

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(backColor);

        setPreferredSize(new Dimension(width, height));
        
        canMove = true;

    }

    public void initializeChars() {
        enemy = new HallMonitor(100,51,2);

        points = 0;

        student = new Student(201,51,4);
        
        addKeyListener(this);// used for key controls
        
        direction = Direction.NONE;
    }
    public void endChars() {
        enemy = null;
        student = null;
        removeKeyListener(this);
        direction = Direction.NONE;
    }

    /* This method should return true if your game is in a "start" state, it should return false if
     * your game is in a "paused" state or "stopped" or "unstarted" */

    public boolean running() {
        return start;
    }

    /* This method should start your game, it should also set a global boolean value so that your running method
     * can return the appropriate value */

    public void startGame() {
        initializeChars();
        timer.start();
        start = true;
    }

    /*This method should return the name of your game */
    public String getGameName() {
        return "Pass-Man";
    }

    /* This method should stop your timers but save your score, it should set a boolean value to indicate
     *the game is not running, this value will be returned by running method */

    public void pauseGame() {
        timer.stop();
        start = false;
    }

    /* This method should return your instructions */
    public String getInstructions() {
        //TODO: Implement
        return "";
    }

    /* This method should return the author(s) of the game */
    public String getCredits() {
        //TODO: Implement
        return "";
    }

    /* This method should return the highest score played for this game */
    public int getHighScore() {
        //TODO: Implement
        return highScore;
    }

    public void setHighScore(int i) {
        highScore = i;
    }

    /* This method should stop the timers, reset the score, and set a running boolean value to false */
    public void stopGame() {
        //TODO: Implement
        timer.stop();
        points = 0;
        start = false;
    }

    /* This method shoud return the current players number of points */

    public int getPoints() { //add to spec
        return points;
    }

    /* This method provides access to GameStats display for UserPanel to pass information to update score
    GameStats is created in Arcade, a reference should be passed to UserPanel (main panel) to update points */
    public void setDisplay(GameStats d) {
        //TODO: Implement
        d.update(points);
    }

    public boolean checkWall(int x, int y) {
        return map.isWall(x, y);
    }

    public void actionPerformed(ActionEvent e) { // invoked when timer expires every 50ms
        checkStats();
        repaint(); // ensures PaintComponent is called
    }

    // Because we implemented KeyListener interface, we must define these key
    // methods
    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            // case KeyEvent.VK_ENTER:// actions performed if enter key is pressed
            //     timer.start();
            //     //pointsTimer.start();

            //     start = true;

            //     break;
            case KeyEvent.VK_SPACE:// actions performed if enter key is pressed

                break;
            // case KeyEvent.VK_I:
            //     enemy.setVelocity(enemy.getVelocity() + 10);
            //     break;
            // case KeyEvent.VK_D:
            //     enemy.setVelocity(enemy.getVelocity() - 10);
            //     break;

            case KeyEvent.VK_LEFT:// actions performed if enter key is pressed
                direction = Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:// actions performed if enter key is pressed
                direction = Direction.RIGHT;
                break;
            case KeyEvent.VK_UP:// actions performed if enter key is pressed
                direction = Direction.UP;
                break;
            case KeyEvent.VK_DOWN:// actions performed if enter key is pressed
                direction = Direction.DOWN;
                break;

            case KeyEvent.VK_ESCAPE:// actions performed if escape key is pressed
                System.exit(0);

                break;
            default:

        }

    }

    // draws everything

    public void paintComponent(Graphics g) {

        super.paintComponent(g); // a call to JPanel's paintComponent

        // Draw heroes
        student.draw(g);
        ImageIcon bagel = new ImageIcon("graphics/bagel.png");
        g.drawImage(bagel.getImage(),100,100,null);

        // Draw enemies
        enemy.draw(g);

        map.draw(g);

        g.setColor(Color.white);
        g.drawString("Points: " + points, 20, getHeight() - 30);

        if (!start) {// shows instructions in the beginning
            g.drawString("Instructions: ... write stuff here", (getWidth() / 2) - 100, getHeight() / 2 + 20);
            g.drawString("(Inactive) Press enter to shoot .", (getWidth() / 2) - 100, getHeight() / 2 + 40);
            g.drawString("You have 3 lives to kill the enemy", (getWidth() / 2) - 100, getHeight() / 2 + 60);
        }

    }

    // Invoked by PointsTimer to show how you handle two timers. Need to create this
    // private class
    // to implement another ActionListener
    private class PointsListener implements ActionListener {

        // Because we are implementing ActionListener, we must define actionPerformed
        public void actionPerformed(ActionEvent e) {

            //points--; // Every 3 seconds, lose a point - motivate to win faster

        }
    }

    private void checkStats() { // called every 50ms, checks status of targets and hero

        // Set the width in case the panel gets resized. All enemies share this value,
        // therefore it is
        // static and its corresponding static method is called using the class name.

        Character.setPanelWidth(getWidth()); // update static field so all Circle objects know current panel width
        Character.setPanelHeight(getHeight());
        enemy.move(student.getX(), student.getY());
        switch(direction) {
            case LEFT:
                if (!checkWall(student.getX() - 1, student.getY()) && !checkWall(student.getX() - 1, student.getY() + 44 + 1))
                    student.moveLeft();
                break;
            case RIGHT:
                if (!checkWall(student.getX() + 1 + 26, student.getY()) && !checkWall(student.getX() + 1 + 26, student.getY() + 44 + 1))
                    student.moveRight();
                break;
            case UP:
                if (!checkWall(student.getX(), student.getY() - 1) && !checkWall(student.getX() + 26 + 1, student.getY() - 1))
                    student.moveUp();
                break;
            case DOWN:
                if (!checkWall(student.getX(), student.getY() + 1 + 44) && !checkWall(student.getX() + 26 + 1, student.getY() + 1 + 44))
                    student.moveDown();
                break;
        }
    }

    private class PanelListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            // x = e.getX();
            // y = e.getY();
            // System.out.println("x : " + x + " y: " + y);
            // if (student.containsPoint(x, y)) {
            //     System.out.println("true");
            //     selectedCircle = student;
            // }
        }

        public void mouseReleased(MouseEvent e) {
            // x = e.getX(); // what happens if these are removed?
            // y = e.getY();
            // selectedCircle = null;
        }

    }

    private class PanelMotionListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            // int newX = e.getX();
            // int newY = e.getY();
            // int dx = newX - x;
            // int dy = newY - y;
            // if (selectedCircle != null) {
            //     selectedCircle.moveMouse(dx, dy);
            //     System.out.println("moving");
            // }
            // x = newX;
            // y = newY;
            // // repaint();
        }
    }
}
