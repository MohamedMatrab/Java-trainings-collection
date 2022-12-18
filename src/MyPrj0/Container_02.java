package MyPrj0;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Container_02 extends JLabel {
    JLabel imageTopLabel = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/networking.png"))));
    JLabel nameLabel,moneyLabel;
    JTextField nameField,moneyField;
    JButton nameButton,moneyButton;
    int numberOfPersons;
    Container_02(){

        imageTopLabel.setBounds(JLabel.CENTER,0,500,200);

        nameLabel=new JLabel("Enter The Name Number 1 :");
        nameLabel.setBounds(100,200,300,40);
        nameLabel.setFont(new Font("Consolas",Font.BOLD,15));
        nameLabel.setForeground(Color.darkGray);

        moneyLabel=new JLabel("How much you Payed :");
        moneyLabel.setBounds(100,290,300,40);
        moneyLabel.setFont(new Font("Consolas",Font.BOLD,15));
        moneyLabel.setForeground(Color.darkGray);
        moneyLabel.setVisible(false);

        moneyField=new JTextField();
        moneyField.setFont(new Font("BV Moli",Font.PLAIN,15));
        moneyField.setBounds(100,330,250,50);
        moneyField.setVisible(false);

        moneyButton=new JButton("Nadi !");
        moneyButton.setFont(new Font("Consolas",Font.BOLD,12));
        moneyButton.setBounds(360,330,80,50);
        moneyButton.setVisible(false);

        nameField=new JTextField();
        nameField.setFont(new Font("BV Moli",Font.PLAIN,15));
        nameField.setBounds(100,240,250,50);

        nameButton=new JButton("Nadi !");
        nameButton.setFont(new Font("Consolas",Font.BOLD,12));
        nameButton.setBounds(360,240,80,50);

        this.setBounds(0,0,500,500);
        this.setLayout(null);
        this.add(imageTopLabel);
        this.add(nameLabel);
        this.add(nameField);
        this.add(moneyLabel);
        this.add(moneyField);
        this.add(moneyButton);
        this.add(nameButton);

    }

}