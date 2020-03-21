// Represents a control panel for the arcade

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
// import java.awt.Component;
// import java.awt.Container;
import javax.swing.Box;
import javax.swing.*;

import java.util.Timer;
import java.util.TimerTask;

public class ControlPanel extends JPanel
        implements ActionListener
{
    private JavaArcade game;
    private GameStats gStats;
    private JButton startButton, pauseButton, stopButton, instructionsButton, creditsButton;
    private boolean isStopped = false;
    private Timer timer;

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
    }

    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                gStats.update(game.getPoints());
                if (((UserPanel)(game)).isOver()) {
                    pauseTimer();
                }
            }
        }, 0, 10);

    }

    private void pauseTimer() {
        callEndMessage();
        timer.cancel();
        
        isStopped = true;
        game.stopGame();

        gStats.gameOver(game.getPoints());
        
        gStats.repaint();
        startButton.setEnabled(true);
        ((UserPanel)(game)).endChars();
        startButton.setText("Restart");
        repaint();
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
                isStopped = false;
                ((JPanel)(game)).requestFocus(); //need to provide the JPanel focus
                ((UserPanel)(game)).startGame(starting_over);
                gStats.update(game.getPoints());
                gStats.repaint();
                startButton.setText("Resume");
            }
            
            startTimer();
        }
        else if(button == pauseButton)
        {
            if (!isStopped) {
                private_pause();
                //MK - this tests the scoring
                gStats.update(game.getPoints());
            }

        }
        else if(button == stopButton)
        {
            isStopped = true;
            game.stopGame();
            callEndMessage();

            gStats.gameOver(game.getPoints());
            gStats.repaint();
            startButton.setEnabled(true);
            ((UserPanel)(game)).endChars();
            startButton.setText("Restart");
            repaint();
        }
        else if(button == creditsButton)
        {
            //private_pause();
            String credits = game.getCredits();
            JOptionPane.showMessageDialog(this, credits, "Game Credits", JOptionPane.PLAIN_MESSAGE);

        }
        else if(button == instructionsButton)
        {
            //private_pause();
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

    private void callEndMessage() {
        if (((UserPanel)(game)).lost()) {
            JOptionPane.showMessageDialog(this, "You lost :( \nGood game!", "YOU LOST", JOptionPane.PLAIN_MESSAGE);
            ((JPanel)(game)).requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "You beat Sharon :) \nGood game!", "YOU WON", JOptionPane.PLAIN_MESSAGE);
            ((JPanel)(game)).requestFocus();
        }
    }

}
