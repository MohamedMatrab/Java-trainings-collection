package ColorChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooser extends JFrame implements ActionListener {

    JButton button,backButton;
    JLabel label;
    ColorChooser(){
        backButton=new JButton("background Button");
        backButton.addActionListener(this);

        button=new JButton("Select Color !");
        button.addActionListener(this);

        label=new JLabel("Hello Every Single One Of You !");
        label.setBackground(Color.BLACK);
        label.setForeground(Color.LIGHT_GRAY);
        label.setFont(new Font("MV Boli",Font.PLAIN,22));
        label.setOpaque(true);

        this.setSize(500,100);
        this.setLayout(new FlowLayout());
        //this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(button);
        this.add(backButton);
        this.add(label);
    }

    public static void main(String[] args) {
        new ColorChooser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            Color color=JColorChooser.showDialog(null,"Choose Color",Color.WHITE);
            label.setForeground(color);
        }
        if (e.getSource()==backButton){
            Color color=JColorChooser.showDialog(null,"Choose Color",Color.WHITE);
            label.setBackground(color);
        }
    }
}
