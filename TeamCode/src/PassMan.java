
import javax.swing.*;
import java.awt.*;

public class PassMan {

    public static void main(String[] args) {

        JFrame arcade = new JFrame();
        arcade.setTitle("Sample GUI with Keyboard and Timer");
        arcade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new UserPanel(600, 450);

        Container pane = arcade.getContentPane();
        pane.setLayout(new GridLayout(1, 1));

        pane.add(panel);

        arcade.pack();
        arcade.setVisible(true);
        panel.requestFocus();
    }

}