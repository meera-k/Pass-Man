
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//UserPanel inherits from JPanel and uses the KeyListener and ActionListener interfaces

public class UserPanel extends JPanel implements KeyListener, ActionListener, JavaArcade {
    int points, highScore;
    private Student student; // active student

    private Timer timer; // controls how often we updated the x, y pos of enemies and how often we
                                     // repaint

    private int hallPassTimer;

    private HallMonitor[] enemies;

    private ArrayList<HallPass> passes;

    private ArrayList<Dot> dots;

    private Map map;

    private boolean start = false;
    private int x, y;
    private int width, height;

    private Direction direction;

    private boolean power;

    public UserPanel(int width, int height) {

        this.width = width;
        this.height = height;

        Color backColor = Color.black;

        int playerHeight, playerWidth, enemyWidth, enemyHeight, enemyX, enemyY;

        // Make hero proportional to height/width of panel.

        playerHeight = height / 22;
        playerWidth = width / 27;

        enemies = new HallMonitor[4];
        enemies[0] = new Sharon(101,51,2);

        //enemies[0] = new Sharon(101,51,2);
        enemies[0] = new HallMonitor1(101,51,2);
        enemies[1] = new Sharon(651,251,2);
        enemies[2] = new Sharon(251,351,2);
        enemies[3] = new Sharon(width - 101 - 26,height - 51 - 44,2);

        passes = new ArrayList<HallPass>(4);
        passes.add(new HallPass(125,height - 50 - 25));
        passes.add(new HallPass(width - 100 - 25,75));
        passes.add(new HallPass(475,275));
        passes.add(new HallPass(475,375));

        map = new Map(width, height);

        dots = new ArrayList<Dot>();
        for(int x = 25; x < width - 25 ; x += 50) {
            for(int y = 25; y < height - 25; y += 50) {
                if(!checkWall(x, y)) {
                    if (!((x == 275 && y == 275) || (x == 125 && y == 575) || (x == 825 && y == 75) || (x == 475 && y == 275) || (x == 475 && y == 375))) {
                        dots.add(new Dot(x, y));
                    }
                }
            }
        }

        points = 0;

        student = new Student(201,51,4);

        power = false;

        // Status check every 50 milliseconds
        timer = new javax.swing.Timer(50, this);

        hallPassTimer = 0;

        // Timer invoked every 3 seconds, just a demo of using 2 timers - currently
        // points value decrease
        // hallPassTimer = new javax.swing.Timer(3000, new PointsListener());
        // addMouseListener(new PanelListener());
        // addMouseMotionListener(new PanelMotionListener());

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(backColor);

        setPreferredSize(new Dimension(width, height));
        addKeyListener(this);// used for key controls

        highScore = 0;

    }

    public void startGame() {

    }

    //intitialize and end are used to restart the game
    public void initializeChars() {

        enemies[0] = new HallMonitor1(101,51,2);
        enemies[1] = new Sharon(651,251,2);
        enemies[2] = new Sharon(251,351,2);
        enemies[3] = new Sharon(width - 101 - 26,height - 51 - 44,2);

        passes.add(new HallPass(125,height - 50 - 25));
        passes.add(new HallPass(width - 100 - 25,75));
        passes.add(new HallPass(475,275));
        passes.add(new HallPass(475,375));

        points = 0;

        student = new Student(201,51,4);

        power = false;

        hallPassTimer = 0;
        
        direction = Direction.NONE;

        dots = new ArrayList<Dot>();
        for(int x = 25; x < width - 25 ; x += 50) {
            for(int y = 25; y < height - 25; y += 50) {
                if(!checkWall(x, y)) {
                    if (!((x == 275 && y == 275) || (x == 125 && y == 575) || (x == 825 && y == 75) || (x == 475 && y == 275) || (x == 475 && y == 375))) {
                        dots.add(new Dot(x, y));
                    }
                }
            }
        }
    }

    public void endChars() {
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = null;
        }
        student = null;
        direction = Direction.NONE;

        for (int i = 0; i < dots.size(); i++) {
            dots.remove(0);
        }
    }

    /* This method should return true if your game is in a "start" state, it should return false if
     * your game is in a "paused" state or "stopped" or "unstarted" */

    public boolean running() {
        return start;
    }

    /* This method should start your game, it should also set a global boolean value so that your running method
     * can return the appropriate value */

    public void startGame(boolean start_over) {
        if (start_over) {
            initializeChars();
            points = 0;
        }
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
        //MK - this tests the scoring
        points+=10;
    }

    /* This method should return your instructions */
    public String getInstructions() {
        return "Use the arrow keys to move, and whatever you do, avoid Sharon!\n(Eat dots and snacks to earn points. Hall passes let you eat Sharon!)";
    }

    /* This method should return the author(s) of the game */
    public String getCredits() {
        return "v1.0\nSydney Tran, Meera Kumar, Emily Chen";
    }

    /* This method should return the highest score played for this game */
    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int i) {
        highScore = i;
    }

    /* This method should stop the timers, reset the score, and set a running boolean value to false */
    public void stopGame() {
        timer.stop();
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

    public void updateDots(int x, int y) {
        for(int i = 0; i < dots.size(); i++) {
            if(dots.get(i).getX() >= x && dots.get(i).getX() <= x + 26 && dots.get(i).getY() >= y && dots.get(i).getY() <= y + 44) {
                dots.remove(i);
                points += 10;
            }
        }
    }

    public void updatePass(int x, int y) {
        for(int i = 0; i < passes.size(); i++) {
            if(passes.get(i).getX() >= x && passes.get(i).getX() <= x + 26 && passes.get(i).getY() >= y && passes.get(i).getY() <= y + 44) {
                passes.remove(i);
                points += 100;
                power = true;
            }
        }
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

        ImageIcon bagel = new ImageIcon("graphics/bagel.png");
        g.drawImage(bagel.getImage(),100,100,null);

        map.draw(g);

        for (Dot d : dots) {
            d.draw(g);
        }

        // Draw heroes
        student.draw(g);

        // Draw enemies
        for (HallMonitor e : enemies) {
            e.draw(g);
        }

        for (HallPass p : passes) {
            p.draw(g);
        }

        g.setColor(Color.white);


        // if (!start) {// shows instructions in the beginning
        //     g.drawString("Instructions: ... write stuff here", (getWidth() / 2) - 100, getHeight() / 2 + 20);
        //     g.drawString("(Inactive) Press enter to shoot .", (getWidth() / 2) - 100, getHeight() / 2 + 40);
        //     g.drawString("You have 3 lives to kill the enemy", (getWidth() / 2) - 100, getHeight() / 2 + 60);
        // }

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
        for (HallMonitor e : enemies) {
            e.move(student.getX(), student.getY(), map);
        }
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

        updateDots(student.getX(), student.getY());

        updatePass(student.getX(), student.getY());

        if (power) {
            if (hallPassTimer < 200) {
                hallPassTimer++;
            }
            else {
                power = false;
                hallPassTimer = 0;
            }
        }

        if (dots.size() == 0) {
            stopGame();
            //add game over
        }

        for (HallMonitor e : enemies) {
            if(e.getX() + 13 >= student.getX() && e.getX() + 13 <= student.getX() + 26 && e.getY() + 22 >= student.getY() && e.getY() + 22 <= student.getY() + 44) {
                if (!power) {
                    stopGame();
                    //add game over
                }
            }
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
