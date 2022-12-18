package SnakeGame;

import javax.swing.*;

public class SnakeGameBro extends JFrame{
    SnakeGameBro(){
        this.add(new MyPanel());
        this.setTitle("Snake !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
//        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

    }
}
