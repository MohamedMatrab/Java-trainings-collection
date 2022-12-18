package Bottons;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JTextField field;
    MyFrame(){

        ImageIcon icon=new ImageIcon("C:\\Users\\Mohamed\\Desktop\\Java Entrem\\untitled\\src\\Panels\\pngwing.png");

        button=new JButton();
        button.setBounds(125,125,250,200);
        button.addActionListener(this);
        button.setText("Taper !");
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic sans",Font.BOLD,25));
        button.setIconTextGap(-5);
        button.setForeground(Color.RED);
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createEtchedBorder());

        field=new JTextField();
        field.setVisible(true);
        field.setText("Hello");
        field.setBounds(JTextField.CENTER,JTextField.TOP,100,50);
        //field.setEditable(false);


        this.setVisible(true);
        //this.setTitle(field.getText());
        this.setSize(500,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(button);
        this.add(field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("poo !");
            button.setEnabled(false);
            field.setFont(field.getFont().deriveFont(Font.BOLD));
        }
    }
}
