package Panels;

import javax.swing.*;
import java.awt.*;

public class MAin {
    public static void main(String[] args){
        ImageIcon image=new ImageIcon("C:\\Users\\Mohamed\\Desktop\\Java Entrem\\untitled\\src\\Panels\\pngwing.png");

        JLabel label=new JLabel();
        label.setText("Like Me !");
        label.setIcon(image);
        //label.setBackground(Color.WHITE);
        //label.setHorizontalAlignment(JLabel.LEFT);
        //label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(0,0,200,20);
        //label.setOpaque(true);
        //label.add(label);

        JPanel bluePanel= new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(0,0,250,250);

        JPanel redPanel= new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(250,0,250,250);
        redPanel.add(label);

        JPanel blackPanel= new JPanel();
        blackPanel.setBackground(Color.BLACK);
        blackPanel.setBounds(0,250,500,250);
        //blackPanel.setLayout(new BorderLayout());

        JFrame frame=new JFrame();
        frame.setVisible(true);
        frame.setSize(750,750);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blackPanel.add(label);
        frame.add(redPanel);
        frame.add(blackPanel);
        frame.add(bluePanel);

    }
}
