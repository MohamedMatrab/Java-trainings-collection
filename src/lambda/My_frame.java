package lambda;

import javax.swing.*;

public class My_frame extends JFrame {

    JButton myButton_1 =new JButton("My Button !");
    JButton myButton_2 =new JButton("My Button !");

    My_frame(){

        myButton_1.setBounds(100,100,200,100);
        myButton_1.addActionListener(
                (e)-> System.out.println("I am Mohamed !")
        );
        myButton_2.setBounds(100,200,200,100);
        myButton_2.addActionListener(
                (e)-> System.out.println("I am Oussama !")
        );

        this.add(myButton_2);
        this.add(myButton_1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);

    }
}