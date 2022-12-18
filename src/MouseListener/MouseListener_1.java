package MouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class MouseListener_1 extends JFrame implements MouseListener {
    ImageIcon image=new ImageIcon(Objects.requireNonNull(getClass().getResource("remove.png")));
    ImageIcon image_01=new ImageIcon(Objects.requireNonNull(getClass().getResource("dead.png")));
    ImageIcon image_02=new ImageIcon(Objects.requireNonNull(getClass().getResource("emoji.png")));
    ImageIcon image_03=new ImageIcon(Objects.requireNonNull(getClass().getResource("sad.png")));
    ImageIcon image_04=new ImageIcon(Objects.requireNonNull(getClass().getResource("smiley.png")));
    ImageIcon image_05=new ImageIcon(Objects.requireNonNull(getClass().getResource("meh.png")));
    JLabel label;
    MouseListener_1(){

        label=new JLabel();
        label.setIcon(image_01);
        label.setBounds(-15,-10,500,550);
        //label.setOpaque(true);
        label.addMouseListener(this);

        this.setVisible(true);
        this.setTitle("Test");
        this.setResizable(false);
        this.setSize(500,550);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(image.getImage());
        this.add(label);
    }

    public static void main(String[] args) {
        new MouseListener_1();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");
        label.setIcon(image_02);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
        label.setIcon(image_03);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
        label.setIcon(image_04);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
        label.setIcon(image_05);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
        label.setIcon(image_01);
    }
}
