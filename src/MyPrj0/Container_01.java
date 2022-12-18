package MyPrj0;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Container_01 extends JLabel {
    JButton submitText;
    JTextField inText;
    JLabel money_icon,Text,message_alert,Message;
    int enteredValue;
    Container_01(){

        this.setVisible(true);
        this.setBounds(0,0,500,500);
        this.setLayout(null);

        message_alert=new JLabel("");
        message_alert.setForeground(Color.red);
        message_alert.setFont(new Font("Consolas",Font.BOLD,12));
        message_alert.setBounds(100,350,500,50);

        submitText=new JButton("Submit");
        submitText.setBounds(360,300,100,50);

        inText=new JTextField("");
        inText.setBounds(50,300,300,50);
        inText.setFont(new Font("BV Moli",Font.PLAIN,15));

        money_icon =new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/money.png"))));
        money_icon.setBounds(JLabel.CENTER,0,500,200);

        Text=new JLabel("Laachra Application !");
        Text.setFont(new Font("Consolas",Font.BOLD,15));
        Text.setBounds(160,180,500,60);
        Text.setForeground(new Color(0x1C6758));

        Message=new JLabel("How many People You are ?");
        Message.setFont(new Font("BV Moli",Font.PLAIN,15));
        Message.setBounds(55,250,500,60);

        this.add(submitText);
        this.add(inText);
        this.add(money_icon);
        this.add(Text);
        this.add(Message);
        this.add(message_alert);

    }
}