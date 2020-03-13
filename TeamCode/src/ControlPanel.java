// Represents a control panel for the arcade

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Container;
import javax.swing.Box;
import javax.swing.*;

public class ControlPanel extends JPanel
        implements ActionListener
{
    private JavaArcade game;
    private GameStats gStats;
    private JButton startButton, pauseButton, stopButton, instructionsButton, creditsButton;
    private int points;

    // Constructor
    public ControlPanel(JavaArcade t, GameStats g)
    {
        game = t;
        gStats = g;

        instructionsButton = new JButton("Instructions");
        instructionsButton.addActionListener(this);
        add(instructionsButton);
        add(Box.createHorizontalStrut(80));
        startButton = new JButton("Start");
        startButton.addActionListener(this);

        add(startButton);

        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(this);
        add(pauseButton);
        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        add(stopButton);
        add(Box.createHorizontalStrut(80));
        creditsButton = new JButton("Credits");
        creditsButton.addActionListener(this);
        add(creditsButton);
        points = 0;

    }

    // Called when the start button is clicked
    public void actionPerformed(ActionEvent e)
    {

        JButton button = (JButton)e.getSource();

        if (button == startButton)
        {
            boolean starting_over = true;
            if (startButton.getText().equals("Resume")) {
                starting_over = false;
            }
            if (!game.running())
            {

                ((JPanel)(game)).requestFocus(); //need to provide the JPanel focus
                ((UserPanel)(game)).startGame(starting_over);
                //TODO: THIS RIGHT HERE IS A TEST
                //gStats.update(0);
                gStats.repaint();
            }

        }
        else if(button == pauseButton)
        {
            private_pause();
            //TODO: THIS RIGHT HERE IS ANOTHER TEST
            points+= 10;
            gStats.update(points);

        }
        else if(button == stopButton)
        {
            game.stopGame();
            gStats.gameOver(game.getPoints());
            gStats.repaint();
            startButton.setEnabled(true);
            ((UserPanel)(game)).endChars();
            startButton.setText("Restart");
            repaint();
        }
        else if(button == creditsButton)
        {
            private_pause();
            String credits = game.getCredits();
            JOptionPane.showMessageDialog(this, credits, "Game Credits", JOptionPane.PLAIN_MESSAGE);

        }
        else if(button == instructionsButton)
        {
            private_pause();
            String instructions = game.getInstructions();
            JOptionPane.showMessageDialog(this, instructions, "Game Rules", JOptionPane.PLAIN_MESSAGE);

        }
        ((JPanel)(game)).requestFocus();
    }

    private void private_pause() {
        game.pauseGame();
        startButton.setText("Resume");
        startButton.setEnabled(true);
        repaint();
    }

}
