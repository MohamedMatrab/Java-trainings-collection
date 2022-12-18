package Numbers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class simple_main {
    public static void main(String[] args) {

        ArrayList<JLabel> numbers=new ArrayList<JLabel>();
        JFrame frame=new JFrame();

        for (int i=1;i<=7;i++){
            numbers.add(new JLabel(new ImageIcon("src\\Numbers\\"+i+".png")));
            frame.add(numbers.get(i-1));
        }

        frame.setVisible(true);
        frame.setSize(420,420);
        //frame.pack();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
