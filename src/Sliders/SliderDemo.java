package Sliders;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SliderDemo implements ChangeListener {
    JFrame frame;
    JLabel label;
    JPanel panel;
    JSlider slider;
    SliderDemo(){
        frame=new JFrame();
        label=new JLabel();
        panel=new JPanel();
        slider=new JSlider(0,100,30);

        slider.setPreferredSize(new Dimension(400,200));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(20);

        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.addChangeListener(this);

        label.setText("~C = "+slider.getValue());
        label.setFont(new Font("MV Boli",Font.PLAIN,25));

        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        new SliderDemo();

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource()==slider)
            label.setText("~C = "+slider.getValue());
    }
}
