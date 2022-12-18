package lebels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MAin_02 {
    public static void main(String[] args){

        ImageIcon image=new ImageIcon("C:\\Users\\Mohamed\\Desktop\\Java Entrem\\untitled\\src\\lebels\\programmer.png");

        Border border= BorderFactory.createLineBorder(new Color(0xCD104D));

        JLabel label=new JLabel();
        label.setText("Bro Do You even Code !\n");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0x937DC2));
        label.setFont(new Font("MV Boli",Font.BOLD,30));
        label.setIconTextGap(20);
        label.setBackground(Color.GREEN);
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0,0,250,250);

        JFrame frame=new JFrame();
        frame.setTitle("Hello");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.add(label);

    }
}
