package GUI;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){
        this.setTitle("Hello World");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,420);
        this.setResizable(false);

        ImageIcon image=new ImageIcon("C:\\Users\\Mohamed\\Desktop\\Java Entrem\\untitled\\src\\GUI\\03.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0xFA7070));
        this.setVisible(true);
    }
}
