package CheckBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Main extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    Main(){

        ImageIcon correct=new ImageIcon(Objects.requireNonNull(Main.class.getResource("correct.png")));
        ImageIcon x_icon=new ImageIcon(Objects.requireNonNull(Main.class.getResource("remove.png")));

        button=new JButton("Submit !");
        button.addActionListener(this);

        checkBox=new JCheckBox();
        checkBox.setText("Not Ok !");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas",Font.PLAIN,35));
        checkBox.setIcon(x_icon);
        checkBox.setSelectedIcon(correct);


        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(350,120));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(button);
        this.add(checkBox);

    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println(checkBox.isSelected());
        }
    }
}
