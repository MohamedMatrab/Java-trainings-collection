package ConboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JComboBox<String> comboBox;
    Main(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(350,150));
        this.setLayout(new FlowLayout());

        String[] choices={"Mohamed","Laamarty","Boubker"};

        comboBox=new JComboBox<>(choices);
        comboBox.addActionListener(this);
        comboBox.setSelectedIndex(0);

        this.add(comboBox);
        this.setVisible(true);
    }

    public static void main(String[] args) {

        new Main();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==comboBox){
            System.out.println(comboBox.getSelectedItem());
        }
    }
}
