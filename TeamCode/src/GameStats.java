// Represents current Game Stats

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;

public class GameStats extends JPanel {
    // private JTextField gameNameText;
    // private String currentHighScorer;
    // private int currentHighScore;
    private String highScore;
    // private int yourScore;
    private JLabel yourScoreLabel, highScoreLabel;
    private JavaArcade game;

    // Constructor
    public GameStats(JavaArcade t) {
        super(new GridLayout(2, 4, 10, 0));
        setBorder(new EmptyBorder(0, 0, 5, 0));
        Font gameNameFont = new Font("Monospaced", Font.BOLD, 24);

        JLabel gName = new JLabel(" " + t.getGameName());

        gName.setForeground(Color.red);
        gName.setFont(gameNameFont);
        add(gName);
        highScoreLabel = new JLabel(highScoreText());
        add(highScoreLabel);

        yourScoreLabel = new JLabel(" Your Score: " + 0);
        add(yourScoreLabel);

        Font displayFont = new Font("Monospaced", Font.BOLD, 16);

        game = t;
    }

    public void update(int points) {
        yourScoreLabel.setText(" Your Score: " + points);
    }

    public void gameOver(int points) {
        if (points > game.getHighScore()) {
            yourScoreLabel.setForeground(Color.BLUE);
            highScoreLabel.setForeground(Color.BLUE);
            ((UserPanel) (game)).setHighScore(points);
            String highScorer = (String) JOptionPane.showInputDialog(this,
                    "You are the new high scorer. Congratulations!\n Enter your name: ", "High Score",
                    JOptionPane.PLAIN_MESSAGE, null, null, "name");
            PrintWriter writer;
            try {
                writer = new PrintWriter(new File("highScores.txt"));
                if (!highScorer.equals(null))
                    writer.println("Current High Score: " + highScorer + ", " + points);
                else
                    writer.println("Current High Score: " + points);
                writer.close();
            } catch (FileNotFoundException e) {
                System.out.println("IT'S NOT WRITING");
            }


            highScoreLabel.setText(highScoreText());
        }
        yourScoreLabel.setForeground(Color.BLACK);
        highScoreLabel.setForeground(Color.BLACK);
    }

    private String highScoreText() {
        Scanner fileReader;
        try {
            fileReader = new Scanner(new File("highScores.txt"));
            highScore = fileReader.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("IT'S NOT READING");
        }
        return highScore;
    }
}