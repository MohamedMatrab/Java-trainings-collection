package radioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JRadioButton pizzaButton,hamburgerButton,hotdogButton;
    Main(){

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(300,80));

        pizzaButton=new JRadioButton("Pizza");
        pizzaButton.addActionListener(this);
        hamburgerButton=new JRadioButton("Hamburger");
        hamburgerButton.addActionListener(this);
        hotdogButton=new JRadioButton("hot Dog");
        hotdogButton.addActionListener(this);

        ButtonGroup group=new ButtonGroup();
        group.add(pizzaButton);
        group.add(hotdogButton);
        group.add(hamburgerButton);

        this.add(pizzaButton);
        this.add(hamburgerButton);
        this.add(hotdogButton);

    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pizzaButton){
            System.out.println("You selected a pizza !");
        }
        else if(e.getSource()==hamburgerButton){
            System.out.println("You selected a hamburger !");
        }
        else if(e.getSource()==hotdogButton){
            System.out.println("You selected a Hotdog !");
        }
    }
}
