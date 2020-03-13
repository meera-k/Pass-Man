// Represents current Game Stats

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GameStats extends JPanel
{
    private JTextField gameNameText;
    private static String currentHighScorer;
    private static int currentHighScore;
    private int yourScore;
    private JLabel yourScoreText, highScoreText;
    private JavaArcade game;

    // Constructor
    public GameStats(JavaArcade t)
    {
        super(new GridLayout(2, 4, 10, 0));
        setBorder(new EmptyBorder(0, 0, 5, 0));
        Font gameNameFont = new Font("Monospaced", Font.BOLD, 24);

        JLabel gName = new JLabel(" " + t.getGameName());

        gName.setForeground(Color.red);
        gName.setFont(gameNameFont);
        add(gName);
        highScoreText = new JLabel(" Current High Score:   " + t.getHighScore());
        add(highScoreText);

        yourScoreText = new JLabel(" Your Score: " + 0);
        add(yourScoreText);

        Font displayFont = new Font("Monospaced", Font.BOLD, 16);

        game = t;

    }


    public void update(int points)
    {

        yourScoreText.setText(" Your Score: " + points);
        this.points = points;


    }
    public void gameOver(int points)
    {

        if(points > game.getHighScore()){
            //yourScoreText.setForeground(Color.BLUE);
            currentHighScore = points;
            ((UserPanel)(game)).setHighScore(currentHighScore);
            currentHighScorer = (String)JOptionPane.showInputDialog(this, "You are the new high scorer. Congratulations!\n Enter your name: ", "High Score", JOptionPane.PLAIN_MESSAGE, null, null,"name");
            highScoreText.setText(" Current High Score:   " + currentHighScorer + ": " + currentHighScore);
        }

    }
}