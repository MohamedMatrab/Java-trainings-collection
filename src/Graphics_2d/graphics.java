package Graphics_2d;

import javax.swing.*;

public class graphics extends JFrame{

    MyPanel panel;

    graphics(){

        panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new graphics();
    }
}