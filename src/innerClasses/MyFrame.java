package innerClasses;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame {

    JButton button_1=new JButton("Button #1");
    JButton button_2=new JButton("Button #2");
    JButton button_3=new JButton("Button #3");

    MyFrame(){

        button_1.setBounds(100,100,100,100);
        button_2.setBounds(200,100,100,100);
        button_3.setBounds(300,100,100,100);

        button_1.addActionListener(e -> System.out.println("You Pressed Button #1"));
        button_2.addActionListener(e -> System.out.println("You Pressed Button #2"));
        button_3.addActionListener(e -> System.out.println("You Pressed Button #3"));

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.add(button_1);
        this.add(button_2);
        this.add(button_3);

    }

}
