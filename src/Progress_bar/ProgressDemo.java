package Progress_bar;

import javax.swing.*;
import java.awt.*;

public class ProgressDemo {
    JFrame frame;
    JProgressBar bar;

    ProgressDemo(){
        frame=new JFrame("Progress Bar !");
        bar=new JProgressBar();

        bar.setValue(0);
        bar.setBounds(0,0,420,100);
        //bar.setForeground(Color.RED);
        //bar.setBackground(Color.GRAY);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli",Font.BOLD,22));

        frame.setVisible(true);
        frame.setSize(new Dimension(420,420));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(bar);

        fill();
    }

    public static void main(String[] args) {
        new ProgressDemo();
    }
    public void fill(){
        int counter=0;

        while (counter<=100){
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            counter+=1;
        }
        bar.setString("Done !");
    }
}
