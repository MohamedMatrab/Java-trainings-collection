package KeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class Class extends JFrame implements KeyListener {
    JLabel label;
    JLabel test;
    Class(){

        ImageIcon imageIcon=new ImageIcon(Objects.requireNonNull(getClass().getResource("remove.png")));

        label =new JLabel();
        label.setBounds(100,150,100,100);
        //label.setIcon(imageIcon);
        label.setBackground(Color.red);
        label.setOpaque(true);

        test=new JLabel();
        test.setBounds(0,0,100,100);
        test.setBackground(Color.BLACK);
        test.setOpaque(true);

        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);
        this.add(label);
        this.add(test);

    }

    public static void main(String[] args) {
        new Class();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'a':label.setLocation(label.getX()-10,label.getY());
            break;
            case 's':label.setLocation(label.getX(),label.getY()+10);
                break;
            case 'w':label.setLocation(label.getX(),label.getY()-10);
                break;
            case 'd':label.setLocation(label.getX()+10,label.getY());
                break;
        }
        if(label.getX()==test.getX() && label.getY()==test.getY() ){
            System.out.println("You Won The Game !");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 37 :label.setLocation(label.getX()-10,label.getY());
                break;
            case 40 :label.setLocation(label.getX(),label.getY()+10);
                break;
            case 38 :label.setLocation(label.getX(),label.getY()-10);
                break;
            case 39 :label.setLocation(label.getX()+10,label.getY());
                break;
        }
        if(label.getX()==test.getX() && label.getY()==test.getY() ){
            System.out.println("You Won The Game !");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
